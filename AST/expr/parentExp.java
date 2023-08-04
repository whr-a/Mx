package AST.expr;

import Utils.position;

public class parentExp extends ExprNode{
    public ExprNode expr;
    public parentExp(position pos) {
        super(pos);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
