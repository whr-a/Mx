package AST.stmt;

import Utils.position;

public class returnStmt extends StmtNode{
    public ExprStmt expr;
    public returnStmt(position pos) {
        super(pos);
    }
}
