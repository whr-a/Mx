package AST.stmt;

import AST.ASTVisitor;
import AST.expr.ExprNode;
import Utils.position;

public class ExprStmt extends StmtNode{
    public ExprNode expr = null;//空的话就是空的表达式
    public ExprStmt(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
