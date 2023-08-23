package IR.inst;

import IR.entity.*;
import IR.IRtype.*;
import IR.*;

public class IRIcmpInst extends IRInst {
    public IRBaseType type;
    public IRRegister cmpReg;
    public IREntity lhs, rhs;
    public String op;

    public IRIcmpInst(IRbasicblock block, IRBaseType type, IRRegister cmpReg, IREntity lhs, IREntity rhs, String op) {
        super(block);
        this.type = type;
        this.cmpReg = cmpReg;
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }

    @Override
    public String toString() {
        return cmpReg + " = icmp " + op +" " + type +  " " + lhs + ", " + rhs;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}   