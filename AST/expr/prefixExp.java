package AST.expr;

import Utils.position;

public class prefixExp extends ExprNode{
    ExprNode exp;
    boolean op;//op == 0 为 -- ; op == 1 为 ++ ;
    public prefixExp(position pos) {
        super(pos);
    }
    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
