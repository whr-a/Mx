package AST.stmt;

import AST.VarDefNode;
import Utils.position;

public class DeclForloopStmt extends StmtNode{
    public VarDefNode vardef;
    public ExprStmt condition;
    public ExprStmt step;
    public StmtNode body;
    public DeclForloopStmt(position pos) {
        super(pos);
    }
    
}
