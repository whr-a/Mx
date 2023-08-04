package AST.expr;

import java.util.ArrayList;

import Utils.position;

public class NewExprNode extends ExprNode{
    public String typeName;
    public int dim = 0;
    public ArrayList<ExprNode> sizes = new ArrayList<ExprNode>();
    public NewExprNode(position pos,String typeName) {
        super(pos);
        this.typeName = typeName;
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
}
