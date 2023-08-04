package AST.expr;

import AST.Node;
import Utils.position;

public abstract class ExprNode extends Node{

    public ExprNode(position pos) {
        super(pos);
    }
    public abstract boolean isLeftValue();
}
