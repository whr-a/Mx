package IR.inst;

import Utils.*;
import IR.entity.*;
import IR.*;
import java.util.*;
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
    @Override
    public void replaceUse(IREntity old, IREntity newOne) {
        val = val == old ? (newOne == null ? irIntConst0 : newOne) : val;
    }
    @Override
    public LinkedHashSet<IREntity> getUse() {
        LinkedHashSet<IREntity> ret = new LinkedHashSet<>();
        ret.add(val);
        return ret;
    }
}