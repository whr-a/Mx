package front;

import AST.*;
import AST.expr.*;
import AST.stmt.*;
import Utils.*;
public class SymbolCollector implements ASTVisitor{
    private GlobalScope globalScope;
    public SymbolCollector(GlobalScope globalScope) {
        this.globalScope = globalScope;
    }
    @Override
    public void visit(ProgramNode node) {
        node.deflist.forEach(def -> def.accept(this));
    }

    @Override
    public void visit(ClassDefNode node) {
        if (globalScope.getClassDef(node.name) != null)
            throw new BaseError(node.pos, "Class " + node.name + " is already defined");
        if (globalScope.getFuncDef(node.name) != null)
            throw new BaseError(node.pos, "Class " + node.name + " is already defined as a function");
        globalScope.addClass(node.name, node);
        for (var func : node.funcDefList) {
            if (node.funcMember.containsKey(func.funcName))
                throw new BaseError(func.pos, "Function " + func.funcName + " is already defined");
            func.classname = node.name;
            node.funcMember.put(func.funcName, func);
        }
        for (var var : node.varDefList)
            for (var unit : var.units) {
                if (node.varMember.containsKey(unit.name))
                    throw new BaseError(unit.pos, "Variable " + unit.name + " is already defined");
                node.varMember.put(unit.name, unit);
            }
    }

    @Override
    public void visit(FuncDefNode node) {
        if (globalScope.getFuncDef(node.funcName) != null)
            throw new BaseError(node.pos, "Function " + node.funcName + " is already defined");
        if (globalScope.getClassDef(node.funcName) != null)
            throw new BaseError(node.pos, "Function " + node.funcName + " is already defined as a class");
        globalScope.addFunc(node.funcName, node);
    }

    @Override
    public void visit(VarDefNode node) {

    }

    @Override
    public void visit(ConstructorNode node) {

    }

    @Override
    public void visit(FuncCallArgsNode node) {

    }

    @Override
    public void visit(functionDeclParamListNode node) {

    }

    @Override
    public void visit(TypeNode node) {

    }

    @Override
    public void visit(VarDefUnitNode node) {

    }

    @Override
    public void visit(ArrayExp node) {

    }

    @Override
    public void visit(assignExp node) {

    }

    @Override
    public void visit(BinaryExp node) {

    }

    @Override
    public void visit(FunctionExp node) {

    }

    @Override
    public void visit(NewExprNode node) {

    }


    @Override
    public void visit(prefixExp node) {

    }

    @Override
    public void visit(ternaryExp node) {

    }

    @Override
    public void visit(UnaryExp node) {

    }

    @Override
    public void visit(blockStmt node) {

    }

    @Override
    public void visit(branchstmt node) {

    }

    @Override
    public void visit(breakStmt node) {

    }

    @Override
    public void visit(continueStmt node) {

    }

    @Override
    public void visit(ForStmtNode node) {

    }

    @Override
    public void visit(ExprStmt node) {

    }

    @Override
    public void visit(returnStmt node) {

    }

    @Override
    public void visit(WhileStmtNode node) {

    }

    @Override
    public void visit(AtomExprNode node) {

    }
    @Override
    public void visit(VarExprNode node) {

    }
    @Override
    public void visit(memberExp memberExp) {

    }
    
}
