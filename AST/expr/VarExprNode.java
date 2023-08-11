package AST.expr;

import AST.*;
import Utils.*;

public class VarExprNode extends AtomExprNode {
    public VarExprNode(position pos, String str) {
        super(pos, str);
    }
    @Override
    public boolean isLeftValue() {
        return true;
    }
    
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}