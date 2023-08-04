package AST.expr.literal;

import Utils.position;

public class stringLiteral extends literalNode{
    String value;
    public stringLiteral(position pos) {
        super(pos);
    }
    public stringLiteral(position pos,String value) {
        super(pos);
        this.value = value;
    }
    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
