// Generated from java-escape by ANTLR 4.11.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclar(MxParser.FunctionDeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclar(MxParser.FunctionDeclarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclar(MxParser.ClassDeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclar(MxParser.ClassDeclarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalVariableDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVariableDeclar(MxParser.GlobalVariableDeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalVariableDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVariableDeclar(MxParser.GlobalVariableDeclarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDeclParamList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclParamList(MxParser.FunctionDeclParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDeclParamList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclParamList(MxParser.FunctionDeclParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDeclParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclParam(MxParser.FunctionDeclParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDeclParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclParam(MxParser.FunctionDeclParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionCallArgList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallArgList(MxParser.FunctionCallArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionCallArgList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallArgList(MxParser.FunctionCallArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassMemberDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclar(MxParser.ClassMemberDeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassMemberDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclar(MxParser.ClassMemberDeclarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassMethodDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 */
	void enterClassMethodDeclar(MxParser.ClassMethodDeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassMethodDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 */
	void exitClassMethodDeclar(MxParser.ClassMethodDeclarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstructorDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclar(MxParser.ConstructorDeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstructorDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclar(MxParser.ConstructorDeclarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(MxParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(MxParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(MxParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(MxParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDeclarStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarStmt(MxParser.VarDeclarStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDeclarStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarStmt(MxParser.VarDeclarStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(MxParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(MxParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BranchStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBranchStmt(MxParser.BranchStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BranchStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBranchStmt(MxParser.BranchStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(MxParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(MxParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CtrlFlowStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCtrlFlowStmt(MxParser.CtrlFlowStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CtrlFlowStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCtrlFlowStmt(MxParser.CtrlFlowStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(MxParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(MxParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#branchStatement}.
	 * @param ctx the parse tree
	 */
	void enterBranchStatement(MxParser.BranchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#branchStatement}.
	 * @param ctx the parse tree
	 */
	void exitBranchStatement(MxParser.BranchStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(MxParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(MxParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclForLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclForLoop(MxParser.DeclForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclForLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclForLoop(MxParser.DeclForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprForLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprForLoop(MxParser.ExprForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprForLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprForLoop(MxParser.ExprForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimitiveType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(MxParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimitiveType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(MxParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterClassType(MxParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitClassType(MxParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(MxParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(MxParser.NewClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewClassArray}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void enterNewClassArray(MxParser.NewClassArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewClassArray}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void exitNewClassArray(MxParser.NewClassArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewPrimitiveArray}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void enterNewPrimitiveArray(MxParser.NewPrimitiveArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewPrimitiveArray}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 */
	void exitNewPrimitiveArray(MxParser.NewPrimitiveArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newArrayExprCount}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExprCount(MxParser.NewArrayExprCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newArrayExprCount}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExprCount(MxParser.NewArrayExprCountContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newArrayEmptyCount}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayEmptyCount(MxParser.NewArrayEmptyCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newArrayEmptyCount}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayEmptyCount(MxParser.NewArrayEmptyCountContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(MxParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(MxParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#thisLiteral}.
	 * @param ctx the parse tree
	 */
	void enterThisLiteral(MxParser.ThisLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#thisLiteral}.
	 * @param ctx the parse tree
	 */
	void exitThisLiteral(MxParser.ThisLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicLiteral}.
	 * @param ctx the parse tree
	 */
	void enterLogicLiteral(MxParser.LogicLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicLiteral}.
	 * @param ctx the parse tree
	 */
	void exitLogicLiteral(MxParser.LogicLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(MxParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(MxParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(MxParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#numberLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(MxParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixUpdateExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixUpdateExpr(MxParser.PostfixUpdateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixUpdateExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixUpdateExpr(MxParser.PostfixUpdateExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Ternaryexp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryexp(MxParser.TernaryexpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Ternaryexp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryexp(MxParser.TernaryexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixUpdateExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixUpdateExpr(MxParser.PrefixUpdateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixUpdateExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixUpdateExpr(MxParser.PrefixUpdateExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LhsExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLhsExpr(MxParser.LhsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LhsExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLhsExpr(MxParser.LhsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralString}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralString(MxParser.LiteralStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralString}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralString(MxParser.LiteralStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralThis}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralThis(MxParser.LiteralThisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralThis}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralThis(MxParser.LiteralThisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralLogic}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralLogic(MxParser.LiteralLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralLogic}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralLogic(MxParser.LiteralLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralNull}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralNull(MxParser.LiteralNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralNull}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralNull(MxParser.LiteralNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralNumber}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralNumber(MxParser.LiteralNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralNumber}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralNumber(MxParser.LiteralNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberVariableAccessExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberVariableAccessExpr(MxParser.MemberVariableAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberVariableAccessExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberVariableAccessExpr(MxParser.MemberVariableAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(MxParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(MxParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunCallExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunCallExpr(MxParser.FunCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunCallExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunCallExpr(MxParser.FunCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(MxParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(MxParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpr(MxParser.ParenthesesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpr(MxParser.ParenthesesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberFunctionAccessExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberFunctionAccessExpr(MxParser.MemberFunctionAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberFunctionAccessExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberFunctionAccessExpr(MxParser.MemberFunctionAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(MxParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(MxParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(MxParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(MxParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void enterIntType(MxParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void exitIntType(MxParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void enterStringType(MxParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 */
	void exitStringType(MxParser.StringTypeContext ctx);
}