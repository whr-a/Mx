package AST.stmt;

import AST.expr.*;
import Utils.*;
import java.util.ArrayList;

public abstract class LoopStmtNode extends StmtNode {
    public ExprNode cond;
    public StmtNode stmts;

    public LoopStmtNode(position pos) {
        super(pos);
    }
}