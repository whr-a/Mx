package AST.stmt;


import AST.expr.ExprNode;
import Utils.position;

public class branchstmt extends StmtNode{
    public ExprNode condition;
    public StmtNode thenstmt;
    public StmtNode elsestmt;
    public branchstmt(position pos) {
        super(pos);
    }
}
