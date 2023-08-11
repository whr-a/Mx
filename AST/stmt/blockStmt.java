package AST.stmt;

import java.util.ArrayList;

import AST.ASTVisitor;
import Utils.position;

public class blockStmt extends StmtNode{
    public ArrayList<StmtNode> stmts = new ArrayList<StmtNode>();
    public blockStmt(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
