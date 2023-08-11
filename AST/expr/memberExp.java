package AST.expr;

import AST.ASTVisitor;
import Utils.position;

public class memberExp extends ExprNode{
    public ExprNode obj;
    public String member;
    public memberExp(position pos, ExprNode obj, String member) {
        super(pos);
        this.obj = obj;
        this.member = member;
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
