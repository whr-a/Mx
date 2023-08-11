package AST.expr;

import AST.FuncDefNode;
import AST.Node;
import Utils.*;

public abstract class ExprNode extends Node{
    public String str;
    public Type type;
    public FuncDefNode funcDef = null;
    public ExprNode(position pos) {
        super(pos);
    }
    public abstract boolean isLeftValue();
}
