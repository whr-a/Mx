package AST.expr.literal;

import Utils.position;

public class thisLiteral extends literalNode{

    public thisLiteral(position pos) {
        super(pos);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
