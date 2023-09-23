package IR.inst;

import IR.entity.*;

import java.util.LinkedHashSet;

import IR.*;

public class IRCalcInst extends IRInst {//为了二元运算
    public String op;
    public IRRegister res;
    public IREntity lhs, rhs;

    public IRCalcInst(IRbasicblock block, IRRegister res, IREntity lhs, IREntity rhs, String op) {
        super(block);
        this.res = res;
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }
    
    @Override
    public String toString() {
        return res + " = " + op + " " + lhs.toStringWithType() + ", " + rhs;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public void replaceUse(IREntity old, IREntity newOne) {
        lhs = lhs == old ? newOne : lhs;
        rhs = rhs == old ? newOne : rhs;
    }
    @Override
    public LinkedHashSet<IREntity> getUse() {
        LinkedHashSet<IREntity> ret = new LinkedHashSet<>();
        ret.add(lhs);
        ret.add(rhs);
        return ret;
    }
}