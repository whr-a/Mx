package AST.expr.literal;

import Utils.position;

public class nullLiteral extends literalNode{

    public nullLiteral(position pos) {
        super(pos);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
