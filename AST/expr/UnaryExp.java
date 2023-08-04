package AST.expr;

import Utils.position;

public class UnaryExp extends ExprNode{
    public ExprNode expr;
    public String op;
    public UnaryExp(position pos) {
        super(pos);
    }
    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
