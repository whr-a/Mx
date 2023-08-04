package front;

import AST.*;
import antlr.*;
import antlr.MxParser.*;
import AST.expr.*;
import AST.expr.literal.logicLiteral;
import AST.expr.literal.nullLiteral;
import AST.expr.literal.numberLiteral;
import AST.expr.literal.stringLiteral;
import AST.expr.literal.thisLiteral;
import AST.stmt.*;
import Utils.*;
public class ASTbuilder extends MxParserBaseVisitor<Node>{
    @Override
    public ProgramNode visitTranslationUnit(MxParser.TranslationUnitContext ctx){
        ProgramNode program = new ProgramNode(new position(ctx));
        for(var def: ctx.children){
            if (def instanceof FunctionDeclarContext){
                program.deflist.add((FuncDefNode) visit(def));
            }else if(def instanceof ClassDeclarContext){
                program.deflist.add((ClassDefNode) visit(def));
            }else if(def instanceof GlobalVariableDeclarContext){
                program.deflist.add((VarDefNode) visit(def));
            }
        }
        return program;
    }
    @Override public FuncDefNode visitFunctionDeclar(MxParser.FunctionDeclarContext ctx) {
        FuncDefNode funcdef;
        funcdef = (FuncDefNode)visit(ctx.functionDeclaration());
        return funcdef;
    }
    @Override public ClassDefNode visitClassDeclar(MxParser.ClassDeclarContext ctx) {
        ClassDefNode classdef;
        classdef = (ClassDefNode)visit(ctx.classDeclaration());
        return classdef;
    }
    @Override public VarDefNode visitGlobalVariableDeclar(MxParser.GlobalVariableDeclarContext ctx) {
        VarDefNode vardef;
        vardef = (VarDefNode)visit(ctx.variableDeclaration());
        return vardef;
    }
    @Override
    public FuncDefNode visitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx){
        FuncDefNode funcdef = new FuncDefNode(new position(ctx));
        funcdef.funcName = ctx.identifier().getText();
        funcdef.returnType = (TypeNode)visit(ctx.typename());
        if (ctx.functionDeclParamList()!=null){
            funcdef.args = (functionDeclParamListNode)visit(ctx.functionDeclParamList());
        }
        
        funcdef.stmts = ((blockStmt)visit(ctx.body)).stmts;
        return funcdef;
    }
    @Override
    public functionDeclParamListNode visitFunctionDeclParamList(MxParser.FunctionDeclParamListContext ctx){
        functionDeclParamListNode funcdeclList = new functionDeclParamListNode(new position(ctx));
        for(int i=0;i<ctx.functionDeclParam().size();i++){
            funcdeclList.args.add((VarDefUnitNode)visit(ctx.functionDeclParam(i)));
        }
        return funcdeclList;
    }
    @Override
    public VarDefUnitNode visitFunctionDeclParam(MxParser.FunctionDeclParamContext ctx) {
        VarDefUnitNode vardef= new VarDefUnitNode(new position(ctx),(TypeNode)visit(ctx.typename()),ctx.identifier().getText());
        return vardef;
    }
    @Override
    public FuncCallArgsNode visitFunctionCallArgList(MxParser.FunctionCallArgListContext ctx) {
        FuncCallArgsNode funcCallArgsNode = new FuncCallArgsNode(new position(ctx));
        for(int i=0;i<ctx.expression().size();i++){
            funcCallArgsNode.exprs.add((ExprNode)visit(ctx.expression(i)));
        }
        return funcCallArgsNode;
    }
    @Override
    public ClassDefNode visitClassDeclaration(MxParser.ClassDeclarationContext ctx) {
        ClassDefNode classdef = new ClassDefNode(new position(ctx),ctx.identifier().getText());
        for (ClassComponentsContext component : ctx.classComponents()) {
            if (component instanceof ClassMemberDeclarContext) {
                classdef.components.add((VarDefNode)visit(component));
            } else if (component instanceof ClassMethodDeclarContext) {
                classdef.components.add((ClassDefNode)visit(component));
            } else if (component instanceof ConstructorDeclarContext) {
                classdef.components.add((ConstructorNode)visit(component));
            }
        }
        return classdef;
    }
    @Override public VarDefNode visitClassMemberDeclar(MxParser.ClassMemberDeclarContext ctx) {
        VarDefNode vardef;
        vardef = (VarDefNode)visit(ctx.variableDeclaration());
        return vardef;
    }
    @Override public FuncDefNode visitClassMethodDeclar(MxParser.ClassMethodDeclarContext ctx) {
        FuncDefNode funcdef;
        funcdef = (FuncDefNode)visit(ctx.functionDeclaration());
        return funcdef;
    }
    @Override public ConstructorNode visitConstructorDeclar(MxParser.ConstructorDeclarContext ctx) {
        ConstructorNode consdef;
        consdef = (ConstructorNode)visit(ctx.constructorDeclaration());
        return consdef;
    }
    @Override public ConstructorNode visitConstructorDeclaration(MxParser.ConstructorDeclarationContext ctx) {
        ConstructorNode consdef=new ConstructorNode(new position(ctx));
        consdef.name = ctx.identifier().getText();
        consdef.stmts = ((blockStmt)visit(ctx.body)).stmts;
        return consdef;
    }
    @Override public blockStmt visitBlockStmt(MxParser.BlockStmtContext ctx) {
        blockStmt blocks;
        blocks = (blockStmt)visit(ctx.blockStatement());
        return blocks;
    }
    @Override public VarDefNode visitVarDeclarStmt(MxParser.VarDeclarStmtContext ctx) {
        VarDefNode vardef;
        vardef = (VarDefNode)visit(ctx.variableDeclaration());
        return vardef;
    }
    @Override public ExprStmt visitExpressionStmt(MxParser.ExpressionStmtContext ctx) {
        ExprStmt exprdef;
        exprdef = (ExprStmt)visit(ctx.expressionStatement());
        return exprdef;
    }
    @Override public branchstmt visitBranchStmt(MxParser.BranchStmtContext ctx) {
        branchstmt branstmt;
        branstmt = (branchstmt)visit(ctx.branchStatement());
        return branstmt;
    }
    @Override public StmtNode visitLoopStmt(MxParser.LoopStmtContext ctx) {
        StmtNode stmt;
        stmt = (StmtNode)visit(ctx.loopStatement());
        return stmt;
    }
    @Override public StmtNode visitCtrlFlowStmt(MxParser.CtrlFlowStmtContext ctx) {
        StmtNode stmt;
        stmt = (StmtNode)visit(ctx.controlFlowStatement());
        return stmt;
    }
    @Override public emptyStmt visitEmptyStmt(MxParser.EmptyStmtContext ctx) {
        emptyStmt empty=new emptyStmt(new position(ctx));
        return empty;
    }
    @Override public blockStmt visitBlockStatement(MxParser.BlockStatementContext ctx) {
        blockStmt blocks = new blockStmt(new position(ctx));
        for(int i=0;i<ctx.statement().size();i++){
            blocks.stmts.add((StmtNode)visit(ctx.statement(i)));
        }
        return blocks;
    }
    @Override public VarDefNode visitVariableDeclaration(MxParser.VariableDeclarationContext ctx) {
        VarDefNode vardef = new VarDefNode(new position(ctx));
        for(int i=0;i<ctx.initDeclarator().size();i++){
            VarDefUnitNode unit=new VarDefUnitNode(new position(ctx), (TypeNode)visit(ctx.typename()), ctx.initDeclarator(i).identifier().getText(),(ExprNode)visit(ctx.initDeclarator(i).initializer));
            vardef.units.add(unit);
        }
        return vardef;
    }
    //这个函数应当不被用到
    @Override public VarDefUnitNode visitInitDeclarator(MxParser.InitDeclaratorContext ctx) {
        VarDefUnitNode unit=new VarDefUnitNode(null, null, null, null);
        return unit;
    }
    @Override public ExprStmt visitExpressionStatement(MxParser.ExpressionStatementContext ctx) {
        ExprStmt exprst=new ExprStmt(new position(ctx));
        exprst.expr = (ExprNode)visit(ctx.expression());
        return exprst;
    }
    @Override public branchstmt visitBranchStatement(MxParser.BranchStatementContext ctx) {
        branchstmt branch = new branchstmt(new position(ctx));
        branch.condition = (ExprNode)visit(ctx.condition);
        branch.thenstmt = (StmtNode)visit(ctx.ifStatement);
        branch.elsestmt = (StmtNode)visit(ctx.elseStatement);
        return branch;
    }
    @Override public whileloopStmt visitWhileLoop(MxParser.WhileLoopContext ctx) {
        whileloopStmt whilest=new whileloopStmt(new position(ctx));
        whilest.condition = (ExprNode)visit(ctx.condition);
        whilest.body = (StmtNode)visit(ctx.body);
        return whilest;
    }
    @Override public DeclForloopStmt visitDeclForLoop(MxParser.DeclForLoopContext ctx) {
        DeclForloopStmt declfor=new DeclForloopStmt(new position(ctx));
        declfor.vardef = (VarDefNode)visit(ctx.init);
        declfor.condition = (ExprStmt)visit(ctx.condition);
        declfor.step = (ExprStmt)visit(ctx.step);
        declfor.body = (StmtNode)visit(ctx.body);
        return declfor;
    }
    @Override public ExprForloopStmt visitExprForLoop(MxParser.ExprForLoopContext ctx) {
        ExprForloopStmt exprfor = new ExprForloopStmt(new position(ctx));
        exprfor.init = (ExprStmt)visit(ctx.init);
        exprfor.condition = (ExprStmt)visit(ctx.condition);
        exprfor.step = (ExprStmt)visit(ctx.step);
        exprfor.body = (StmtNode)visit(ctx.body);
        return exprfor;
    }
    @Override public continueStmt visitContinueStmt(MxParser.ContinueStmtContext ctx) {
        continueStmt contist;
        contist = (continueStmt)visit(ctx.continueStatement());
        return contist;
    }
    @Override public breakStmt visitBreakStmt(MxParser.BreakStmtContext ctx) {
        breakStmt breast;
        breast = (breakStmt)visit(ctx.breakStatement());
        return breast;
    }
    @Override public returnStmt visitReturnStmt(MxParser.ReturnStmtContext ctx) {
        returnStmt retust;
        retust = (returnStmt)visit(ctx.returnStatement());
        return retust;
    }
    @Override public continueStmt visitContinueStatement(MxParser.ContinueStatementContext ctx) {
        continueStmt contist=new continueStmt(new position(ctx));
        return contist;
    }
    @Override public breakStmt visitBreakStatement(MxParser.BreakStatementContext ctx) {
        breakStmt breast = new breakStmt(new position(ctx));
        return breast;
    }
    @Override public returnStmt visitReturnStatement(MxParser.ReturnStatementContext ctx) {
        returnStmt retust = new returnStmt(new position(ctx));
        return retust;
    }
    @Override public emptyStmt visitEmptyStatement(MxParser.EmptyStatementContext ctx) {
        emptyStmt emptst = new emptyStmt(new position(ctx));
        return emptst;
    }
    @Override public TypeNode visitArrayType(MxParser.ArrayTypeContext ctx) {
        TypeNode temp = (TypeNode)visit(ctx.typename());
        TypeNode ans = new TypeNode(new position(ctx));
        ans.type = temp.type;
        ans.type.dim +=1;
        return ans;
    }
    @Override public TypeNode visitPrimitiveType(MxParser.PrimitiveTypeContext ctx) {
        TypeNode typenode;
        typenode = (TypeNode)visit(ctx.primitiveTypename());
        return typenode;
    }
    @Override public TypeNode visitClassType(MxParser.ClassTypeContext ctx) {
        TypeNode typenode;
        typenode = (TypeNode)visit(ctx.identifier());
        return typenode;
    }
    @Override public NewExprNode visitNewClass(MxParser.NewClassContext ctx) {
        NewExprNode newexp = new NewExprNode(new position(ctx),ctx.identifier().Identifier().getText());
        newexp.dim = 0;
        return newexp;
    }
    @Override public NewExprNode visitNewClassArray(MxParser.NewClassArrayContext ctx) {
        NewExprNode newexp = new NewExprNode(new position(ctx),ctx.identifier().Identifier().getText());
        newexp.dim += ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size();
        for(int i=0;i<ctx.newArrayExprCount().size();i++){
            newexp.sizes.add((ExprNode)visit(ctx.newArrayEmptyCount(i)));
        }
        return newexp;
    }
    @Override public NewExprNode visitNewPrimitiveArray(MxParser.NewPrimitiveArrayContext ctx) {
        String name;
        if(ctx.primitiveTypename() instanceof VoidTypeContext)name = "void";
        else if(ctx.primitiveTypename() instanceof BoolTypeContext)name = "bool";
        else if(ctx.primitiveTypename() instanceof IntTypeContext)name = "int";
        else if(ctx.primitiveTypename() instanceof StringTypeContext)name = "string";
        else name = "???";
        NewExprNode newexp = new NewExprNode(new position(ctx),name);
        newexp.dim += ctx.newArrayExprCount().size() + ctx.newArrayEmptyCount().size();
        for(int i=0;i<ctx.newArrayExprCount().size();i++){
            newexp.sizes.add((ExprNode)visit(ctx.newArrayEmptyCount(i)));
        }
        return newexp;
    }
    @Override public ExprNode visitNewArrayExprCount(MxParser.NewArrayExprCountContext ctx) {
        ExprNode expr;
        expr = (ExprNode)visit(ctx.expression());
        return expr;
    }
    //下方函数不应当被调用
    @Override public Node visitNewArrayEmptyCount(MxParser.NewArrayEmptyCountContext ctx) {
        Node xNode = new Node(null);
        return xNode;
    }
    @Override public TypeNode visitIdentifier(MxParser.IdentifierContext ctx) {
        TypeNode typenode = new TypeNode(new position(ctx));
        typenode.type = new Type(ctx.Identifier().getText(),0);
        return typenode;
    }
    @Override public stringLiteral visitStringLiteral(MxParser.StringLiteralContext ctx) {
        stringLiteral lit = new stringLiteral(new position(ctx), ctx.StringLiteral().getText());
        return lit;
    }
    @Override public thisLiteral visitThisLiteral(MxParser.ThisLiteralContext ctx) {
        thisLiteral lit = new thisLiteral(new position(ctx));
        return lit;
    }
    @Override public logicLiteral visitLogicLiteral(MxParser.LogicLiteralContext ctx) {
        logicLiteral lit = new logicLiteral(new position(ctx));
        if (ctx.getText().equals("true")) {
            lit.value = true;
        } else {
            lit.value = false;
        }
        return lit;
    }
    @Override public nullLiteral visitNullLiteral(MxParser.NullLiteralContext ctx) {
        nullLiteral lit = new nullLiteral(new position(ctx));
        return lit;
    }
    @Override public numberLiteral visitNumberLiteral(MxParser.NumberLiteralContext ctx) {
        numberLiteral lit = new numberLiteral(new position(ctx));
        lit.value = Integer.parseInt(ctx.IntegerLiteral().getText());
        return lit;
    }
    @Override public T visitPostfixUpdateExpr(MxParser.PostfixUpdateExprContext ctx) {
    }
    @Override public T visitTernaryexp(MxParser.TernaryexpContext ctx) {
    }
    @Override public T visitBinaryExpr(MxParser.BinaryExprContext ctx) {
    }
    @Override public T visitNewExpr(MxParser.NewExprContext ctx) {
    }
    @Override public T visitPrefixUpdateExpr(MxParser.PrefixUpdateExprContext ctx) {
    }
    @Override public T visitLhsExpr(MxParser.LhsExprContext ctx) {
    }
    @Override public T visitUnaryExpr(MxParser.UnaryExprContext ctx) {
    }
    @Override public T visitAssignExpr(MxParser.AssignExprContext ctx) {
    }
    @Override public NewExprNode visitNewExpression(MxParser.NewExpressionContext ctx) {
        NewExprNode newexp;
        newexp = (NewExprNode)visit(ctx.newTypename());
        return newexp;
    }
    @Override public T visitLiteralString(MxParser.LiteralStringContext ctx) {
    }
    @Override public T visitLiteralThis(MxParser.LiteralThisContext ctx) {
    }
    @Override public T visitLiteralLogic(MxParser.LiteralLogicContext ctx) {
    }
    @Override public T visitLiteralNull(MxParser.LiteralNullContext ctx) {
    }
    @Override public T visitLiteralNumber(MxParser.LiteralNumberContext ctx) {   
    }
    @Override public T visitArrayExpr(MxParser.ArrayExprContext ctx) {
    }
    @Override public T visitMemberVariableAccessExpr(MxParser.MemberVariableAccessExprContext ctx) {
    }
    @Override public T visitIdentifierExpr(MxParser.IdentifierExprContext ctx) {
    }
    @Override public T visitFunCallExpr(MxParser.FunCallExprContext ctx) {
    }
    @Override public T visitLiteralExpr(MxParser.LiteralExprContext ctx) {
    }
    @Override public T visitParenthesesExpr(MxParser.ParenthesesExprContext ctx) {
    }
    @Override public T visitMemberFunctionAccessExpr(MxParser.MemberFunctionAccessExprContext ctx) {
    }
    @Override public T visitVoidType(MxParser.VoidTypeContext ctx) {
    }
    @Override public T visitBoolType(MxParser.BoolTypeContext ctx) {
    }
    @Override public T visitIntType(MxParser.IntTypeContext ctx) {
    }
    @Override public T visitStringType(MxParser.StringTypeContext ctx) {
    }
}
