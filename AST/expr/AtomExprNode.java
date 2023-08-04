package AST.expr;

import Utils.position;

public class AtomExprNode extends ExprNode {//原子式，已不可划分
    String str;
    public AtomExprNode(position pos, String str) {
        super(pos);
        this.str = str;
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
}
