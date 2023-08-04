// Generated from java-escape by ANTLR 4.11.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(MxParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclar(MxParser.FunctionDeclarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclar(MxParser.ClassDeclarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GlobalVariableDeclar}
	 * labeled alternative in {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVariableDeclar(MxParser.GlobalVariableDeclarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDeclParamList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclParamList(MxParser.FunctionDeclParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDeclParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclParam(MxParser.FunctionDeclParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionCallArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallArgList(MxParser.FunctionCallArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MxParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassMemberDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclar(MxParser.ClassMemberDeclarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassMethodDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethodDeclar(MxParser.ClassMethodDeclarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstructorDeclar}
	 * labeled alternative in {@link MxParser#classComponents}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclar(MxParser.ConstructorDeclarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(MxParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(MxParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDeclarStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarStmt(MxParser.VarDeclarStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(MxParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BranchStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchStmt(MxParser.BranchStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStmt(MxParser.LoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtrlFlowStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtrlFlowStmt(MxParser.CtrlFlowStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStmt}
	 * labeled alternative in {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(MxParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MxParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(MxParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator(MxParser.InitDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#branchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranchStatement(MxParser.BranchStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(MxParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclForLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclForLoop(MxParser.DeclForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprForLoop}
	 * labeled alternative in {@link MxParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprForLoop(MxParser.ExprForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(MxParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(MxParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link MxParser#controlFlowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MxParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MxParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MxParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(MxParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassType}
	 * labeled alternative in {@link MxParser#typename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(MxParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewClass}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(MxParser.NewClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewClassArray}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClassArray(MxParser.NewClassArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewPrimitiveArray}
	 * labeled alternative in {@link MxParser#newTypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewPrimitiveArray(MxParser.NewPrimitiveArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newArrayExprCount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExprCount(MxParser.NewArrayExprCountContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newArrayEmptyCount}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayEmptyCount(MxParser.NewArrayEmptyCountContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MxParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(MxParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#thisLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisLiteral(MxParser.ThisLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#logicLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicLiteral(MxParser.LogicLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#nullLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(MxParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#numberLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(MxParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixUpdateExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixUpdateExpr(MxParser.PostfixUpdateExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ternaryexp}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryexp(MxParser.TernaryexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MxParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(MxParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrefixUpdateExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixUpdateExpr(MxParser.PrefixUpdateExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LhsExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLhsExpr(MxParser.LhsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(MxParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MxParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralString}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralString(MxParser.LiteralStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralThis}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralThis(MxParser.LiteralThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralLogic}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralLogic(MxParser.LiteralLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralNull}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralNull(MxParser.LiteralNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralNumber}
	 * labeled alternative in {@link MxParser#literalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralNumber(MxParser.LiteralNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberVariableAccessExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberVariableAccessExpr(MxParser.MemberVariableAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(MxParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunCallExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCallExpr(MxParser.FunCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(MxParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesesExpr(MxParser.ParenthesesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberFunctionAccessExpr}
	 * labeled alternative in {@link MxParser#lhsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberFunctionAccessExpr(MxParser.MemberFunctionAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(MxParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(MxParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(MxParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link MxParser#primitiveTypename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(MxParser.StringTypeContext ctx);
}