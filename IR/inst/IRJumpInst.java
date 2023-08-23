package IR.inst;

import IR.*;
public class IRJumpInst extends IRTerminalInst {
    public IRbasicblock toBlock;

    public IRJumpInst(IRbasicblock block, IRbasicblock toBlock) {
        super(block);
        this.toBlock = toBlock;
    }

    @Override
    public String toString() {
        return "br label %" + toBlock.name;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}