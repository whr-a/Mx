package AST.expr;

import Utils.position;

public class assignExp extends ExprNode{
    public ExprNode l;
    public ExprNode r;
    public assignExp(position pos) {
        super(pos);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
