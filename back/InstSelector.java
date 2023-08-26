package back;
import java.util.HashMap;
import Utils.*;
import assembly.inst.*;
import IR.*;
import IR.inst.*;
import assembly.*;
import assembly.operand.*;
import IR.entity.*;
import IR.IRtype.*;

public class InstSelector implements BuiltinElements, IRVisitor{
    ASMModule module;
    ASMBlock curBlock;
    ASMFunction curFunc;
    
    HashMap<IRbasicblock, ASMBlock> blockMap = new HashMap<>();
    int blockCnt = 0;


    public InstSelector(ASMModule module) {
        this.module = module;
    }

    Reg getReg(IREntity entity) {
        if (entity.asmReg == null) {
            if (entity instanceof IRRegister)
                entity.asmReg = new VirtualReg(entity.type.size);
            else if (entity instanceof IRConst)
                entity.asmReg = new VirtualImm((IRConst) entity);
        }
        return entity.asmReg;
    }
    void loadReg(int size, Reg dest, Reg src, int offset) {//从src+offset处取东西存入dest
        if (offset < 1 << 11)
            curBlock.addInst(new ASMLoadInst(size, dest, src, new Imm(offset)));
        else {
            VirtualReg tmp = new VirtualReg(4);
            curBlock.addInst(new ASMBinaryInst("add", tmp, src, new VirtualImm(offset)));
            curBlock.addInst(new ASMLoadInst(size, dest, tmp));
        }
    }
    void storeReg(int size, Reg value, Reg dest, int offset) {//往dest+offset处存入value
        if (offset < 1 << 11)
            curBlock.addInst(new ASMStoreInst(size, dest, value, new Imm(offset)));
        else {
            VirtualReg tmp = new VirtualReg(4);//创建一个虚拟寄存器
            curBlock.addInst(new ASMBinaryInst("add", tmp, dest, new VirtualImm(offset)));
            curBlock.addInst(new ASMStoreInst(size, tmp, value));
        }
    }

    public void visit(IRprogram node) {
        for(var def : node.gVariables) {//添加全局变量
            def.asmReg = new GlobalValue(def);
            module.globalValues.add((GlobalValue) def.asmReg);
        }
        for(var def : node.stringConst.values()){//添加字符串常量
            GlobalString globalStr = new GlobalString(".str." + String.valueOf(def.id), def.val);
            module.globalStrings.add(globalStr);
            def.asmReg = globalStr;
        }
        for(var def : node.functions){
            curFunc = new ASMFunction(def.name);
            module.functions.add(curFunc);
            def.accept(this);
        }
    }

    public void visit(IRbasicblock node) {
        for(var inst : node.insts)inst.accept(this);
        node.terminalInst.accept(this);
    }

    public void visit(IRfunction node) {
        blockMap.clear();
        VirtualReg.cnt = 0;
        int maxArgCnt = 0;
        for (IRbasicblock blk : node.blocklist) {
            blockMap.put(blk, new ASMBlock(".L" + blockCnt++));
            for (IRInst inst : blk.insts)
                if (inst instanceof IRCallInst)
                    maxArgCnt = Math.max(maxArgCnt, ((IRCallInst) inst).args.size());
        }
        curFunc.paramUsed = (maxArgCnt > 8 ? maxArgCnt - 8 : 0) << 2;

        for (int i = 0; i < node.params.size(); ++i)
            if (i < 8)
                node.params.get(i).asmReg = PhysicsReg.regMap.get("a" + i);//前8个参数放在a0-a7中，取出来
            else
                node.params.get(i).asmReg = new VirtualReg(4,i);//后面的参数放在虚拟寄存器中

        for (int i = 0; i < node.blocklist.size(); ++i) {
            curBlock = blockMap.get(node.blocklist.get(i));
            if (i == 0)//如果是第一个块
                storeReg(4, PhysicsReg.regMap.get("ra"), PhysicsReg.regMap.get("sp"), curFunc.paramUsed);
                //往sp+curFunc.paramUsed处存入ra
            node.blocklist.get(i).accept(this);
            curFunc.addBlock(curBlock);
        }
        curFunc.virtualRegCnt = VirtualReg.cnt;

        curFunc.totalStack = curFunc.paramUsed + curFunc.allocaUsed + curFunc.virtualRegCnt * 4;
        //计算整个函数执行过程中，栈帧占用的空间
        //给别的函数传参需要开的空间+自己的alloca需要的空间+总虚拟寄存器数量*4

        ASMBlock entryBlock = curFunc.blocks.get(0);
        ASMBlock exitBlock = curFunc.blocks.get(curFunc.blocks.size() - 1);
        entryBlock.insts.addFirst(new ASMBinaryInst("add", PhysicsReg.regMap.get("sp"), PhysicsReg.regMap.get("sp"),
            new VirtualImm(-curFunc.totalStack)));//sp往上减，开辟栈帧
        exitBlock.insts.add(new ASMBinaryInst("add", PhysicsReg.regMap.get("sp"), PhysicsReg.regMap.get("sp"),
            new VirtualImm(curFunc.totalStack)));//sp往下加，释放栈帧
        exitBlock.insts.add(new ASMRetInst());
    }

    public void visit(IRAllocaInst node) {
        curBlock.addInst(new ASMBinaryInst("add", getReg(node.allocaReg), PhysicsReg.regMap.get("sp"),
            new VirtualImm(curFunc.paramUsed + curFunc.allocaUsed)));
            //把sp偏移以后的地址存入allocaReg
        curFunc.allocaUsed += 4;
    }

    public void visit(IRBranchInst node) {
        curBlock.addInst(new ASMBeqzInst(getReg(node.cond), blockMap.get(node.elseBlock)));
        curBlock.addInst(new ASMJumpInst(blockMap.get(node.thenBlock)));
    }

    public void visit(IRCallInst node) {
        for (int i = 0; i < node.args.size(); ++i) {
            IREntity arg = node.args.get(i);
            if (i < 8)
                curBlock.addInst(new ASMMvInst(PhysicsReg.regMap.get("a" + i), getReg(arg)));//前8个参数放在a0-a7中
            else
                storeReg(arg.type.size, getReg(arg), PhysicsReg.regMap.get("sp"), i - 8 << 2);
                //往PhysicsReg.regMap.get("sp")+((i - 8) << 2)处存入参数arg 大小为size
        }
        curBlock.addInst(new ASMCallInst(node.funcName));
        if (node.callReg != null)
            curBlock.addInst(new ASMMvInst(getReg(node.callReg), PhysicsReg.regMap.get("a0")));
            //把a0的值存入callReg
    }

    public void visit(IRCalcInst node) {
        curBlock.addInst(new ASMBinaryInst(node.op, getReg(node.res), getReg(node.lhs), getReg(node.rhs)));
        //lhs和rhs相作用，结果存入res
    }

    public void visit(IRGetElementPtrInst node) {
        if (node.pToType == irBoolType || node.pToType == irCharType) {
            curBlock.addInst(new ASMBinaryInst("add", getReg(node.res), getReg(node.ptr), getReg(node.indexList.get(0))));
            //如果指针指向的类型是1字节 node.ptr加上第一个参数以后存入node.res
        } else {
            Reg idx = node.pToType instanceof IRClassType ? getReg(node.indexList.get(1)) : getReg(node.indexList.get(0));
            VirtualReg tmp = new VirtualReg(4);
            curBlock.addInst(new ASMUnaryInst("slli", tmp, idx, new Imm(2)));
            //把idx左移2位，存入tmp
            curBlock.addInst(new ASMBinaryInst("add", getReg(node.res), getReg(node.ptr), tmp));
            //把ptr加上tmp以后存入res
        }
    }

    public void visit(IRIcmpInst node) {
        VirtualReg tmp = new VirtualReg(4);
        switch (node.op) {
            case "eq" -> {
                curBlock.addInst(new ASMBinaryInst("sub", tmp, getReg(node.lhs), getReg(node.rhs)));
                curBlock.addInst(new ASMUnaryInst("seqz", getReg(node.cmpReg), tmp));
            }
            case "ne" -> {
                curBlock.addInst(new ASMBinaryInst("sub", tmp, getReg(node.lhs), getReg(node.rhs)));
                curBlock.addInst(new ASMUnaryInst("snez", getReg(node.cmpReg), tmp));
            }
            case "sgt" ->
                    curBlock.addInst(new ASMBinaryInst("slt", getReg(node.cmpReg), getReg(node.rhs), getReg(node.lhs)));
            case "sge" -> {
                curBlock.addInst(new ASMBinaryInst("slt", tmp, getReg(node.lhs), getReg(node.rhs)));
                curBlock.addInst(new ASMUnaryInst("xori", getReg(node.cmpReg), tmp, new Imm(1)));
            }
            case "slt" ->
                    curBlock.addInst(new ASMBinaryInst("slt", getReg(node.cmpReg), getReg(node.lhs), getReg(node.rhs)));
            case "sle" -> {
                curBlock.addInst(new ASMBinaryInst("slt", tmp, getReg(node.rhs), getReg(node.lhs)));
                curBlock.addInst(new ASMUnaryInst("xori", getReg(node.cmpReg), tmp, new Imm(1)));
            }
        }
    }

    public void visit(IRJumpInst node) {
        curBlock.addInst(new ASMJumpInst(blockMap.get(node.toBlock)));
    }

    public void visit(IRLoadInst node) {
        loadReg(node.type.size, getReg(node.destReg), getReg(node.srcAddr), 0);
    }

    public void visit(IRRetInst node) {
        if (node.val != irVoidConst)
            curBlock.addInst(new ASMMvInst(PhysicsReg.regMap.get("a0"), getReg(node.val)));//把val的值存入a0
        loadReg(4, PhysicsReg.regMap.get("ra"), PhysicsReg.regMap.get("sp"), curFunc.paramUsed);
        // 寄存器分配完再加 ret
    }

    public void visit(IRStoreInst node) {
        //往rs1的地址处存入rs2
        storeReg(node.val.type.size, getReg(node.val), getReg(node.destAddr), 0);
    }
}
