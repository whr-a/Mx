package IR;

import IR.inst.*;
public interface IRVisitor {
    public void visit(IRprogram node);
    public void visit(IRfunction node);
    public void visit(IRbasicblock node);

    public void visit(IRAllocaInst node);
    public void visit(IRBranchInst node);
    public void visit(IRCalcInst node);
    public void visit(IRCallInst node);
    public void visit(IRGetElementPtrInst node);
    public void visit(IRIcmpInst node);
    public void visit(IRJumpInst node);
    public void visit(IRLoadInst node);
    public void visit(IRRetInst node);
    public void visit(IRStoreInst node);

    public void visit(IRPhiInst node);
}
