package AST.expr;

import Utils.position;

public class ternaryExp extends ExprNode{
    public ExprNode condition;
    public ExprNode trueExp;
    public ExprNode falseExp;
    public ternaryExp(position pos) {
        super(pos);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
