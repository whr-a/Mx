// Generated from MxParser.g4 by ANTLR 4.13.0
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(MxParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(MxParser.ReturnTypeContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(MxParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(MxParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typenames}.
	 * @param ctx the parse tree
	 */
	void enterTypenames(MxParser.TypenamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typenames}.
	 * @param ctx the parse tree
	 */
	void exitTypenames(MxParser.TypenamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(MxParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MxParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MxParser.ForInitContext ctx);
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
	 * Enter a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MxParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MxParser.ArrayExprContext ctx);
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
	 * Enter a parse tree produced by the {@code MemberExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MxParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MxParser.MemberExprContext ctx);
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
	 * Enter a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesesExpr(MxParser.ParenthesesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesesExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesesExpr(MxParser.ParenthesesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MxParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MxParser.AtomExprContext ctx);
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
	 * Enter a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(MxParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncExpr}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(MxParser.FuncExprContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#newArrayUnit}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayUnit(MxParser.NewArrayUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newArrayUnit}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayUnit(MxParser.NewArrayUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MxParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MxParser.PrimaryContext ctx);
}