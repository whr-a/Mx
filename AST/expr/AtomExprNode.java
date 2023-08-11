package AST.expr;

import AST.*;
import Utils.*;

public class AtomExprNode extends ExprNode {
    public AtomExprNode(position pos, String str) {
        super(pos);
        this.str = str;
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}