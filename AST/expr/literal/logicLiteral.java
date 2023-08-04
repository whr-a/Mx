package AST.expr.literal;

import Utils.position;

public class logicLiteral extends literalNode{
    public boolean value;
    public logicLiteral(position pos) {
        super(pos);
    }
    public logicLiteral(position pos,boolean value) {
        super(pos);
        this.value = value;
    }
    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
