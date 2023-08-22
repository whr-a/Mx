package AST;
import AST.stmt.StmtNode;
import AST.stmt.blockStmt;
import Utils.position;

public class ConstructorNode extends Node{
    public String name;
    public StmtNode stmts;
    public FuncDefNode info;
    public ConstructorNode(position pos) {
        super(pos);
    }
    public FuncDefNode transToFuncDef() {
        FuncDefNode funcDef = new FuncDefNode(pos, name);
        funcDef.returnType = new TypeNode(pos, "void");
        funcDef.stmts = ((blockStmt)stmts).stmts;
        info = funcDef;
        return info;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
