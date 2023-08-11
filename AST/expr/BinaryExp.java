package AST.expr;

import AST.ASTVisitor;
import Utils.position;

public class BinaryExp extends ExprNode{
    public String op;
    public ExprNode lhs,rhs;
    public BinaryExp(position pos,String op,ExprNode lhs,ExprNode rhs){
        super(pos);
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public boolean isLeftValue() {
        return false;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
