package AST;
import AST.expr.*;
import AST.stmt.*;

public interface ASTVisitor {
    public void visit(ProgramNode node);
    
    public void visit(ClassDefNode node);
    public void visit(FuncDefNode node);
    public void visit(VarDefNode node);
    public void visit(ConstructorNode node);
    public void visit(functionDeclParamListNode node);
    public void visit(TypeNode node);
    public void visit(VarDefUnitNode node);

    public void visit(AtomExprNode node);
    public void visit(ArrayExp node);
    public void visit(assignExp node);
    public void visit(BinaryExp node);
    public void visit(FunctionExp node);
    public void visit(NewExprNode node);
    public void visit(prefixExp node);
    public void visit(ternaryExp node);
    public void visit(UnaryExp node);
    public void visit(VarExprNode node);
    public void visit(memberExp memberExp);
    public void visit(FuncCallArgsNode node);
    
    public void visit(blockStmt node);
    public void visit(branchstmt node);
    public void visit(breakStmt node);
    public void visit(continueStmt node);
    public void visit(ForStmtNode node);
    public void visit(ExprStmt node);
    public void visit(returnStmt node);
    public void visit(WhileStmtNode node);
    
}
