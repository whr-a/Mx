package AST;
import AST.stmt.StmtNode;
import Utils.position;

public class ConstructorNode extends Node{
    public String name;
    public StmtNode stmts;
//    public FuncDefNode info;
    public ConstructorNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
