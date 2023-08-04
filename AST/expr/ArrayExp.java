package AST.expr;

import Utils.position;

public class ArrayExp extends ExprNode {
    public ExprNode name;
    public ExprNode index;
    public ArrayExp(position pos,ExprNode name,ExprNode index) {
        super(pos);
        this.name = name;
        this.index = index;
    }

    @Override
    public boolean isLeftValue() {
        return true;
    }
    
}
