package AST.expr.literal;

import AST.expr.ExprNode;
import Utils.position;

public abstract class literalNode extends ExprNode{
    public literalNode(position pos) {
        super(pos);
    }
    
}
