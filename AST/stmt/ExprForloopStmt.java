package AST.stmt;


import Utils.position;

public class ExprForloopStmt extends StmtNode{
    public ExprStmt init;
    public ExprStmt condition;
    public ExprStmt step;
    public StmtNode body;
    public ExprForloopStmt(position pos) {
        super(pos);
    }
    
}
