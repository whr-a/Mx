package front;

import AST.*;
import AST.expr.*;
import AST.stmt.*;
import Utils.*;

public class SemanticChecker implements ASTVisitor, BuiltinElements{
    private GlobalScope globalScope;
    private Scope currentScope;
    public SemanticChecker(GlobalScope globalScope) {
        this.globalScope = globalScope;
        currentScope = globalScope;
    }
    @Override
    public void visit(ProgramNode node) {
        FuncDefNode mainfunc = globalScope.getFuncDef("main");
//        for(var def : globalScope.funcMember)
        if (mainfunc == null || (!mainfunc.returnType.type.equals(IntType)) || mainfunc.args != null){
//            if(mainfunc==null)System.out.print("1");
//            if(!mainfunc.returnType.type.equals(IntType))System.out.print("2");
//            if(mainfunc.args != null)System.out.print("3");
            throw new BaseError(node.pos, "do not have correct main function");
        }

        for (var def : node.deflist) def.accept(this);
    }

    @Override
    public void visit(ClassDefNode node) {
        currentScope = new Scope(currentScope, node);
        node.varDefList.forEach(varDef -> varDef.accept(this)); //添加变量名
        if (node.builder != null) {
            if (node.name.equals(node.builder.name))
                node.builder.accept(this);
            else
                throw new BaseError(node.builder.pos, "class name not match");
        }
        node.funcDefList.forEach(def -> def.accept(this)); //添加函数名
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(FuncDefNode node) {
//        if(currentScope.hasVarInThisScope(node.funcName))
//            throw new BaseError(node.pos, "Function " +node.funcName +" have the same name to a variable");//this change
        node.returnType.accept(this);
        currentScope = new Scope(currentScope, node.returnType.type);
        if (node.args != null)node.args.accept(this);
        node.stmts.forEach(stmt -> stmt.accept(this));
        if ((!VoidType.equals(node.returnType.type) && !node.funcName.equals("main")) && !currentScope.isReturned)
            throw new BaseError(node.pos, "Function " + node.funcName + " should have return statement");
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(VarDefNode node) {
        node.units.forEach(unit -> unit.accept(this));
    }

    @Override
    public void visit(ConstructorNode node) {
        currentScope = new Scope(currentScope, VoidType);
        node.stmts.accept(this);
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(FuncCallArgsNode node) {
        node.exprs.forEach(expr -> expr.accept(this));
    }

    @Override
    public void visit(functionDeclParamListNode node) {
        node.args.forEach(param -> param.accept(this));
    }

    @Override
    public void visit(TypeNode node) {
        switch (node.type.type) {
            case "int", "bool", "string", "void", "null", "this" -> {
            }
            default -> {
                if (globalScope.getClassDef(node.type.type) == null)
                    throw new BaseError(node.pos, "undefined type " + node.type.type);
            }
        }
    }

    @Override
    public void visit(VarDefUnitNode node) {
        node.type.accept(this);
        if (node.inival != null)node.inival.accept(this);
        if (currentScope.hasVarInThisScope(node.name))
            throw new BaseError(node.pos, "redefinition of variable " + node.name);
        currentScope.addVar(node.name, node.type.type);
    }

    @Override
    public void visit(ArrayExp node) {
        node.name.accept(this);
        node.index.accept(this);
        if (node.name.type == null || node.index.type == null || !node.index.type.equals(IntType))
            throw new BaseError(node.pos, "invalid expression");
        node.type = new Type(node.name.type.type, node.name.type.dim - 1);
        if (node.type.dim < 0)
            throw new BaseError(node.pos, "Type mismatch");
    }

    @Override
    public void visit(assignExp node) {
        node.l.accept(this);
        node.r.accept(this);
        if (node.l.type == null || node.r.type == null)
            throw new BaseError(node.pos, "invalid expression");
        if (VoidType.equals(node.l.type) || VoidType.equals(node.r.type))
            throw new BaseError(node.pos, "invalid expression");
        //引用类别可以赋值成null
        if (!node.l.type.equals(node.r.type) && (!(node.l.type.isReferenceType() && NullType.equals(node.r.type))))
            throw new BaseError(node.pos, "Type mismatch");
        node.type = node.l.type;
        if (!node.l.isLeftValue())
            throw new BaseError(node.pos, "Left value required");
    }
    @Override
    public void visit(AtomExprNode node) {
        if (node.str.equals("null")) {
            node.type = NullType;
        } else if (node.str.equals("true") || node.str.equals("false")) {
            node.type = BoolType;
        } else if (node.str.matches("\".*\"")) {
            node.type = StringType;
        } else if (node.str.equals("this")) {
            if (currentScope.inWhichClass == null)
                throw new BaseError(node.pos, "this not in class");
            node.type = new Type(currentScope.inWhichClass.name);
        } else {
            node.type = IntType;
        }
    }
    @Override
    public void visit(BinaryExp node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        if (node.lhs.type == null || node.rhs.type == null)
            throw new BaseError(node.pos, "invalid expression");
        if (NullType.equals(node.lhs.type) || NullType.equals(node.rhs.type)) {
            if ((node.op.equals("==") || node.op.equals("!="))
                && (node.lhs.type.isReferenceType() || node.rhs.type.isReferenceType())) {
                node.type = BoolType;
                return;
            } else if (!node.lhs.type.equals(node.rhs.type)) {
                throw new BaseError(node.pos, "invalid expression");
            }
        }
        if (VoidType.equals(node.lhs.type) || VoidType.equals(node.rhs.type))
            throw new BaseError(node.pos, "invalid expression");
        if (!node.lhs.type.equals(node.rhs.type))
            throw new BaseError(node.pos, "Type mismatch");
        switch (node.op) {
            case "+", "<=", ">=", "<", ">" -> {
                if (!node.lhs.type.equals(IntType) && !node.lhs.type.equals(StringType))
                    throw new BaseError(node.pos, "Type mismatch");
                node.type = node.op.equals("+") ? node.lhs.type : BoolType;
            }
            case "*", "/", "%", "-", ">>", "<<", "&", "^", "|" -> {
                if (!node.lhs.type.equals(IntType))
                    throw new BaseError(node.pos, "Type mismatch");
                node.type = IntType;
            }
            case "&&", "||" -> {
                if (!node.lhs.type.equals(BoolType))
                    throw new BaseError(node.pos, "Type mismatch");
                node.type = BoolType;
            }
            default -> node.type = BoolType;
        }
    }

    @Override
    public void visit(FunctionExp node) {
        node.functionName.accept(this);
        if (node.functionName.funcDef == null)
            throw new BaseError(node.pos, "Function " + node.functionName.str + " is not defined");
        var funcDef = node.functionName.funcDef;
        if (node.args != null) {
            node.args.accept(this);
            if (funcDef.args == null || funcDef.args.args.size() != node.args.exprs.size())
                throw new BaseError(node.pos, "Parameter number mismatch");
            for (int i = 0; i < funcDef.args.args.size(); i++) {
                var param = funcDef.args.args.get(i);
                var arg = node.args.exprs.get(i);
                if (!param.type.type.equals(arg.type) && (!param.type.type.isReferenceType() || !NullType.equals(arg.type)))
                    throw new BaseError(node.pos, "Parameter type mismatch");
            }
        } else {
            if (funcDef.args != null)
                throw new BaseError(node.pos, "Parameter number mismatch");
            }
        node.type = funcDef.returnType.type;
    }

    @Override
    public void visit(NewExprNode node) {
        for (var size : node.sizes) {
            size.accept(this);
            if (size.type == null || !size.type.equals(IntType))
                throw new BaseError(node.pos, "invalid expression");
        }
        new TypeNode(node.pos, node.typeName).accept(this);
        node.type = new Type(node.typeName, node.dim);
    }

    @Override
    public void visit(prefixExp node) {
        node.exp.accept(this);
        if (node.exp.type == null)
            throw new BaseError(node.pos, "invalid expression");
        if (!node.exp.isLeftValue() || !node.exp.type.equals(IntType))
            throw new BaseError(node.pos, "Left value required");
        node.type = IntType;
    }

    @Override
    public void visit(ternaryExp node) {
        node.condition.accept(this);
        node.trueExp.accept(this);
        node.falseExp.accept(this);
        if (!BoolType.equals(node.condition.type))
            throw new BaseError(node.pos, "invalid condition expression");
        if (!node.trueExp.type.equals(node.falseExp.type)){//type不一样
            if(!NullType.equals(node.trueExp.type) && !NullType.equals(node.falseExp.type)){
                throw new BaseError(node.pos, "invalid expression");
            }
            else{
                if(NullType.equals(node.trueExp.type)){
                    node.type = node.falseExp.type;
                }
                else{
                    node.type = node.trueExp.type;
                }
            }
        }
        else{
            node.type = node.trueExp.type;
        }
    }

    @Override
    public void visit(UnaryExp node) {
        node.expr.accept(this);
        if (node.expr.type == null)
            throw new BaseError(node.pos, "invalid expression");
        if (node.op.equals("++") || node.op.equals("--")) {
            if (!node.expr.isLeftValue() || !node.expr.type.equals(IntType))
                throw new BaseError(node.pos, "Left value required");
            node.type = IntType;
        } else if (node.op.equals("!")) {
            if (!node.expr.type.equals(BoolType))
                throw new BaseError(node.pos, "Type is not bool");
            node.type = BoolType;
        } else {
            if (!node.expr.type.equals(IntType))
                throw new BaseError(node.pos, "Type is not int");
            node.type = IntType;
        }
    }
    @Override
    public void visit(VarExprNode node) {
        node.type = currentScope.getVarType(node.str);
        if (currentScope.inWhichClass != null && currentScope.inWhichClass.getFuncDef(node.str) != null)
            node.funcDef = currentScope.inWhichClass.getFuncDef(node.str);
        else
            node.funcDef = globalScope.getFuncDef(node.str);
    }

    @Override
    public void visit(blockStmt node) {
        currentScope = new Scope(currentScope);
        node.stmts.forEach(stmt -> stmt.accept(this));
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(branchstmt node) {
        node.condition.accept(this);
        if (!BoolType.equals(node.condition.type))
            throw new BaseError(node.pos, "invalid condition expression");
        currentScope = new Scope(currentScope);
        node.thenstmt.accept(this);
        currentScope = currentScope.parentScope;
        if (node.elsestmt != null) {
            currentScope = new Scope(currentScope);
            node.elsestmt.accept(this);
            currentScope = currentScope.parentScope;
        }
    }

    @Override
    public void visit(breakStmt node) {
        if (!currentScope.inLoop)
            throw new BaseError(node.pos, "break statement not in loop");
    }

    @Override
    public void visit(continueStmt node) {
        if (!currentScope.inLoop)
            throw new BaseError(node.pos, "continue statement not in loop");
    }

    @Override
    public void visit(ForStmtNode node) {
        currentScope = new Scope(currentScope, true);
        if (node.varDef != null)
            node.varDef.accept(this);
        if (node.init != null)
            node.init.accept(this);
        if (node.cond != null) {
            node.cond.accept(this);
            if (!BoolType.equals(node.cond.type))
                throw new BaseError(node.pos, "invalid condition expression");
        }
        if (node.step != null)node.step.accept(this);
        node.stmts.accept(this);
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(ExprStmt node) {
        if (node.expr != null)
            node.expr.accept(this);
    }

    @Override
    public void visit(returnStmt node) {
        for (var theScope = currentScope; theScope != null; theScope = theScope.parentScope)
            if (theScope.returnType != null) {
                if (node.expr == null) {
                    if (!theScope.returnType.equals(VoidType))
                        throw new BaseError(node.pos, "return type mismatch");
                } else {
                    node.expr.accept(this);
                    if (!theScope.returnType.equals(node.expr.type)
                        && (!theScope.returnType.isReferenceType() || !NullType.equals(node.expr.type))) {
                        throw new BaseError(node.pos, "return type mismatch");
                    }
                }
                theScope.isReturned = true;
                return;
            }
        throw new BaseError(node.pos, "return statement outside function");
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.cond.accept(this);
        if (!BoolType.equals(node.cond.type))
            throw new BaseError(node.pos, "invalid condition expression");
        currentScope = new Scope(currentScope, true);
        node.stmts.accept(this);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(memberExp node) {
        node.obj.accept(this);
        if (node.obj.type == null)
            throw new BaseError(node.pos, "invalid expression");
        if (!node.obj.type.isReferenceType() && !ThisType.equals(node.obj.type) && !StringType.equals(node.obj.type))
            throw new BaseError(node.pos, "Type mismatch");
        var classDef = ThisType.equals(node.obj.type) ? currentScope.inWhichClass
                                                    : globalScope.getClassDef(node.obj.type.type);//是哪个类
        if (node.obj.type.dim > 0) {//说明还是数组
            if (classDef == null)
                throw new BaseError(node.pos, "Type mismatch");
            if (node.member.equals("size"))//是调用数组函数
                node.funcDef = ArraySizeFunc;
        } else {
            if (classDef == null)
                throw new BaseError(node.pos, "Class " + node.obj.type.type + " is not defined");
            node.type = classDef.getVarType(node.member);
            node.funcDef = classDef.getFuncDef(node.member);
        }
    }

}
