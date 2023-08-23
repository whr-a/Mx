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
    ASMModule module;//module，即传入的参数
    ASMFunction curFunc;//目前在的ASM函数
    ASMBlock curBlock;//目前在的ASM块
    int blockCnt = 0;//计数，目前未知

    HashMap<IRbasicblock, ASMBlock> blockMap = new HashMap<>();//一个IRBasicBlock对应一个ASMBlock

    public InstSelector(ASMModule module) {
        this.module = module;//初始化，传参
    }

    Reg getReg(IREntity entity) {//获得一个IREntity的寄存器
        if (entity.asmReg == null) {//如果没有寄存器
            assert !(entity instanceof IRGlobalvar);//断言不能是全局变量
            assert !(entity instanceof IRStringConst);//断言不能是字符串常量
            if (entity instanceof IRRegister) {//如果是模拟寄存器
                entity.asmReg = new VirtualReg(entity.type.size);//创建一个虚拟寄存器
            } else if (entity instanceof IRConst) {//如果是常量
                entity.asmReg = new VirtualImm((IRConst) entity);//创建一个虚拟立即数
            }
        }
        return entity.asmReg;
    }
    void storeReg(int size, Reg value, Reg dest, int offset) {//往dest+offset处存入value
        if (offset < 1 << 11)//如果offset小于2^11
            curBlock.addInst(new ASMStoreInst(size, dest, value, new Imm(offset)));//添加store指令
        else {//如果offset大于2^11 就手动用指令加一下
            VirtualReg tmp = new VirtualReg(4);//创建一个虚拟寄存器
            curBlock.addInst(new ASMBinaryInst("add", tmp, dest, new VirtualImm(offset)));//创建指令相加以获取地址 存在tmp中
            curBlock.addInst(new ASMStoreInst(size, tmp, value));//sb/sw value 0(tmp)
        }
    }
    void loadReg(int size, Reg dest, Reg src, int offset) {//和store同理
        if (offset < 1 << 11)
            curBlock.addInst(new ASMLoadInst(size, dest, src, new Imm(offset)));
        else {
            VirtualReg tmp = new VirtualReg(4);
            curBlock.addInst(new ASMBinaryInst("add", tmp, src, new VirtualImm(offset)));
            curBlock.addInst(new ASMLoadInst(size, dest, tmp));
        }
    }

    public void visit(IRprogram node) {//访问整个IRProgram
        // add global vars
        
        node.gVariables.forEach(globalVar -> {//添加全局变量
            globalVar.asmReg = new GlobalValue(globalVar);//添加全局变量对应的寄存器
            module.globalValues.add((GlobalValue) globalVar.asmReg);//添加到module的全局变量列表中
        });
        node.stringConst.values().forEach(str -> {//添加字符串常量
            GlobalString globalStr = new GlobalString(".str." + String.valueOf(str.id), str.val);//创建一个全局字符串
            module.globalStrings.add(globalStr);//添加到module的全局字符串列表中
            str.asmReg = globalStr;//添加字符串常量对应的寄存器
        });
        // if (node.initfunction != null) {//如果有全局初始化函数
        //     curFunc = new ASMFunction(node.initfunction.name);//新建一个ASMFucntion
        //     module.functions.add(curFunc);//添加到module的函数列表中
        //     node.initfunction.accept(this);//访问全局初始化函数
        // }
        node.functions.forEach(func -> {//对于每一个函数
            curFunc = new ASMFunction(func.name);
            module.functions.add(curFunc);
            func.accept(this);
        });
    }

    public void visit(IRfunction node) {
        // add params
        blockMap.clear();//进入新的函数清空blockMap
        VirtualReg.cnt = 0;//模拟寄存器计数清零
        // find max argument cnt
        int maxArgCnt = 0;
        for (IRbasicblock blk : node.blocklist) {//遍历每一个基本块
            blockMap.put(blk, new ASMBlock(".L" + blockCnt++));//给每一个基本块创建一个ASMBlock，名字为.L+blockCnt，加入blockMap
            for (IRInst inst : blk.insts)//遍历每一个基本块的指令
                if (inst instanceof IRCallInst)//如果是call指令
                    maxArgCnt = Math.max(maxArgCnt, ((IRCallInst) inst).args.size());//记录最大参数数量
        }
        curFunc.paramUsed = (maxArgCnt > 8 ? maxArgCnt - 8 : 0) << 2;//计算整个函数执行过程中，传参占用的空间
        // set params
        for (int i = 0; i < node.params.size(); ++i)//函数自己的参数
            if (i < 8)
                node.params.get(i).asmReg = PhysicsReg.regMap.get("a" + i);//前8个参数放在a0-a7中，取出来
            else
                node.params.get(i).asmReg = new VirtualReg(4,i);//后面的参数放在虚拟寄存器中


        for (int i = 0; i < node.blocklist.size(); ++i) {//遍历每一个基本块
            curBlock = blockMap.get(node.blocklist.get(i));//获得块
            if (i == 0)//如果是第一个块
                storeReg(4, PhysicsReg.regMap.get("ra"), PhysicsReg.regMap.get("sp"), curFunc.paramUsed);
                //往sp+curFunc.paramUsed处存入ra
            node.blocklist.get(i).accept(this);//访问这个基本块
            curFunc.addBlock(curBlock);//把这个基本块加入函数的基本块列表中
        }
        curFunc.virtualRegCnt = VirtualReg.cnt;//记录虚拟寄存器的数量
        // set stack frame
        curFunc.totalStack = curFunc.paramUsed + curFunc.allocaUsed + curFunc.virtualRegCnt * 4;
        //计算整个函数执行过程中，栈帧占用的空间
        //给别的函数传参需要开的空间+自己的alloca需要的空间+总虚拟寄存器数量*4
        // if (curFunc.totalStack % 16 != 0)
        //   curFunc.totalStack += 16 - curFunc.totalStack % 16;
        ASMBlock entryBlock = curFunc.blocks.get(0);
        ASMBlock exitBlock = curFunc.blocks.get(curFunc.blocks.size() - 1);
        entryBlock.insts.addFirst(new ASMBinaryInst("add", PhysicsReg.regMap.get("sp"), PhysicsReg.regMap.get("sp"),
            new VirtualImm(-curFunc.totalStack)));//sp往上加，开辟栈帧
        exitBlock.insts.add(new ASMBinaryInst("add", PhysicsReg.regMap.get("sp"), PhysicsReg.regMap.get("sp"),
            new VirtualImm(curFunc.totalStack)));//sp往下减，释放栈帧
        exitBlock.insts.add(new ASMRetInst());
    }

    public void visit(IRbasicblock node) {
        node.insts.forEach(inst -> {//遍历块内每一个指令
            inst.accept(this);
        });
        node.terminalInst.accept(this);//访问块的终止指令
    }

    public void visit(IRAllocaInst node) {
        curBlock.addInst(new ASMBinaryInst("add", getReg(node.allocaReg), PhysicsReg.regMap.get("sp"),
            new VirtualImm(curFunc.paramUsed + curFunc.allocaUsed)));
            //把sp偏移以后的地址存入allocaReg
        curFunc.allocaUsed += 4;
    }

    public void visit(IRBranchInst node) {
        curBlock.addInst(new ASMBeqzInst(getReg(node.cond), blockMap.get(node.elseBlock)));//如果cond为0，跳转到elseBlock
        curBlock.addInst(new ASMJumpInst(blockMap.get(node.thenBlock)));//跳转到thenBlock
    }

    public void visit(IRCalcInst node) {//二元运算
        curBlock.addInst(new ASMBinaryInst(node.op, getReg(node.res), getReg(node.lhs), getReg(node.rhs)));
        //lhs和rhs相作用，结果存入res
    }

    public void visit(IRCallInst node) {//call指令
        for (int i = 0; i < node.args.size(); ++i) {//遍历每一个参数
            IREntity arg = node.args.get(i);//取出参数
            if (i < 8)
                curBlock.addInst(new ASMMvInst(PhysicsReg.regMap.get("a" + i), getReg(arg)));//前8个参数放在a0-a7中
            else
                storeReg(arg.type.size, getReg(arg), PhysicsReg.regMap.get("sp"), i - 8 << 2);
                //往PhysicsReg.regMap.get("sp")+((i - 8) << 2)处存入参数arg 大小为size
        }
        curBlock.addInst(new ASMCallInst(node.funcName));//添加指令，直接call
        if (node.callReg != null)//如果有返回值
            curBlock.addInst(new ASMMvInst(getReg(node.callReg), PhysicsReg.regMap.get("a0")));
            //把a0的值存入callReg
    }

    public void visit(IRGetElementPtrInst node) {
        if (node.pToType == irBoolType || node.pToType == irCharType) {
            curBlock.addInst(new ASMBinaryInst("add", getReg(node.res), getReg(node.ptr), getReg(node.indexList.get(0))));
            //如果指针指向的类型是1字节 node.ptr加上第一个参数以后存入node.res
        } else {
            Reg idx = node.pToType instanceof IRClassType ? getReg(node.indexList.get(1)) : getReg(node.indexList.get(0));
            //如果指针指向的类型是类，就取第二个参数，否则取第一个参数
            VirtualReg tmp = new VirtualReg(4);
            curBlock.addInst(new ASMUnaryInst("slli", tmp, idx, new Imm(2)));
            //把idx左移2位，存入tmp
            curBlock.addInst(new ASMBinaryInst("add", getReg(node.res), getReg(node.ptr), tmp));
            //把ptr加上tmp以后存入res
        }
    }

    public void visit(IRIcmpInst node) {
        // LLVM_IR: eq, ne, sgt, sge, slt, sle
        // RISCV32_ASM: seqz, snez, slt
        VirtualReg tmp = new VirtualReg(4);
        switch (node.op) {
        case "eq":
            curBlock.addInst(new ASMBinaryInst("sub", tmp, getReg(node.lhs), getReg(node.rhs)));
            curBlock.addInst(new ASMUnaryInst("seqz", getReg(node.cmpReg), tmp));
            break;
        case "ne":
            curBlock.addInst(new ASMBinaryInst("sub", tmp, getReg(node.lhs), getReg(node.rhs)));
            curBlock.addInst(new ASMUnaryInst("snez", getReg(node.cmpReg), tmp));
            break;
        case "sgt":
            curBlock.addInst(new ASMBinaryInst("slt", getReg(node.cmpReg), getReg(node.rhs), getReg(node.lhs)));
            break;
        case "sge":
            curBlock.addInst(new ASMBinaryInst("slt", tmp, getReg(node.lhs), getReg(node.rhs)));
            curBlock.addInst(new ASMUnaryInst("xori", getReg(node.cmpReg), tmp, new Imm(1)));
            break;
        case "slt":
            curBlock.addInst(new ASMBinaryInst("slt", getReg(node.cmpReg), getReg(node.lhs), getReg(node.rhs)));
            break;
        case "sle":
            curBlock.addInst(new ASMBinaryInst("slt", tmp, getReg(node.rhs), getReg(node.lhs)));
            curBlock.addInst(new ASMUnaryInst("xori", getReg(node.cmpReg), tmp, new Imm(1)));
            break;
        }
    }

    public void visit(IRJumpInst node) {
        curBlock.addInst(new ASMJumpInst(blockMap.get(node.toBlock)));
    }

    public void visit(IRLoadInst node) {
        loadReg(node.type.size, getReg(node.destReg), getReg(node.srcAddr), 0);
    }

    public void visit(IRRetInst node) {
        // ret val -> load val to a0 and return
        if (node.val != irVoidConst)
            curBlock.addInst(new ASMMvInst(PhysicsReg.regMap.get("a0"), getReg(node.val)));//把val的值存入a0
        loadReg(4, PhysicsReg.regMap.get("ra"), PhysicsReg.regMap.get("sp"), curFunc.paramUsed);
        // 寄存器分配完再加 ret
    }

    public void visit(IRStoreInst node) {
        // store : rs2 -> (rs1) address
        storeReg(node.val.type.size, getReg(node.val), getReg(node.destAddr), 0);
    }
}
