// Generated from /home/whr/Mx/antlr/MxParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LineComments=1, BlockComments=2, Void=3, Bool=4, Int=5, String=6, New=7, 
		Class=8, Null=9, True=10, False=11, This=12, If=13, Else=14, For=15, While=16, 
		Break=17, Continue=18, Return=19, OpArrow=20, OpIncre=21, OpDecre=22, 
		OpAnd=23, OpOr=24, OpNot=25, OpShr=26, OpShl=27, OpBitAnd=28, OpBitOr=29, 
		OpBitXor=30, OpBitCompl=31, OpAdd=32, OPSub=33, OPMul=34, OpDiv=35, OpMod=36, 
		OpGeq=37, OpLeq=38, OpGt=39, OpLt=40, OpNeq=41, OpEq=42, OpAssign=43, 
		OpMemberAccess=44, LBracket=45, RBracket=46, LParenthese=47, RParenthese=48, 
		LBrace=49, RBrace=50, SemiColon=51, Comma=52, Question=53, Colon=54, Identifier=55, 
		LogicalLiteral=56, IntegerLiteral=57, StringLiteral=58, NullLiteral=59, 
		Whitespace=60, NewLine=61;
	public static final int
		RULE_translationUnit = 0, RULE_declaration = 1, RULE_functionDeclaration = 2, 
		RULE_functionDeclParamList = 3, RULE_functionDeclParam = 4, RULE_functionCallArgList = 5, 
		RULE_classDeclaration = 6, RULE_classComponents = 7, RULE_constructorDeclaration = 8, 
		RULE_statement = 9, RULE_blockStatement = 10, RULE_variableDeclaration = 11, 
		RULE_initDeclarator = 12, RULE_expressionStatement = 13, RULE_branchStatement = 14, 
		RULE_loopStatement = 15, RULE_controlFlowStatement = 16, RULE_continueStatement = 17, 
		RULE_breakStatement = 18, RULE_returnStatement = 19, RULE_emptyStatement = 20, 
		RULE_typename = 21, RULE_newTypename = 22, RULE_newArrayExprCount = 23, 
		RULE_newArrayEmptyCount = 24, RULE_identifier = 25, RULE_stringLiteral = 26, 
		RULE_thisLiteral = 27, RULE_logicLiteral = 28, RULE_nullLiteral = 29, 
		RULE_numberLiteral = 30, RULE_expression = 31, RULE_newExpression = 32, 
		RULE_literalExpression = 33, RULE_lhsExpression = 34, RULE_primitiveTypename = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"translationUnit", "declaration", "functionDeclaration", "functionDeclParamList", 
			"functionDeclParam", "functionCallArgList", "classDeclaration", "classComponents", 
			"constructorDeclaration", "statement", "blockStatement", "variableDeclaration", 
			"initDeclarator", "expressionStatement", "branchStatement", "loopStatement", 
			"controlFlowStatement", "continueStatement", "breakStatement", "returnStatement", 
			"emptyStatement", "typename", "newTypename", "newArrayExprCount", "newArrayEmptyCount", 
			"identifier", "stringLiteral", "thisLiteral", "logicLiteral", "nullLiteral", 
			"numberLiteral", "expression", "newExpression", "literalExpression", 
			"lhsExpression", "primitiveTypename"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'void'", "'bool'", "'int'", "'string'", "'new'", "'class'", 
			"'null'", "'true'", "'false'", "'this'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'->'", "'++'", "'--'", "'&&'", 
			"'||'", "'!'", "'>>'", "'<<'", "'&'", "'|'", "'^'", "'~'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'>='", "'<='", "'>'", "'<'", "'!='", "'=='", "'='", 
			"'.'", "'['", "']'", "'('", "')'", "'{'", "'}'", "';'", "','", "'?'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LineComments", "BlockComments", "Void", "Bool", "Int", "String", 
			"New", "Class", "Null", "True", "False", "This", "If", "Else", "For", 
			"While", "Break", "Continue", "Return", "OpArrow", "OpIncre", "OpDecre", 
			"OpAnd", "OpOr", "OpNot", "OpShr", "OpShl", "OpBitAnd", "OpBitOr", "OpBitXor", 
			"OpBitCompl", "OpAdd", "OPSub", "OPMul", "OpDiv", "OpMod", "OpGeq", "OpLeq", 
			"OpGt", "OpLt", "OpNeq", "OpEq", "OpAssign", "OpMemberAccess", "LBracket", 
			"RBracket", "LParenthese", "RParenthese", "LBrace", "RBrace", "SemiColon", 
			"Comma", "Question", "Colon", "Identifier", "LogicalLiteral", "IntegerLiteral", 
			"StringLiteral", "NullLiteral", "Whitespace", "NewLine"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MxParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TranslationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(72);
				declaration();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GlobalVariableDeclarContext extends DeclarationContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public GlobalVariableDeclarContext(DeclarationContext ctx) { copyFrom(ctx); }
	}
	public static class ClassDeclarContext extends DeclarationContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public ClassDeclarContext(DeclarationContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionDeclarContext extends DeclarationContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public FunctionDeclarContext(DeclarationContext ctx) { copyFrom(ctx); }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionDeclarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				functionDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassDeclarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				classDeclaration();
				}
				break;
			case 3:
				_localctx = new GlobalVariableDeclarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				variableDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public BlockStatementContext body;
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FunctionDeclParamListContext functionDeclParamList() {
			return getRuleContext(FunctionDeclParamListContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			typename(0);
			setState(86);
			identifier();
			setState(87);
			match(LParenthese);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(88);
				functionDeclParamList();
				}
			}

			setState(91);
			match(RParenthese);
			setState(92);
			((FunctionDeclarationContext)_localctx).body = blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclParamListContext extends ParserRuleContext {
		public List<FunctionDeclParamContext> functionDeclParam() {
			return getRuleContexts(FunctionDeclParamContext.class);
		}
		public FunctionDeclParamContext functionDeclParam(int i) {
			return getRuleContext(FunctionDeclParamContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public FunctionDeclParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclParamList; }
	}

	public final FunctionDeclParamListContext functionDeclParamList() throws RecognitionException {
		FunctionDeclParamListContext _localctx = new FunctionDeclParamListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDeclParamList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					functionDeclParam();
					setState(95);
					match(Comma);
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(102);
			functionDeclParam();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclParamContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionDeclParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclParam; }
	}

	public final FunctionDeclParamContext functionDeclParam() throws RecognitionException {
		FunctionDeclParamContext _localctx = new FunctionDeclParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDeclParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			typename(0);
			setState(105);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public FunctionCallArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallArgList; }
	}

	public final FunctionCallArgListContext functionCallArgList() throws RecognitionException {
		FunctionCallArgListContext _localctx = new FunctionCallArgListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionCallArgList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(107);
					expression(0);
					setState(108);
					match(Comma);
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(115);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public List<ClassComponentsContext> classComponents() {
			return getRuleContexts(ClassComponentsContext.class);
		}
		public ClassComponentsContext classComponents(int i) {
			return getRuleContext(ClassComponentsContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(Class);
			setState(118);
			identifier();
			setState(119);
			match(LBrace);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				{
				setState(120);
				classComponents();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(RBrace);
			setState(127);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassComponentsContext extends ParserRuleContext {
		public ClassComponentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classComponents; }
	 
		public ClassComponentsContext() { }
		public void copyFrom(ClassComponentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassMethodDeclarContext extends ClassComponentsContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassMethodDeclarContext(ClassComponentsContext ctx) { copyFrom(ctx); }
	}
	public static class ConstructorDeclarContext extends ClassComponentsContext {
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public ConstructorDeclarContext(ClassComponentsContext ctx) { copyFrom(ctx); }
	}
	public static class ClassMemberDeclarContext extends ClassComponentsContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ClassMemberDeclarContext(ClassComponentsContext ctx) { copyFrom(ctx); }
	}

	public final ClassComponentsContext classComponents() throws RecognitionException {
		ClassComponentsContext _localctx = new ClassComponentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classComponents);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ClassMemberDeclarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				variableDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassMethodDeclarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				functionDeclaration();
				}
				break;
			case 3:
				_localctx = new ConstructorDeclarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				constructorDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public BlockStatementContext body;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			identifier();
			setState(135);
			match(LParenthese);
			setState(136);
			match(RParenthese);
			setState(137);
			((ConstructorDeclarationContext)_localctx).body = blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BranchStmtContext extends StatementContext {
		public BranchStatementContext branchStatement() {
			return getRuleContext(BranchStatementContext.class,0);
		}
		public BranchStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class LoopStmtContext extends StatementContext {
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public LoopStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CtrlFlowStmtContext extends StatementContext {
		public ControlFlowStatementContext controlFlowStatement() {
			return getRuleContext(ControlFlowStatementContext.class,0);
		}
		public CtrlFlowStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class BlockStmtContext extends StatementContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public BlockStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class EmptyStmtContext extends StatementContext {
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public EmptyStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class VarDeclarStmtContext extends StatementContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public VarDeclarStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ExpressionStmtContext extends StatementContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ExpressionStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				blockStatement();
				}
				break;
			case 2:
				_localctx = new VarDeclarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				variableDeclaration();
				}
				break;
			case 3:
				_localctx = new ExpressionStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				expressionStatement();
				}
				break;
			case 4:
				_localctx = new BranchStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				branchStatement();
				}
				break;
			case 5:
				_localctx = new LoopStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				loopStatement();
				}
				break;
			case 6:
				_localctx = new CtrlFlowStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(144);
				controlFlowStatement();
				}
				break;
			case 7:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(145);
				emptyStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(LBrace);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << LBrace) | (1L << SemiColon) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
				{
				{
				setState(149);
				statement();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variableDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			typename(0);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(158);
					initDeclarator();
					setState(159);
					match(Comma);
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(166);
			initDeclarator();
			setState(167);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorContext extends ParserRuleContext {
		public ExpressionContext initializer;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpAssign() { return getToken(MxParser.OpAssign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			identifier();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpAssign) {
				{
				setState(170);
				match(OpAssign);
				setState(171);
				((InitDeclaratorContext)_localctx).initializer = expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			expression(0);
			setState(175);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BranchStatementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public StatementContext ifStatement;
		public StatementContext elseStatement;
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public BranchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchStatement; }
	}

	public final BranchStatementContext branchStatement() throws RecognitionException {
		BranchStatementContext _localctx = new BranchStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_branchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(If);
			setState(178);
			match(LParenthese);
			setState(179);
			((BranchStatementContext)_localctx).condition = expression(0);
			setState(180);
			match(RParenthese);
			setState(181);
			((BranchStatementContext)_localctx).ifStatement = statement();
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(182);
				match(Else);
				setState(183);
				((BranchStatementContext)_localctx).elseStatement = statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
	 
		public LoopStatementContext() { }
		public void copyFrom(LoopStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclForLoopContext extends LoopStatementContext {
		public VariableDeclarationContext init;
		public ExpressionContext condition;
		public ExpressionContext step;
		public StatementContext body;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DeclForLoopContext(LoopStatementContext ctx) { copyFrom(ctx); }
	}
	public static class ExprForLoopContext extends LoopStatementContext {
		public ExpressionContext init;
		public ExpressionContext condition;
		public ExpressionContext step;
		public StatementContext body;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public List<TerminalNode> SemiColon() { return getTokens(MxParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(MxParser.SemiColon, i);
		}
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprForLoopContext(LoopStatementContext ctx) { copyFrom(ctx); }
	}
	public static class WhileLoopContext extends LoopStatementContext {
		public ExpressionContext condition;
		public StatementContext body;
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileLoopContext(LoopStatementContext ctx) { copyFrom(ctx); }
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_loopStatement);
		int _la;
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(While);
				setState(187);
				match(LParenthese);
				setState(188);
				((WhileLoopContext)_localctx).condition = expression(0);
				setState(189);
				match(RParenthese);
				setState(190);
				((WhileLoopContext)_localctx).body = statement();
				}
				break;
			case 2:
				_localctx = new DeclForLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(For);
				setState(193);
				match(LParenthese);
				setState(194);
				((DeclForLoopContext)_localctx).init = variableDeclaration();
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(195);
					((DeclForLoopContext)_localctx).condition = expression(0);
					}
				}

				setState(198);
				match(SemiColon);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(199);
					((DeclForLoopContext)_localctx).step = expression(0);
					}
				}

				setState(202);
				match(RParenthese);
				setState(203);
				((DeclForLoopContext)_localctx).body = statement();
				}
				break;
			case 3:
				_localctx = new ExprForLoopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				match(For);
				setState(206);
				match(LParenthese);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(207);
					((ExprForLoopContext)_localctx).init = expression(0);
					}
				}

				setState(210);
				match(SemiColon);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(211);
					((ExprForLoopContext)_localctx).condition = expression(0);
					}
				}

				setState(214);
				match(SemiColon);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(215);
					((ExprForLoopContext)_localctx).step = expression(0);
					}
				}

				setState(218);
				match(RParenthese);
				setState(219);
				((ExprForLoopContext)_localctx).body = statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlFlowStatementContext extends ParserRuleContext {
		public ControlFlowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlFlowStatement; }
	 
		public ControlFlowStatementContext() { }
		public void copyFrom(ControlFlowStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ContinueStmtContext extends ControlFlowStatementContext {
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ContinueStmtContext(ControlFlowStatementContext ctx) { copyFrom(ctx); }
	}
	public static class BreakStmtContext extends ControlFlowStatementContext {
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public BreakStmtContext(ControlFlowStatementContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnStmtContext extends ControlFlowStatementContext {
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ReturnStmtContext(ControlFlowStatementContext ctx) { copyFrom(ctx); }
	}

	public final ControlFlowStatementContext controlFlowStatement() throws RecognitionException {
		ControlFlowStatementContext _localctx = new ControlFlowStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_controlFlowStatement);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				continueStatement();
				}
				break;
			case Break:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				breakStatement();
				}
				break;
			case Return:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				returnStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(Continue);
			setState(228);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(Break);
			setState(231);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(Return);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
				{
				setState(234);
				expression(0);
				}
			}

			setState(237);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenameContext extends ParserRuleContext {
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
	 
		public TypenameContext() { }
		public void copyFrom(TypenameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends TypenameContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public ArrayTypeContext(TypenameContext ctx) { copyFrom(ctx); }
	}
	public static class PrimitiveTypeContext extends TypenameContext {
		public PrimitiveTypenameContext primitiveTypename() {
			return getRuleContext(PrimitiveTypenameContext.class,0);
		}
		public PrimitiveTypeContext(TypenameContext ctx) { copyFrom(ctx); }
	}
	public static class ClassTypeContext extends TypenameContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassTypeContext(TypenameContext ctx) { copyFrom(ctx); }
	}

	public final TypenameContext typename() throws RecognitionException {
		return typename(0);
	}

	private TypenameContext typename(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypenameContext _localctx = new TypenameContext(_ctx, _parentState);
		TypenameContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_typename, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
			case Bool:
			case Int:
			case String:
				{
				_localctx = new PrimitiveTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(242);
				primitiveTypename();
				}
				break;
			case Identifier:
				{
				_localctx = new ClassTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new TypenameContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_typename);
					setState(246);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(247);
					match(LBracket);
					setState(248);
					match(RBracket);
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NewTypenameContext extends ParserRuleContext {
		public NewTypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newTypename; }
	 
		public NewTypenameContext() { }
		public void copyFrom(NewTypenameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewPrimitiveArrayContext extends NewTypenameContext {
		public PrimitiveTypenameContext primitiveTypename() {
			return getRuleContext(PrimitiveTypenameContext.class,0);
		}
		public List<NewArrayExprCountContext> newArrayExprCount() {
			return getRuleContexts(NewArrayExprCountContext.class);
		}
		public NewArrayExprCountContext newArrayExprCount(int i) {
			return getRuleContext(NewArrayExprCountContext.class,i);
		}
		public List<NewArrayEmptyCountContext> newArrayEmptyCount() {
			return getRuleContexts(NewArrayEmptyCountContext.class);
		}
		public NewArrayEmptyCountContext newArrayEmptyCount(int i) {
			return getRuleContext(NewArrayEmptyCountContext.class,i);
		}
		public NewPrimitiveArrayContext(NewTypenameContext ctx) { copyFrom(ctx); }
	}
	public static class NewClassContext extends NewTypenameContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NewClassContext(NewTypenameContext ctx) { copyFrom(ctx); }
	}
	public static class NewClassArrayContext extends NewTypenameContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<NewArrayExprCountContext> newArrayExprCount() {
			return getRuleContexts(NewArrayExprCountContext.class);
		}
		public NewArrayExprCountContext newArrayExprCount(int i) {
			return getRuleContext(NewArrayExprCountContext.class,i);
		}
		public List<NewArrayEmptyCountContext> newArrayEmptyCount() {
			return getRuleContexts(NewArrayEmptyCountContext.class);
		}
		public NewArrayEmptyCountContext newArrayEmptyCount(int i) {
			return getRuleContext(NewArrayEmptyCountContext.class,i);
		}
		public NewClassArrayContext(NewTypenameContext ctx) { copyFrom(ctx); }
	}

	public final NewTypenameContext newTypename() throws RecognitionException {
		NewTypenameContext _localctx = new NewTypenameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newTypename);
		try {
			int _alt;
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				identifier();
				}
				break;
			case 2:
				_localctx = new NewClassArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				identifier();
				setState(257); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(256);
						newArrayExprCount();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(259); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(261);
						newArrayEmptyCount();
						}
						} 
					}
					setState(266);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new NewPrimitiveArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
				primitiveTypename();
				setState(269); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(268);
						newArrayExprCount();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(271); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(273);
						newArrayEmptyCount();
						}
						} 
					}
					setState(278);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewArrayExprCountContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public NewArrayExprCountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newArrayExprCount; }
	}

	public final NewArrayExprCountContext newArrayExprCount() throws RecognitionException {
		NewArrayExprCountContext _localctx = new NewArrayExprCountContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_newArrayExprCount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(LBracket);
			setState(282);
			expression(0);
			setState(283);
			match(RBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewArrayEmptyCountContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public NewArrayEmptyCountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newArrayEmptyCount; }
	}

	public final NewArrayEmptyCountContext newArrayEmptyCount() throws RecognitionException {
		NewArrayEmptyCountContext _localctx = new NewArrayEmptyCountContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_newArrayEmptyCount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(LBracket);
			setState(286);
			match(RBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(MxParser.StringLiteral, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(StringLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThisLiteralContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public ThisLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thisLiteral; }
	}

	public final ThisLiteralContext thisLiteral() throws RecognitionException {
		ThisLiteralContext _localctx = new ThisLiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_thisLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(This);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicLiteralContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public LogicLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicLiteral; }
	}

	public final LogicLiteralContext logicLiteral() throws RecognitionException {
		LogicLiteralContext _localctx = new LogicLiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_logicLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !(_la==True || _la==False) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullLiteralContext extends ParserRuleContext {
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public NullLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullLiteral; }
	}

	public final NullLiteralContext nullLiteral() throws RecognitionException {
		NullLiteralContext _localctx = new NullLiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_nullLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(Null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(MxParser.IntegerLiteral, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_numberLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(IntegerLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixUpdateExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OpIncre() { return getToken(MxParser.OpIncre, 0); }
		public TerminalNode OpDecre() { return getToken(MxParser.OpDecre, 0); }
		public PostfixUpdateExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TernaryexpContext extends ExpressionContext {
		public ExpressionContext a;
		public Token op;
		public ExpressionContext b;
		public ExpressionContext c;
		public TerminalNode Colon() { return getToken(MxParser.Colon, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Question() { return getToken(MxParser.Question, 0); }
		public TernaryexpContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryExprContext extends ExpressionContext {
		public ExpressionContext l;
		public Token op;
		public ExpressionContext r;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPMul() { return getToken(MxParser.OPMul, 0); }
		public TerminalNode OpDiv() { return getToken(MxParser.OpDiv, 0); }
		public TerminalNode OpMod() { return getToken(MxParser.OpMod, 0); }
		public TerminalNode OpAdd() { return getToken(MxParser.OpAdd, 0); }
		public TerminalNode OPSub() { return getToken(MxParser.OPSub, 0); }
		public TerminalNode OpShl() { return getToken(MxParser.OpShl, 0); }
		public TerminalNode OpShr() { return getToken(MxParser.OpShr, 0); }
		public TerminalNode OpLt() { return getToken(MxParser.OpLt, 0); }
		public TerminalNode OpGt() { return getToken(MxParser.OpGt, 0); }
		public TerminalNode OpLeq() { return getToken(MxParser.OpLeq, 0); }
		public TerminalNode OpGeq() { return getToken(MxParser.OpGeq, 0); }
		public TerminalNode OpEq() { return getToken(MxParser.OpEq, 0); }
		public TerminalNode OpNeq() { return getToken(MxParser.OpNeq, 0); }
		public TerminalNode OpBitAnd() { return getToken(MxParser.OpBitAnd, 0); }
		public TerminalNode OpBitOr() { return getToken(MxParser.OpBitOr, 0); }
		public TerminalNode OpBitXor() { return getToken(MxParser.OpBitXor, 0); }
		public TerminalNode OpAnd() { return getToken(MxParser.OpAnd, 0); }
		public TerminalNode OpOr() { return getToken(MxParser.OpOr, 0); }
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class NewExprContext extends ExpressionContext {
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class PrefixUpdateExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OpIncre() { return getToken(MxParser.OpIncre, 0); }
		public TerminalNode OpDecre() { return getToken(MxParser.OpDecre, 0); }
		public PrefixUpdateExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LhsExprContext extends ExpressionContext {
		public LhsExpressionContext lhsExpression() {
			return getRuleContext(LhsExpressionContext.class,0);
		}
		public LhsExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext r;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OpNot() { return getToken(MxParser.OpNot, 0); }
		public TerminalNode OPSub() { return getToken(MxParser.OPSub, 0); }
		public TerminalNode OpBitCompl() { return getToken(MxParser.OpBitCompl, 0); }
		public TerminalNode OpAdd() { return getToken(MxParser.OpAdd, 0); }
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class AssignExprContext extends ExpressionContext {
		public ExpressionContext l;
		public ExpressionContext r;
		public TerminalNode OpAssign() { return getToken(MxParser.OpAssign, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Null:
			case True:
			case False:
			case This:
			case LParenthese:
			case Identifier:
			case IntegerLiteral:
			case StringLiteral:
				{
				_localctx = new LhsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(301);
				lhsExpression(0);
				}
				break;
			case New:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				newExpression();
				}
				break;
			case OpIncre:
			case OpDecre:
				{
				_localctx = new PrefixUpdateExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OpIncre:
					{
					setState(303);
					((PrefixUpdateExprContext)_localctx).op = match(OpIncre);
					}
					break;
				case OpDecre:
					{
					setState(304);
					((PrefixUpdateExprContext)_localctx).op = match(OpDecre);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(307);
				expression(13);
				}
				break;
			case OpNot:
			case OpBitCompl:
			case OpAdd:
			case OPSub:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(308);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub))) != 0)) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(309);
				((UnaryExprContext)_localctx).r = expression(12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(350);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(313);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPMul) | (1L << OpDiv) | (1L << OpMod))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(314);
						((BinaryExprContext)_localctx).r = expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(316);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OpAdd || _la==OPSub) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(317);
						((BinaryExprContext)_localctx).r = expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(319);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OpShr || _la==OpShl) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(320);
						((BinaryExprContext)_localctx).r = expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(322);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OpGeq) | (1L << OpLeq) | (1L << OpGt) | (1L << OpLt) | (1L << OpNeq) | (1L << OpEq))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(323);
						((BinaryExprContext)_localctx).r = expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(325);
						((BinaryExprContext)_localctx).op = match(OpBitAnd);
						setState(326);
						((BinaryExprContext)_localctx).r = expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(328);
						((BinaryExprContext)_localctx).op = match(OpBitOr);
						setState(329);
						((BinaryExprContext)_localctx).r = expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(331);
						((BinaryExprContext)_localctx).op = match(OpBitXor);
						setState(332);
						((BinaryExprContext)_localctx).r = expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(334);
						((BinaryExprContext)_localctx).op = match(OpAnd);
						setState(335);
						((BinaryExprContext)_localctx).r = expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(337);
						((BinaryExprContext)_localctx).op = match(OpOr);
						setState(338);
						((BinaryExprContext)_localctx).r = expression(4);
						}
						break;
					case 10:
						{
						_localctx = new TernaryexpContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryexpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(339);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(340);
						((TernaryexpContext)_localctx).op = match(Question);
						setState(341);
						((TernaryexpContext)_localctx).b = expression(0);
						setState(342);
						match(Colon);
						setState(343);
						((TernaryexpContext)_localctx).c = expression(2);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						((AssignExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(345);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(346);
						match(OpAssign);
						setState(347);
						((AssignExprContext)_localctx).r = expression(1);
						}
						break;
					case 12:
						{
						_localctx = new PostfixUpdateExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(348);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(349);
						((PostfixUpdateExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OpIncre || _la==OpDecre) ) {
							((PostfixUpdateExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NewExpressionContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public NewTypenameContext newTypename() {
			return getRuleContext(NewTypenameContext.class,0);
		}
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_newExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(New);
			setState(356);
			newTypename();
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(357);
				match(LParenthese);
				setState(358);
				match(RParenthese);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralExpressionContext extends ParserRuleContext {
		public LiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpression; }
	 
		public LiteralExpressionContext() { }
		public void copyFrom(LiteralExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LiteralStringContext extends LiteralExpressionContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public LiteralStringContext(LiteralExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralNullContext extends LiteralExpressionContext {
		public NullLiteralContext nullLiteral() {
			return getRuleContext(NullLiteralContext.class,0);
		}
		public LiteralNullContext(LiteralExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralLogicContext extends LiteralExpressionContext {
		public LogicLiteralContext logicLiteral() {
			return getRuleContext(LogicLiteralContext.class,0);
		}
		public LiteralLogicContext(LiteralExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralThisContext extends LiteralExpressionContext {
		public ThisLiteralContext thisLiteral() {
			return getRuleContext(ThisLiteralContext.class,0);
		}
		public LiteralThisContext(LiteralExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralNumberContext extends LiteralExpressionContext {
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public LiteralNumberContext(LiteralExpressionContext ctx) { copyFrom(ctx); }
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literalExpression);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringLiteral:
				_localctx = new LiteralStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				stringLiteral();
				}
				break;
			case This:
				_localctx = new LiteralThisContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				thisLiteral();
				}
				break;
			case True:
			case False:
				_localctx = new LiteralLogicContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				logicLiteral();
				}
				break;
			case Null:
				_localctx = new LiteralNullContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(364);
				nullLiteral();
				}
				break;
			case IntegerLiteral:
				_localctx = new LiteralNumberContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(365);
				numberLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LhsExpressionContext extends ParserRuleContext {
		public LhsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhsExpression; }
	 
		public LhsExpressionContext() { }
		public void copyFrom(LhsExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayExprContext extends LhsExpressionContext {
		public LhsExpressionContext lhsExpression() {
			return getRuleContext(LhsExpressionContext.class,0);
		}
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public ArrayExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MemberVariableAccessExprContext extends LhsExpressionContext {
		public IdentifierContext variable;
		public LhsExpressionContext lhsExpression() {
			return getRuleContext(LhsExpressionContext.class,0);
		}
		public TerminalNode OpMemberAccess() { return getToken(MxParser.OpMemberAccess, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MemberVariableAccessExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class IdentifierExprContext extends LhsExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class FunCallExprContext extends LhsExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public FunctionCallArgListContext functionCallArgList() {
			return getRuleContext(FunctionCallArgListContext.class,0);
		}
		public FunCallExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class LiteralExprContext extends LhsExpressionContext {
		public LiteralExpressionContext literalExpression() {
			return getRuleContext(LiteralExpressionContext.class,0);
		}
		public LiteralExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ParenthesesExprContext extends LhsExpressionContext {
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public ParenthesesExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MemberFunctionAccessExprContext extends LhsExpressionContext {
		public IdentifierContext method;
		public LhsExpressionContext lhsExpression() {
			return getRuleContext(LhsExpressionContext.class,0);
		}
		public TerminalNode OpMemberAccess() { return getToken(MxParser.OpMemberAccess, 0); }
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionCallArgListContext functionCallArgList() {
			return getRuleContext(FunctionCallArgListContext.class,0);
		}
		public MemberFunctionAccessExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
	}

	public final LhsExpressionContext lhsExpression() throws RecognitionException {
		return lhsExpression(0);
	}

	private LhsExpressionContext lhsExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LhsExpressionContext _localctx = new LhsExpressionContext(_ctx, _parentState);
		LhsExpressionContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_lhsExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(369);
				identifier();
				}
				break;
			case 2:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370);
				literalExpression();
				}
				break;
			case 3:
				{
				_localctx = new ParenthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				match(LParenthese);
				setState(372);
				expression(0);
				setState(373);
				match(RParenthese);
				}
				break;
			case 4:
				{
				_localctx = new FunCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(375);
				identifier();
				setState(376);
				match(LParenthese);
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(377);
					functionCallArgList();
					}
				}

				setState(380);
				match(RParenthese);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(401);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new MemberVariableAccessExprContext(new LhsExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lhsExpression);
						setState(384);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(385);
						match(OpMemberAccess);
						setState(386);
						((MemberVariableAccessExprContext)_localctx).variable = identifier();
						}
						break;
					case 2:
						{
						_localctx = new MemberFunctionAccessExprContext(new LhsExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lhsExpression);
						setState(387);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(388);
						match(OpMemberAccess);
						setState(389);
						((MemberFunctionAccessExprContext)_localctx).method = identifier();
						setState(390);
						match(LParenthese);
						setState(392);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
							{
							setState(391);
							functionCallArgList();
							}
						}

						setState(394);
						match(RParenthese);
						}
						break;
					case 3:
						{
						_localctx = new ArrayExprContext(new LhsExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lhsExpression);
						setState(396);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(397);
						match(LBracket);
						setState(398);
						expression(0);
						setState(399);
						match(RBracket);
						}
						break;
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimitiveTypenameContext extends ParserRuleContext {
		public PrimitiveTypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveTypename; }
	 
		public PrimitiveTypenameContext() { }
		public void copyFrom(PrimitiveTypenameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VoidTypeContext extends PrimitiveTypenameContext {
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public VoidTypeContext(PrimitiveTypenameContext ctx) { copyFrom(ctx); }
	}
	public static class BoolTypeContext extends PrimitiveTypenameContext {
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public BoolTypeContext(PrimitiveTypenameContext ctx) { copyFrom(ctx); }
	}
	public static class StringTypeContext extends PrimitiveTypenameContext {
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public StringTypeContext(PrimitiveTypenameContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends PrimitiveTypenameContext {
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public IntTypeContext(PrimitiveTypenameContext ctx) { copyFrom(ctx); }
	}

	public final PrimitiveTypenameContext primitiveTypename() throws RecognitionException {
		PrimitiveTypenameContext _localctx = new PrimitiveTypenameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_primitiveTypename);
		try {
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(406);
				match(Void);
				}
				break;
			case Bool:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				match(Bool);
				}
				break;
			case Int:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(408);
				match(Int);
				}
				break;
			case String:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(409);
				match(String);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return typename_sempred((TypenameContext)_localctx, predIndex);
		case 31:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 34:
			return lhsExpression_sempred((LhsExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typename_sempred(TypenameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 14);
		}
		return true;
	}
	private boolean lhsExpression_sempred(LhsExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 4);
		case 14:
			return precpred(_ctx, 3);
		case 15:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u019f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\5\3V\n\3\3\4\3\4\3\4\3\4\5\4\\\n\4\3\4\3\4\3\4\3\5\3\5\3\5\7"+
		"\5d\n\5\f\5\16\5g\13\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7q\n\7\f\7\16"+
		"\7t\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b|\n\b\f\b\16\b\177\13\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\5\t\u0087\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u0095\n\13\3\f\3\f\7\f\u0099\n\f\f\f\16\f\u009c\13"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00a4\n\r\f\r\16\r\u00a7\13\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u00bb\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00c7\n\21\3\21\3\21\5\21\u00cb\n\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\5\21\u00d3\n\21\3\21\3\21\5\21\u00d7\n\21\3\21\3\21\5\21"+
		"\u00db\n\21\3\21\3\21\5\21\u00df\n\21\3\22\3\22\3\22\5\22\u00e4\n\22\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\5\25\u00ee\n\25\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\5\27\u00f7\n\27\3\27\3\27\3\27\7\27\u00fc\n\27\f"+
		"\27\16\27\u00ff\13\27\3\30\3\30\3\30\6\30\u0104\n\30\r\30\16\30\u0105"+
		"\3\30\7\30\u0109\n\30\f\30\16\30\u010c\13\30\3\30\3\30\6\30\u0110\n\30"+
		"\r\30\16\30\u0111\3\30\7\30\u0115\n\30\f\30\16\30\u0118\13\30\5\30\u011a"+
		"\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\5!\u0134\n!\3!\3!\3!\5!\u0139"+
		"\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0161\n!\f!\16!\u0164"+
		"\13!\3\"\3\"\3\"\3\"\5\"\u016a\n\"\3#\3#\3#\3#\3#\5#\u0171\n#\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\5$\u017d\n$\3$\3$\5$\u0181\n$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\5$\u018b\n$\3$\3$\3$\3$\3$\3$\3$\7$\u0194\n$\f$\16$\u0197\13$"+
		"\3%\3%\3%\3%\5%\u019d\n%\3%\2\5,@F&\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\t\3\2\f\r\4\2\33\33!#\3\2$&\3\2\""+
		"#\3\2\34\35\3\2\',\3\2\27\30\2\u01bf\2M\3\2\2\2\4U\3\2\2\2\6W\3\2\2\2"+
		"\be\3\2\2\2\nj\3\2\2\2\fr\3\2\2\2\16w\3\2\2\2\20\u0086\3\2\2\2\22\u0088"+
		"\3\2\2\2\24\u0094\3\2\2\2\26\u0096\3\2\2\2\30\u009f\3\2\2\2\32\u00ab\3"+
		"\2\2\2\34\u00b0\3\2\2\2\36\u00b3\3\2\2\2 \u00de\3\2\2\2\"\u00e3\3\2\2"+
		"\2$\u00e5\3\2\2\2&\u00e8\3\2\2\2(\u00eb\3\2\2\2*\u00f1\3\2\2\2,\u00f6"+
		"\3\2\2\2.\u0119\3\2\2\2\60\u011b\3\2\2\2\62\u011f\3\2\2\2\64\u0122\3\2"+
		"\2\2\66\u0124\3\2\2\28\u0126\3\2\2\2:\u0128\3\2\2\2<\u012a\3\2\2\2>\u012c"+
		"\3\2\2\2@\u0138\3\2\2\2B\u0165\3\2\2\2D\u0170\3\2\2\2F\u0180\3\2\2\2H"+
		"\u019c\3\2\2\2JL\5\4\3\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2"+
		"\2\2OM\3\2\2\2PQ\7\2\2\3Q\3\3\2\2\2RV\5\6\4\2SV\5\16\b\2TV\5\30\r\2UR"+
		"\3\2\2\2US\3\2\2\2UT\3\2\2\2V\5\3\2\2\2WX\5,\27\2XY\5\64\33\2Y[\7\61\2"+
		"\2Z\\\5\b\5\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\62\2\2^_\5\26\f\2_\7"+
		"\3\2\2\2`a\5\n\6\2ab\7\66\2\2bd\3\2\2\2c`\3\2\2\2dg\3\2\2\2ec\3\2\2\2"+
		"ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\5\n\6\2i\t\3\2\2\2jk\5,\27\2kl\5\64\33"+
		"\2l\13\3\2\2\2mn\5@!\2no\7\66\2\2oq\3\2\2\2pm\3\2\2\2qt\3\2\2\2rp\3\2"+
		"\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\5@!\2v\r\3\2\2\2wx\7\n\2\2xy\5\64"+
		"\33\2y}\7\63\2\2z|\5\20\t\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2"+
		"~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\64\2\2\u0081\u0082\7\65\2\2"+
		"\u0082\17\3\2\2\2\u0083\u0087\5\30\r\2\u0084\u0087\5\6\4\2\u0085\u0087"+
		"\5\22\n\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2"+
		"\u0087\21\3\2\2\2\u0088\u0089\5\64\33\2\u0089\u008a\7\61\2\2\u008a\u008b"+
		"\7\62\2\2\u008b\u008c\5\26\f\2\u008c\23\3\2\2\2\u008d\u0095\5\26\f\2\u008e"+
		"\u0095\5\30\r\2\u008f\u0095\5\34\17\2\u0090\u0095\5\36\20\2\u0091\u0095"+
		"\5 \21\2\u0092\u0095\5\"\22\2\u0093\u0095\5*\26\2\u0094\u008d\3\2\2\2"+
		"\u0094\u008e\3\2\2\2\u0094\u008f\3\2\2\2\u0094\u0090\3\2\2\2\u0094\u0091"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\25\3\2\2\2\u0096"+
		"\u009a\7\63\2\2\u0097\u0099\5\24\13\2\u0098\u0097\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\7\64\2\2\u009e\27\3\2\2\2\u009f\u00a5\5,\27"+
		"\2\u00a0\u00a1\5\32\16\2\u00a1\u00a2\7\66\2\2\u00a2\u00a4\3\2\2\2\u00a3"+
		"\u00a0\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\5\32\16\2\u00a9"+
		"\u00aa\7\65\2\2\u00aa\31\3\2\2\2\u00ab\u00ae\5\64\33\2\u00ac\u00ad\7-"+
		"\2\2\u00ad\u00af\5@!\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\33"+
		"\3\2\2\2\u00b0\u00b1\5@!\2\u00b1\u00b2\7\65\2\2\u00b2\35\3\2\2\2\u00b3"+
		"\u00b4\7\17\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b6\5@!\2\u00b6\u00b7\7\62"+
		"\2\2\u00b7\u00ba\5\24\13\2\u00b8\u00b9\7\20\2\2\u00b9\u00bb\5\24\13\2"+
		"\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\37\3\2\2\2\u00bc\u00bd"+
		"\7\22\2\2\u00bd\u00be\7\61\2\2\u00be\u00bf\5@!\2\u00bf\u00c0\7\62\2\2"+
		"\u00c0\u00c1\5\24\13\2\u00c1\u00df\3\2\2\2\u00c2\u00c3\7\21\2\2\u00c3"+
		"\u00c4\7\61\2\2\u00c4\u00c6\5\30\r\2\u00c5\u00c7\5@!\2\u00c6\u00c5\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\7\65\2\2\u00c9"+
		"\u00cb\5@!\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2"+
		"\2\u00cc\u00cd\7\62\2\2\u00cd\u00ce\5\24\13\2\u00ce\u00df\3\2\2\2\u00cf"+
		"\u00d0\7\21\2\2\u00d0\u00d2\7\61\2\2\u00d1\u00d3\5@!\2\u00d2\u00d1\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\7\65\2\2\u00d5"+
		"\u00d7\5@!\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2"+
		"\2\u00d8\u00da\7\65\2\2\u00d9\u00db\5@!\2\u00da\u00d9\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\62\2\2\u00dd\u00df\5\24\13"+
		"\2\u00de\u00bc\3\2\2\2\u00de\u00c2\3\2\2\2\u00de\u00cf\3\2\2\2\u00df!"+
		"\3\2\2\2\u00e0\u00e4\5$\23\2\u00e1\u00e4\5&\24\2\u00e2\u00e4\5(\25\2\u00e3"+
		"\u00e0\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4#\3\2\2\2"+
		"\u00e5\u00e6\7\24\2\2\u00e6\u00e7\7\65\2\2\u00e7%\3\2\2\2\u00e8\u00e9"+
		"\7\23\2\2\u00e9\u00ea\7\65\2\2\u00ea\'\3\2\2\2\u00eb\u00ed\7\25\2\2\u00ec"+
		"\u00ee\5@!\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2"+
		"\2\u00ef\u00f0\7\65\2\2\u00f0)\3\2\2\2\u00f1\u00f2\7\65\2\2\u00f2+\3\2"+
		"\2\2\u00f3\u00f4\b\27\1\2\u00f4\u00f7\5H%\2\u00f5\u00f7\5\64\33\2\u00f6"+
		"\u00f3\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00fd\3\2\2\2\u00f8\u00f9\f\3"+
		"\2\2\u00f9\u00fa\7/\2\2\u00fa\u00fc\7\60\2\2\u00fb\u00f8\3\2\2\2\u00fc"+
		"\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe-\3\2\2\2"+
		"\u00ff\u00fd\3\2\2\2\u0100\u011a\5\64\33\2\u0101\u0103\5\64\33\2\u0102"+
		"\u0104\5\60\31\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3"+
		"\2\2\2\u0105\u0106\3\2\2\2\u0106\u010a\3\2\2\2\u0107\u0109\5\62\32\2\u0108"+
		"\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2"+
		"\2\2\u010b\u011a\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f\5H%\2\u010e\u0110"+
		"\5\60\31\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2"+
		"\u0111\u0112\3\2\2\2\u0112\u0116\3\2\2\2\u0113\u0115\5\62\32\2\u0114\u0113"+
		"\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u0100\3\2\2\2\u0119\u0101\3\2"+
		"\2\2\u0119\u010d\3\2\2\2\u011a/\3\2\2\2\u011b\u011c\7/\2\2\u011c\u011d"+
		"\5@!\2\u011d\u011e\7\60\2\2\u011e\61\3\2\2\2\u011f\u0120\7/\2\2\u0120"+
		"\u0121\7\60\2\2\u0121\63\3\2\2\2\u0122\u0123\79\2\2\u0123\65\3\2\2\2\u0124"+
		"\u0125\7<\2\2\u0125\67\3\2\2\2\u0126\u0127\7\16\2\2\u01279\3\2\2\2\u0128"+
		"\u0129\t\2\2\2\u0129;\3\2\2\2\u012a\u012b\7\13\2\2\u012b=\3\2\2\2\u012c"+
		"\u012d\7;\2\2\u012d?\3\2\2\2\u012e\u012f\b!\1\2\u012f\u0139\5F$\2\u0130"+
		"\u0139\5B\"\2\u0131\u0134\7\27\2\2\u0132\u0134\7\30\2\2\u0133\u0131\3"+
		"\2\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0139\5@!\17\u0136"+
		"\u0137\t\3\2\2\u0137\u0139\5@!\16\u0138\u012e\3\2\2\2\u0138\u0130\3\2"+
		"\2\2\u0138\u0133\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u0162\3\2\2\2\u013a"+
		"\u013b\f\r\2\2\u013b\u013c\t\4\2\2\u013c\u0161\5@!\16\u013d\u013e\f\f"+
		"\2\2\u013e\u013f\t\5\2\2\u013f\u0161\5@!\r\u0140\u0141\f\13\2\2\u0141"+
		"\u0142\t\6\2\2\u0142\u0161\5@!\f\u0143\u0144\f\n\2\2\u0144\u0145\t\7\2"+
		"\2\u0145\u0161\5@!\13\u0146\u0147\f\t\2\2\u0147\u0148\7\36\2\2\u0148\u0161"+
		"\5@!\n\u0149\u014a\f\b\2\2\u014a\u014b\7\37\2\2\u014b\u0161\5@!\t\u014c"+
		"\u014d\f\7\2\2\u014d\u014e\7 \2\2\u014e\u0161\5@!\b\u014f\u0150\f\6\2"+
		"\2\u0150\u0151\7\31\2\2\u0151\u0161\5@!\7\u0152\u0153\f\5\2\2\u0153\u0154"+
		"\7\32\2\2\u0154\u0161\5@!\6\u0155\u0156\f\4\2\2\u0156\u0157\7\67\2\2\u0157"+
		"\u0158\5@!\2\u0158\u0159\78\2\2\u0159\u015a\5@!\4\u015a\u0161\3\2\2\2"+
		"\u015b\u015c\f\3\2\2\u015c\u015d\7-\2\2\u015d\u0161\5@!\3\u015e\u015f"+
		"\f\20\2\2\u015f\u0161\t\b\2\2\u0160\u013a\3\2\2\2\u0160\u013d\3\2\2\2"+
		"\u0160\u0140\3\2\2\2\u0160\u0143\3\2\2\2\u0160\u0146\3\2\2\2\u0160\u0149"+
		"\3\2\2\2\u0160\u014c\3\2\2\2\u0160\u014f\3\2\2\2\u0160\u0152\3\2\2\2\u0160"+
		"\u0155\3\2\2\2\u0160\u015b\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0164\3\2"+
		"\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163A\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0165\u0166\7\t\2\2\u0166\u0169\5.\30\2\u0167\u0168\7\61\2\2"+
		"\u0168\u016a\7\62\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016aC\3"+
		"\2\2\2\u016b\u0171\5\66\34\2\u016c\u0171\58\35\2\u016d\u0171\5:\36\2\u016e"+
		"\u0171\5<\37\2\u016f\u0171\5> \2\u0170\u016b\3\2\2\2\u0170\u016c\3\2\2"+
		"\2\u0170\u016d\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171E"+
		"\3\2\2\2\u0172\u0173\b$\1\2\u0173\u0181\5\64\33\2\u0174\u0181\5D#\2\u0175"+
		"\u0176\7\61\2\2\u0176\u0177\5@!\2\u0177\u0178\7\62\2\2\u0178\u0181\3\2"+
		"\2\2\u0179\u017a\5\64\33\2\u017a\u017c\7\61\2\2\u017b\u017d\5\f\7\2\u017c"+
		"\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\7\62"+
		"\2\2\u017f\u0181\3\2\2\2\u0180\u0172\3\2\2\2\u0180\u0174\3\2\2\2\u0180"+
		"\u0175\3\2\2\2\u0180\u0179\3\2\2\2\u0181\u0195\3\2\2\2\u0182\u0183\f\6"+
		"\2\2\u0183\u0184\7.\2\2\u0184\u0194\5\64\33\2\u0185\u0186\f\5\2\2\u0186"+
		"\u0187\7.\2\2\u0187\u0188\5\64\33\2\u0188\u018a\7\61\2\2\u0189\u018b\5"+
		"\f\7\2\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018d\7\62\2\2\u018d\u0194\3\2\2\2\u018e\u018f\f\4\2\2\u018f\u0190\7"+
		"/\2\2\u0190\u0191\5@!\2\u0191\u0192\7\60\2\2\u0192\u0194\3\2\2\2\u0193"+
		"\u0182\3\2\2\2\u0193\u0185\3\2\2\2\u0193\u018e\3\2\2\2\u0194\u0197\3\2"+
		"\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196G\3\2\2\2\u0197\u0195"+
		"\3\2\2\2\u0198\u019d\7\5\2\2\u0199\u019d\7\6\2\2\u019a\u019d\7\7\2\2\u019b"+
		"\u019d\7\b\2\2\u019c\u0198\3\2\2\2\u019c\u0199\3\2\2\2\u019c\u019a\3\2"+
		"\2\2\u019c\u019b\3\2\2\2\u019dI\3\2\2\2)MU[er}\u0086\u0094\u009a\u00a5"+
		"\u00ae\u00ba\u00c6\u00ca\u00d2\u00d6\u00da\u00de\u00e3\u00ed\u00f6\u00fd"+
		"\u0105\u010a\u0111\u0116\u0119\u0133\u0138\u0160\u0162\u0169\u0170\u017c"+
		"\u0180\u018a\u0193\u0195\u019c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}