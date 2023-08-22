package AST.stmt;

import AST.*;
import AST.expr.*;
import Utils.*;
import IR.*;
public class ForStmtNode extends LoopStmtNode {
    public VarDefNode varDef;
    public ExprNode init;
    public ExprNode step = null;
    public IRbasicblock stepBlock;
    public ForStmtNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}