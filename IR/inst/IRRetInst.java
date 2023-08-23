package IR.inst;

import Utils.*;
import IR.entity.*;
import IR.*;

public class IRRetInst extends IRTerminalInst implements BuiltinElements {
    public IREntity val;

    public IRRetInst(IRbasicblock block, IREntity val) {
        super(block);
        this.val = val;
    }
    
    @Override
    public String toString() {
        return "ret " + val.toStringWithType();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}