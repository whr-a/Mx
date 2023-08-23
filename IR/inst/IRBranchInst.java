package IR.inst;

import java.util.LinkedHashSet;

import IR.*;
import IR.entity.*;

public class IRBranchInst extends IRTerminalInst {
    public IREntity cond;
    public IRbasicblock thenBlock;
    public IRbasicblock elseBlock;

    public IRBranchInst(IRbasicblock block, IREntity cond, IRbasicblock thenBlock, IRbasicblock elseBlock) {
        super(block);
        this.cond = cond;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }
    @Override
    public String toString() {
        return "br " + cond.toStringWithType() + ", label %" + thenBlock.name + ", label %" + elseBlock.name;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    public LinkedHashSet<IREntity> getUse() {
        LinkedHashSet<IREntity> ret = new LinkedHashSet<>();
        ret.add(cond);
        return ret;
    }
}