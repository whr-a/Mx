package AST.stmt;

import AST.ASTVisitor;
import AST.expr.ExprNode;
import Utils.position;

public class breakStmt extends StmtNode{

    public breakStmt(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
