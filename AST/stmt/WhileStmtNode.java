package AST.stmt;

import AST.*;
import AST.expr.*;
import Utils.*;

public class WhileStmtNode extends LoopStmtNode {
    public WhileStmtNode(position pos, ExprNode cond) {
        super(pos);
        this.cond = cond;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}