package AST.expr;

import Utils.position;

public class memeryvar extends ExprNode{
    public ExprNode node;
    public String variable;
    public memeryvar(position pos) {
        super(pos);
    }

    @Override
    public boolean isLeftValue() {
        return true;
    }
    
}
