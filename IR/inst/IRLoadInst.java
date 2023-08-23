package IR.inst;

import IR.entity.*;
import IR.IRtype.*;
import IR.*;

public class IRLoadInst extends IRInst {
    public IRRegister destReg;
    public IREntity srcAddr;
    public IRBaseType type;

    public IRLoadInst(IRbasicblock block, IRRegister destReg, IREntity srcAddr) {
        super(block);//在哪个块里
        this.destReg = destReg;//load到哪
        this.srcAddr = srcAddr;//从哪里load
        this.type = destReg.type;
    }

    @Override
    public String toString() {
        return destReg + " = load " + type + ", " + srcAddr.toStringWithType();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}