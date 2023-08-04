package AST.stmt;

import AST.expr.ExprNode;
import Utils.position;

public class ExprStmt extends StmtNode{
    public ExprNode expr;
    public ExprStmt(position pos) {
        super(pos);
    }
    
}
