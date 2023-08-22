package IR.inst;

import IR.*;

public abstract class IRInst {
    public IRbasicblock parentBlock = null;
    public abstract String toString();

    public IRInst(IRbasicblock block) {
        this.parentBlock = block;
    }

}

