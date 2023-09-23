package IR.inst;

import java.util.LinkedHashSet;

import IR.*;
import IR.entity.IREntity;

public abstract class IRInst {
    public IRbasicblock parentBlock = null;
    public boolean Deleted = false;
    public abstract String toString();
    public abstract void accept(IRVisitor visitor);
    public IRInst(IRbasicblock block) {
        this.parentBlock = block;
    }
    public abstract LinkedHashSet<IREntity> getUse();
    public abstract void replaceUse(IREntity old, IREntity newOne);
}

