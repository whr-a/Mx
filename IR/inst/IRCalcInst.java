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
}