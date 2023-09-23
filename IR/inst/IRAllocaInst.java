package IR.inst;

import IR.entity.*;
import IR.IRtype.*;

import java.util.LinkedHashSet;

import IR.*;

public class IRAllocaInst extends IRInst {
    public IRBaseType type;
    public IRRegister allocaReg;
    public int param_idx = -1;
    //不是-1 说明是为函数参数alloca
    public IRAllocaInst(IRbasicblock block, IRBaseType type, IRRegister allocaReg) {
        super(block);
        this.type = type;
        this.allocaReg = allocaReg;
    }
    public IRAllocaInst(IRbasicblock block, IRBaseType type, IRRegister allocaReg, int param_idx) {
        super(block);
        this.type = type;
        this.allocaReg = allocaReg;
        this.param_idx = param_idx;
    }

    @Override
    public String toString() {
        return allocaReg + " = alloca " + type;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public LinkedHashSet<IREntity> getUse() {
        return new LinkedHashSet<>();
    }
    @Override
    public void replaceUse(IREntity old, IREntity newOne) {}
}

