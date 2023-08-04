package AST.expr.literal;

import Utils.position;

public class numberLiteral extends literalNode{
    public int value;
    public numberLiteral(position pos) {
        super(pos);
    }
    public numberLiteral(position pos,int value) {
        super(pos);
        this.value = value;
    }
    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
