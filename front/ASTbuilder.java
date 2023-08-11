package front;


import AST.*;
import AST.expr.*;
import AST.stmt.*;
import Utils.*;
import antlr.*;
import antlr.MxParser.*;
public class ASTbuilder extends MxParserBaseVisitor<Node> {
    @Override
    public Node visitProgram(MxParser.ProgramContext ctx){
        ProgramNode program = new ProgramNode(new position(ctx));
        for(var def: ctx.children){
            if (def instanceof FunctionDeclarationContext){
                program.deflist.add((FuncDefNode) visit(def));
            }else if(def instanceof ClassDeclarationContext){
                program.deflist.add((ClassDefNode) visit(def));
            }else if(def instanceof VariableDeclarationContext){
                program.deflist.add((VarDefNode) visit(def));
            }
        }
        return program;
    }
    @Override//1
    public FuncDefNode visitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx){
        FuncDefNode funcdef = new FuncDefNode(new position(ctx));
        funcdef.funcName = ctx.Identifier().getText();
        funcdef.returnType = (TypeNode)visit(ctx.returnType());
        if (ctx.functionDeclParamList()!=null){
            funcdef.args = (functionDeclParamListNode)visit(ctx.functionDeclParamList());
        }
        
        funcdef.stmts = ((blockStmt)visit(ctx.body)).stmts;
        return funcdef;
    }
    @Override public Node visitReturnType(MxParser.ReturnTypeContext ctx) {
        if(ctx.Void()!=null)
            return new TypeNode(new position(ctx),ctx.getText());
        else
            return (TypeNode)visit(ctx.typename());
    }
    //定义的函数参数列表
    @Override
    public functionDeclParamListNode visitFunctionDeclParamList(MxParser.FunctionDeclParamListContext ctx){
        functionDeclParamListNode parameterList = new functionDeclParamListNode(new position(ctx));
        for (int i = 0; i < ctx.typename().size(); ++i)
            parameterList.args.add(new VarDefUnitNode(
                new position(ctx.typename(i)),
                (TypeNode) visit(ctx.typename(i)),
                ctx.Identifier(i).getText(),
                null));
        return parameterList;
    }
    @Override
    public FuncCallArgsNode visitFunctionCallArgList(MxParser.FunctionCallArgListContext ctx) {
        FuncCallArgsNode funcCallArgsNode = new FuncCallArgsNode(new position(ctx));
        for(int i=0;i<ctx.expression().size();i++){
            funcCallArgsNode.exprs.add((ExprNode)visit(ctx.expression(i)));
        }
        return funcCallArgsNode;
    }
    @Override public Node visitBlockStatement(MxParser.BlockStatementContext ctx) {
        blockStmt blocks = new blockStmt(new position(ctx));
        ctx.statement().forEach(stmt -> blocks.stmts.add((StmtNode) visit(stmt)));
        return blocks;
    }
    @Override
    public ClassDefNode visitClassDeclaration(MxParser.ClassDeclarationContext ctx) {
        ClassDefNode classDef = new ClassDefNode(new position(ctx), ctx.Identifier().getText());
        boolean hasConstructor = false;
        for (var def : ctx.children)
            if (def instanceof FunctionDeclarationContext) {
                classDef.funcDefList.add((FuncDefNode) visit(def));
            } else if (def instanceof VariableDeclarationContext) {
                classDef.varDefList.add((VarDefNode) visit(def));
            } else if (def instanceof ConstructorDeclarationContext) {
                if (hasConstructor)throw new BaseError(new position(ctx), "Multiple constructors");
                hasConstructor = true;
                classDef.builder = (ConstructorNode) visit(def);
            }
        return classDef;
    }
    @Override
    public ConstructorNode visitConstructorDeclaration(MxParser.ConstructorDeclarationContext ctx) {
        ConstructorNode consdef=new ConstructorNode(new position(ctx));
        consdef.name = ctx.Identifier().getText();
        consdef.stmts = (blockStmt)visit(ctx.body);
        return consdef;
    }
    @Override
    public VarDefNode visitVariableDeclaration(MxParser.VariableDeclarationContext ctx) {
        VarDefNode varDef = new VarDefNode(new position(ctx));
        TypeNode type = (TypeNode) visit(ctx.typename());
        for (var unit : ctx.initDeclarator())
            varDef.units.add((new VarDefUnitNode(
                            new position(unit),
                            type,
                            unit.Identifier().getText(),
                            unit.initializer == null ? null : (ExprNode) visit(unit.initializer))));
        return varDef;
    }
    // //这个函数应当不被用到
    // @Override
    // public VarDefUnitNode visitInitDeclarator(MxParser.InitDeclaratorContext ctx) {
    //     VarDefUnitNode unit=new VarDefUnitNode(null, null, null, null);
    //     return unit;
    // }
    @Override public Node visitTypename(MxParser.TypenameContext ctx) {
        return new TypeNode(new position(ctx), ctx.typenames().getText(), ctx.LBracket().size());
    }
    // @Override public Node visitTypeName(MxParser.TypeNameContext ctx) {
    // }
    // @Override public Node visitBaseType(MxParser.BaseTypeContext ctx) {
    // }
    @Override public Node visitStatement(MxParser.StatementContext ctx) {
        if(ctx.blockStatement()!=null)
            return visit(ctx.blockStatement());
        else if(ctx.variableDeclaration()!=null)
            return visit(ctx.variableDeclaration());
        else if(ctx.branchStatement()!=null)
            return visit(ctx.branchStatement());
        else if(ctx.forStatement()!=null)
            return visit(ctx.forStatement());
        else if(ctx.whileStatement()!=null)
            return visit(ctx.whileStatement());
        else if(ctx.continueStatement()!=null)
            return visit(ctx.continueStatement());
        else if(ctx.breakStatement()!=null)
            return visit(ctx.breakStatement());
        else if(ctx.returnStatement()!=null)
            return visit(ctx.returnStatement());
        else if(ctx.expressionStatement()!=null)
            return visit(ctx.expressionStatement());
        else return visitChildren(ctx);
    }
    
    @Override
    public branchstmt visitBranchStatement(MxParser.BranchStatementContext ctx) {
        branchstmt branch = new branchstmt(new position(ctx));
        branch.condition = (ExprNode)visit(ctx.condition);
        branch.thenstmt = (StmtNode)visit(ctx.ifStatement);
        if (ctx.elseStatement != null) {
            branch.elsestmt = (StmtNode)visit(ctx.elseStatement);
        }
        else branch.elsestmt = null;
        return branch;
    }//tag
    @Override public Node visitWhileStatement(MxParser.WhileStatementContext ctx) {
        WhileStmtNode whileStmt = new WhileStmtNode(new position(ctx), (ExprNode) visit(ctx.expression()));
        whileStmt.stmts=(StmtNode)visit(ctx.statement());
        return whileStmt;
    }
    @Override
    public Node visitForStatement(MxParser.ForStatementContext ctx) {
        ForStmtNode forloop = new ForStmtNode(new position(ctx));
        if(ctx.forInit().variableDeclaration()!=null){
            forloop.varDef = (VarDefNode) visit(ctx.forInit());
        }
        if(ctx.forInit().expressionStatement()!=null){
            forloop.init=((ExprStmt) visit(ctx.forInit().expressionStatement())).expr;
        }
        forloop.cond = ((ExprStmt) visit(ctx.expressionStatement())).expr;
        if(ctx.expression()!=null){
            forloop.step = (ExprNode)visit(ctx.expression());
        }
        forloop.stmts = (StmtNode) visit(ctx.statement());
        return forloop;
    }
    /*
//    @Override
//    public breakStmt.whileloopStmt visitWhileLoop(MxParser.WhileLoopContext ctx) {
//        breakStmt.whileloopStmt whilest=new breakStmt.whileloopStmt(new position(ctx),(ExprNode)visit(ctx.condition));
//        whilest.stmts = (StmtNode)visit(ctx.body);
//        return whilest;
//    }
//    @Override
//    public branchstmt.forloopStmt visitDeclForLoop(MxParser.DeclForLoopContext ctx) {
//        branchstmt.forloopStmt forloop = new branchstmt.forloopStmt(new position(ctx));
//        forloop.varDef = (VarDefNode)visit(ctx.variableDeclaration());
//        if(ctx.condition!=null){
//            forloop.condition = (ExprNode)visit(ctx.condition);
//        }
//        else forloop.condition = null;
//        if(ctx.step!=null){
//            forloop.step = (ExprNode)visit(ctx.step);
//        }
//        else forloop.step = null;
//        forloop.stmts = (StmtNode)visit(ctx.body);
//        return forloop;
//    }
//    @Override
//    public branchstmt.forloopStmt visitExprForLoop(MxParser.ExprForLoopContext ctx) {
//        branchstmt.forloopStmt forloop = new branchstmt.forloopStmt(new position(ctx));
//        if(ctx.init!=null){
//            forloop.init = (ExprNode)visit(ctx.init);
//        }
//        if(ctx.condition!=null){
//            forloop.condition = (ExprNode)visit(ctx.condition);
//        }
//        else forloop.condition = null;
//        if(ctx.step!=null){
//            forloop.step = (ExprNode)visit(ctx.step);
//        }
//        else forloop.step = null;
//        forloop.stmts = (StmtNode)visit(ctx.body);
//        return forloop;
//    }
//    @Override public Node visitControlFlowStatement(MxParser.ControlFlowStatementContext ctx) {
//        if(ctx.continueStatement()!=null)
//            return visit(ctx.continueStatement());
//        else if(ctx.breakStatement()!=null)
//            return visit(ctx.breakStatement());
//        else if(ctx.returnStatement()!=null)
//            return visit(ctx.returnStatement());
//        else return visitChildren(ctx);
//    }
    */
    @Override
    public ExprStmt visitExpressionStatement(MxParser.ExpressionStatementContext ctx) {
        ExprStmt exprst=new ExprStmt(new position(ctx));
        if(ctx.expression()!=null)
            exprst.expr = (ExprNode)visit(ctx.expression());
        else exprst.expr=null;
        return exprst;
    }
    @Override
    public continueStmt visitContinueStatement(MxParser.ContinueStatementContext ctx) {
        return new continueStmt(new position(ctx));
    }
    @Override
    public breakStmt visitBreakStatement(MxParser.BreakStatementContext ctx) {
        return new breakStmt(new position(ctx));
    }
    @Override
    public returnStmt visitReturnStatement(MxParser.ReturnStatementContext ctx) {
        returnStmt retust = new returnStmt(new position(ctx));
        if(ctx.expression()!=null)retust.expr = (ExprNode)visit(ctx.expression());
        return retust;
    }
    /*
    // @Override
    // public TypeNode visitArrayType(MxParser.ArrayTypeContext ctx) {
    //     TypeNode temp = (TypeNode)visit(ctx.typename());
    //     TypeNode ans = new TypeNode(new position(ctx));
    //     ans.type = temp.type;
    //     ans.type.dim +=1;
    //     return ans;
    // }
    // @Override
    // public TypeNode visitPrimitiveType(MxParser.PrimitiveTypeContext ctx) {
    //     TypeNode typenode;
    //     typenode = (TypeNode)visit(ctx.primitiveTypename());
    //     return typenode;
    // }
    // @Override
    // public TypeNode visitClassType(MxParser.ClassTypeContext ctx) {
    //     TypeNode typenode;
    //     typenode = (TypeNode)visit(ctx.identifier());
    //     return typenode;
    // }
    
    // @Override public NewExprNode visitNewClass(MxParser.NewClassContext ctx) {
    //     NewExprNode newexp = new NewExprNode(new position(ctx),ctx.identifier().Identifier().getText());
    //     newexp.dim = 0;
    //     return newexp;
    // }
    // @Override public NewExprNode visitNewClassArray(MxParser.NewClassArrayContext ctx) {
    //     NewExprNode newexp = new NewExprNode(new position(ctx),ctx.identifier().Identifier().getText());
    //     newexp.dim += ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size();
    //     for(int i=0;i<ctx.newArrayExprCount().size();i++){
    //         newexp.sizes.add((ExprNode)visit(ctx.newArrayEmptyCount(i)));
    //     }
    //     return newexp;
    // }
    // @Override public NewExprNode visitNewPrimitiveArray(MxParser.NewPrimitiveArrayContext ctx) {
    //     String name;
    //     if(ctx.primitiveTypename() instanceof VoidTypeContext)name = "void";
    //     else if(ctx.primitiveTypename() instanceof BoolTypeContext)name = "bool";
    //     else if(ctx.primitiveTypename() instanceof IntTypeContext)name = "int";
    //     else if(ctx.primitiveTypename() instanceof StringTypeContext)name = "string";
    //     else name = "???";
    //     NewExprNode newexp = new NewExprNode(new position(ctx),name);
    //     newexp.dim += ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size();
    //     for(int i=0;i<ctx.newArrayExprCount().size();i++){
    //         newexp.sizes.add((ExprNode)visit(ctx.newArrayEmptyCount(i)));
    //     }
    //     return newexp;
    // }
    // @Override public ExprNode visitNewArrayExprCount(MxParser.NewArrayExprCountContext ctx) {
    //     ExprNode expr;
    //     expr = (ExprNode)visit(ctx.expression());
    //     return expr;
    // }
    */
    @Override public Node visitArrayExpr(MxParser.ArrayExprContext ctx) {
        var expr = new ArrayExp(new position(ctx), (ExprNode) visit(ctx.expression(0)), (ExprNode) visit(ctx.expression(1)));
        expr.str = ctx.getText();
        return expr;
    }
    @Override
    public ternaryExp visitTernaryexp(MxParser.TernaryexpContext ctx) {
        ternaryExp tern = new ternaryExp(new position(ctx));
        tern.condition = (ExprNode)visit(ctx.a);
        tern.trueExp = (ExprNode)visit(ctx.b);
        tern.falseExp = (ExprNode)visit(ctx.c);
        return tern;
    }
    @Override
    public memberExp visitMemberExpr(MxParser.MemberExprContext ctx) {
        var expr = new memberExp(new position(ctx), (ExprNode) visit(ctx.expression()), ctx.Identifier().getText());
        expr.str = ctx.getText();
        return expr;
    }
    @Override
    public BinaryExp visitBinaryExpr(MxParser.BinaryExprContext ctx) {
        return new BinaryExp(
            new position(ctx),
            ctx.op.getText(),
            (ExprNode) visit(ctx.l),
            (ExprNode) visit(ctx.r));
    }
    @Override
    public NewExprNode visitNewExpr(MxParser.NewExprContext ctx) {
        NewExprNode newExpr = new NewExprNode(new position(ctx), ctx.typename().getText());
        newExpr.dim = ctx.newArrayUnit().size();
        boolean isEmpty = false;
        for (var unit : ctx.newArrayUnit()) {
            if (unit.expression() == null)
                isEmpty = true;
            else if (isEmpty)
                throw new BaseError(new position(ctx), "Array dimension cannot be empty");
            else
                newExpr.sizes.add((ExprNode) visit(unit.expression()));
        }
        return newExpr;
    }
    @Override
    public prefixExp visitPrefixUpdateExpr(MxParser.PrefixUpdateExprContext ctx) {
        prefixExp prefix = new prefixExp(new position(ctx));
        prefix.exp = (ExprNode)visit(ctx.expression());
        prefix.op = ctx.op.getText().equals("++");
        return prefix;
    }
    // @Override public ExprNode visitLhsExpr(MxParser.LhsExprContext ctx) {
    //     ExprNode x = (ExprNode)visit(ctx.lhsExpression());
    //     return x;
    // }
    @Override
    public Node visitParenthesesExpr(MxParser.ParenthesesExprContext ctx) {
        return (ExprNode) visit(ctx.expression());
    }
    @Override
    public Node visitAtomExpr(MxParser.AtomExprContext ctx) {
        var expr = (ExprNode) visitChildren(ctx);
        expr.str = ctx.getText();
        return expr;
    }
    @Override
    public UnaryExp visitUnaryExpr(MxParser.UnaryExprContext ctx) {
        UnaryExp x = new UnaryExp(new position(ctx));
        x.op = ctx.op.getText();
        x.expr = (ExprNode)visit(ctx.expression());
        return x;
    }
    @Override
    public Node visitFuncExpr(MxParser.FuncExprContext ctx) {
        FunctionExp funcExpr = new FunctionExp(new position(ctx), (ExprNode) visit(ctx.expression()));
        if (ctx.functionCallArgList() != null)
            funcExpr.args = (FuncCallArgsNode) visit(ctx.functionCallArgList());
        return funcExpr;
    }
    @Override
    public assignExp visitAssignExpr(MxParser.AssignExprContext ctx) {
        assignExp assign = new assignExp(new position(ctx));
        assign.l = (ExprNode)visit(ctx.l);
        assign.r = (ExprNode)visit(ctx.r);
        return assign;
    }
    // @Override public Node visitNewArrayUnit(MxParser.NewArrayUnitContext ctx) {
    // }
    @Override
    public Node visitPrimary(MxParser.PrimaryContext ctx) {
        return ctx.Identifier() == null ? new AtomExprNode(new position(ctx), ctx.getText()) 
                            : new VarExprNode(new position(ctx), ctx.getText());
    }
/*
    // @Override public stringLiteral visitLiteralString(MxParser.LiteralStringContext ctx) {
    //     stringLiteral x = (stringLiteral)visit(ctx.stringLiteral());
    //     return x;
    // }
    // @Override public thisLiteral visitLiteralThis(MxParser.LiteralThisContext ctx) {
    //     thisLiteral x = (thisLiteral)visit(ctx.thisLiteral());
    //     return x;
    // }
    // @Override public logicLiteral visitLiteralLogic(MxParser.LiteralLogicContext ctx) {
    //     logicLiteral x = (logicLiteral)visit(ctx.logicLiteral());
    //     return x;
    // }
    // @Override public nullLiteral visitLiteralNull(MxParser.LiteralNullContext ctx) {
    //     nullLiteral x = (nullLiteral)visit(ctx.nullLiteral());
    //     return x;
    // }
    // @Override public numberLiteral visitLiteralNumber(MxParser.LiteralNumberContext ctx) {   
    //     numberLiteral x = (numberLiteral)visit(ctx.numberLiteral());
    //     return x;
    // }
    // @Override public ArrayExp visitArrayExpr(MxParser.ArrayExprContext ctx) {
    //     ArrayExp t = new ArrayExp(new position(ctx),(ExprNode)visit(ctx.lhsExpression()),(ExprNode)visit(ctx.expression()));
    //     return t;
    // }
    // @Override public memeryvar visitMemberVariableAccessExpr(MxParser.MemberVariableAccessExprContext ctx) {
    //     memeryvar vars = new memeryvar(new position(ctx));
    //     vars.node = (ExprNode)visit(ctx.lhsExpression());
    //     vars.variable = ctx.variable.getText();
    //     return vars;
    // }
    // @Override public identifierExp visitIdentifierExpr(MxParser.IdentifierExprContext ctx) {
    //     identifierExp iden = new identifierExp(new position(ctx));
    //     iden.name = ctx.identifier().getText();
    //     return iden;
    // }
    // @Override public FunctionExp visitFunCallExpr(MxParser.FunCallExprContext ctx) {
    //     FunctionExp func = new FunctionExp(new position(ctx), ctx.identifier().getText());
    //     func.args = (FuncCallArgsNode)visit(ctx.functionCallArgList());
    //     return func;
    // }
    // @Override public literalNode visitLiteralExpr(MxParser.LiteralExprContext ctx) {
    //     literalNode lit = (literalNode)visit(ctx.literalExpression());
    //     return lit;
    // }
    // @Override public parentExp visitParenthesesExpr(MxParser.ParenthesesExprContext ctx) {
    //     parentExp par = new parentExp(new position(ctx));
    //     par.expr = (ExprNode)visit(ctx.expression());
    //     return par;
    // }
    // @Override public memeryfunc visitMemberFunctionAccessExpr(MxParser.MemberFunctionAccessExprContext ctx) {
    //     memeryfunc memfun = new memeryfunc(new position(ctx));
    //     memfun.node = (ExprNode)visit(ctx.lhsExpression());
    //     memfun.method = ctx.method.getText();
    //     memfun.args = (FuncCallArgsNode)visit(ctx.functionCallArgList());
    //     return memfun;
    // }
 */
}
