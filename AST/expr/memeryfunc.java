package AST.expr;

import AST.FuncCallArgsNode;
import Utils.position;

public class memeryfunc extends ExprNode{
    public ExprNode node;
    public String method;
    public FuncCallArgsNode args;
    public memeryfunc(position pos) {
        super(pos);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
