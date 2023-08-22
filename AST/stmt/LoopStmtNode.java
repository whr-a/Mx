package AST.stmt;

import AST.expr.*;
import Utils.*;

import IR.*;
public abstract class LoopStmtNode extends StmtNode {
    public ExprNode cond;
    public StmtNode stmts;
    public IRbasicblock condBlock, loopBlock, nextBlock;
    public LoopStmtNode(position pos) {
        super(pos);
    }
}