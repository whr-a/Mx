package AST.expr;

import AST.ASTVisitor;
import Utils.position;

public class prefixExp extends ExprNode{
    public ExprNode exp;
    public boolean op;//op == 0 为 -- ; op == 1 为 ++ ;
    public prefixExp(position pos) {
        super(pos);
    }
    @Override
    public boolean isLeftValue() {
        return true;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
