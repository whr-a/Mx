package AST.expr;

import Utils.position;

public class postfixExp extends ExprNode{
    ExprNode exp;
    boolean op;//op == 0 为 -- ; op == 1 为 ++ ;
    public postfixExp(position pos) {
        super(pos);
    }
    @Override
    public boolean isLeftValue() {
        return true;
    }
    
}
