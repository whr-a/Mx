package AST.stmt;


import AST.ASTVisitor;
import AST.VarDefNode;
import AST.expr.ExprNode;
import Utils.position;

public class branchstmt extends StmtNode{
    public ExprNode condition;
    public StmtNode thenstmt;
    public StmtNode elsestmt = null;
    public branchstmt(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

}
