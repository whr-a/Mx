package back;

import java.util.LinkedList;

import assembly.*;
import assembly.operand.*;
import assembly.inst.*;

public class RegAllocator {
    ASMModule module;
    int totalStack, virtualRegBegin;
    PhysicsReg RegT0 = PhysicsReg.regMap.get("t0");
    PhysicsReg RegT1 = PhysicsReg.regMap.get("t1");
    PhysicsReg RegT2 = PhysicsReg.regMap.get("t2");
    PhysicsReg RegSp = PhysicsReg.regMap.get("sp");
    LinkedList<ASMInst> workList;

    public RegAllocator(ASMModule module) {
        this.module = module;
    }

    public void work() {
        for (ASMFunction function : module.functions) {
            totalStack = function.totalStack;//设置总的开的空间
            virtualRegBegin = function.paramUsed + function.allocaUsed;//虚拟寄存器的起始位置
            for (ASMBlock block : function.blocks)
                visitBlock(block);
        }
    }

    public void visitBlock(ASMBlock block) {
        block.insts.addAll(block.phiConvert);
        if (block.branch_terminal != null) {
            block.insts.add(block.branch_terminal);
        }
        if (block.terminal != null) {
            block.insts.add(block.terminal);
        }
        block.phiConvert.clear();
        block.branch_terminal = block.terminal = null;
        workList = new LinkedList<ASMInst>();
        for (ASMInst inst : block.insts) {
            if (inst.rs1 != null && !(inst.rs1 instanceof PhysicsReg)) {
                allocateSrc(RegT1, inst.rs1);
                inst.rs1 = RegT1;
            }//给rs1分配寄存器
            if (inst.rs2 != null && !(inst.rs2 instanceof PhysicsReg)) {
                allocateSrc(RegT0, inst.rs2);
                inst.rs2 = RegT0;
            }//给rs2分配寄存器
            workList.add(inst);
            if (inst.rd != null && !(inst.rd instanceof PhysicsReg)) {
                allocaDest(RegT0, inst.rd);
                inst.rd = RegT0;
            }//给rd分配寄存器
            
        }
        block.insts = workList;//用worklist替换掉原来的指令

    }

    void allocateSrc(PhysicsReg reg, Reg src) {
        if (src instanceof VirtualReg) {
            int offset = ((VirtualReg) src).id != -1
                ? virtualRegBegin + ((VirtualReg) src).id * 4//不是-1，说明是局部变量
                : totalStack + ((VirtualReg) src).param_idx * 4;//是-1，说明是参数,就加到caller的位置取参数
            if (offset < 1 << 11)
                workList.add(new ASMLoadInst(((VirtualReg) src).size, reg, RegSp, new Imm(offset)));
            else {
                workList.add(new ASMLiInst(RegT2, new VirtualImm(offset)));
                workList.add(new ASMBinaryInst("add", RegT2, RegT2, RegSp));
                workList.add(new ASMLoadInst(((VirtualReg) src).size, reg, RegT2));
            }
        } else if (src instanceof VirtualImm) {
            workList.add(new ASMLiInst(reg, (VirtualImm) src));
        } else if (src instanceof Global) {
            workList.add(new ASMLuiInst(reg, new RelocationFunc(RelocationFunc.Type.hi, ((Global) src).name)));
            workList.add(new ASMUnaryInst("addi", reg, reg, new RelocationFunc(RelocationFunc.Type.lo, ((Global) src).name)));
        }
    }

    void allocaDest(PhysicsReg reg, Reg dest) {
        if (dest instanceof VirtualReg) {
            int offset = ((VirtualReg) dest).id != -1
                ? virtualRegBegin + ((VirtualReg) dest).id * 4
                : totalStack + ((VirtualReg) dest).param_idx * 4;
            if (offset < 1 << 11)
                workList.add(new ASMStoreInst(((VirtualReg) dest).size, RegSp, reg, new Imm(offset)));
            else {
                workList.add(new ASMLiInst(RegT2, new VirtualImm(offset)));
                workList.add(new ASMBinaryInst("add", RegT2, RegT2, RegSp));
                workList.add(new ASMStoreInst(((VirtualReg) dest).size, RegT2, reg));
            }
        }
    }
}