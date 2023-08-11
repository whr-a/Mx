package AST.stmt;

import AST.ASTVisitor;
import AST.expr.ExprNode;
import Utils.position;

public class returnStmt extends StmtNode{
    public ExprNode expr;
    public returnStmt(position pos) {
        super(pos);
        expr = null;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
