package AST.stmt;

import AST.ASTVisitor;
import AST.expr.ExprNode;
import Utils.position;

public class ExprStmt extends StmtNode{
    public ExprNode expr = null;
    public ExprStmt(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
