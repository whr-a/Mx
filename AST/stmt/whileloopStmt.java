package AST.stmt;

import AST.expr.ExprNode;
import Utils.position;

public class whileloopStmt extends StmtNode{
    public ExprNode condition;
    public StmtNode body;
    public whileloopStmt(position pos) {
        super(pos);
    }
}
