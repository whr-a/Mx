package AST.expr;

import Utils.position;

public class identifierExp extends ExprNode{
    public String name;
    public identifierExp(position pos) {
        super(pos);
    }

    @Override
    public boolean isLeftValue() {
        return true;
    }
    
}
