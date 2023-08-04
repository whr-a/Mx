// Generated from /home/whr/Mx/MxParser.g4 by ANTLR 4.9.2
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
		LineComment=1, BlockComment=2, Void=3, Bool=4, Int=5, String=6, New=7, 
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
		RULE_literalExpression = 33, RULE_lhsExpression = 34, RULE_lambdaExpression = 35, 
		RULE_primitiveTypename = 36;
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
			"lhsExpression", "lambdaExpression", "primitiveTypename"
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
			null, "LineComment", "BlockComment", "Void", "Bool", "Int", "String", 
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(74);
				declaration();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
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
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionDeclarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				functionDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassDeclarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				classDeclaration();
				}
				break;
			case 3:
				_localctx = new GlobalVariableDeclarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
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
			setState(87);
			typename(0);
			setState(88);
			identifier();
			setState(89);
			match(LParenthese);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(90);
				functionDeclParamList();
				}
			}

			setState(93);
			match(RParenthese);
			setState(94);
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
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(96);
					functionDeclParam();
					setState(97);
					match(Comma);
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(104);
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
			setState(106);
			typename(0);
			setState(107);
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
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(109);
					expression(0);
					setState(110);
					match(Comma);
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(117);
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
			setState(119);
			match(Class);
			setState(120);
			identifier();
			setState(121);
			match(LBrace);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				{
				setState(122);
				classComponents();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(RBrace);
			setState(129);
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
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ClassMemberDeclarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				variableDeclaration();
				}
				break;
			case 2:
				_localctx = new ClassMethodDeclarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				functionDeclaration();
				}
				break;
			case 3:
				_localctx = new ConstructorDeclarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
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
			setState(136);
			identifier();
			setState(137);
			match(LParenthese);
			setState(138);
			match(RParenthese);
			setState(139);
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
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				blockStatement();
				}
				break;
			case 2:
				_localctx = new VarDeclarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				variableDeclaration();
				}
				break;
			case 3:
				_localctx = new ExpressionStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				expressionStatement();
				}
				break;
			case 4:
				_localctx = new BranchStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				branchStatement();
				}
				break;
			case 5:
				_localctx = new LoopStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
				loopStatement();
				}
				break;
			case 6:
				_localctx = new CtrlFlowStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(146);
				controlFlowStatement();
				}
				break;
			case 7:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
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
			setState(150);
			match(LBrace);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << LBrace) | (1L << SemiColon) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
				{
				{
				setState(151);
				statement();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
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
			setState(159);
			typename(0);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(160);
					initDeclarator();
					setState(161);
					match(Comma);
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(168);
			initDeclarator();
			setState(169);
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
			setState(171);
			identifier();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpAssign) {
				{
				setState(172);
				match(OpAssign);
				setState(173);
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
			setState(176);
			expression(0);
			setState(177);
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
			setState(179);
			match(If);
			setState(180);
			match(LParenthese);
			setState(181);
			((BranchStatementContext)_localctx).condition = expression(0);
			setState(182);
			match(RParenthese);
			setState(183);
			((BranchStatementContext)_localctx).ifStatement = statement();
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(184);
				match(Else);
				setState(185);
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
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(While);
				setState(189);
				match(LParenthese);
				setState(190);
				((WhileLoopContext)_localctx).condition = expression(0);
				setState(191);
				match(RParenthese);
				setState(192);
				((WhileLoopContext)_localctx).body = statement();
				}
				break;
			case 2:
				_localctx = new DeclForLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(For);
				setState(195);
				match(LParenthese);
				setState(196);
				((DeclForLoopContext)_localctx).init = variableDeclaration();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(197);
					((DeclForLoopContext)_localctx).condition = expression(0);
					}
				}

				setState(200);
				match(SemiColon);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(201);
					((DeclForLoopContext)_localctx).step = expression(0);
					}
				}

				setState(204);
				match(RParenthese);
				setState(205);
				((DeclForLoopContext)_localctx).body = statement();
				}
				break;
			case 3:
				_localctx = new ExprForLoopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(For);
				setState(208);
				match(LParenthese);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(209);
					((ExprForLoopContext)_localctx).init = expression(0);
					}
				}

				setState(212);
				match(SemiColon);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(213);
					((ExprForLoopContext)_localctx).condition = expression(0);
					}
				}

				setState(216);
				match(SemiColon);
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(217);
					((ExprForLoopContext)_localctx).step = expression(0);
					}
				}

				setState(220);
				match(RParenthese);
				setState(221);
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
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				continueStatement();
				}
				break;
			case Break:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				breakStatement();
				}
				break;
			case Return:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
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
			setState(229);
			match(Continue);
			setState(230);
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
			setState(232);
			match(Break);
			setState(233);
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
			setState(235);
			match(Return);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
				{
				setState(236);
				expression(0);
				}
			}

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
			setState(241);
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
			setState(246);
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

				setState(244);
				primitiveTypename();
				}
				break;
			case Identifier:
				{
				_localctx = new ClassTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(253);
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
					setState(248);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(249);
					match(LBracket);
					setState(250);
					match(RBracket);
					}
					} 
				}
				setState(255);
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
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new NewClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				identifier();
				}
				break;
			case 2:
				_localctx = new NewClassArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				identifier();
				setState(259); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(258);
						newArrayExprCount();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(261); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(263);
						newArrayEmptyCount();
						}
						} 
					}
					setState(268);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new NewPrimitiveArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				primitiveTypename();
				setState(271); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(270);
						newArrayExprCount();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(273); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(275);
						newArrayEmptyCount();
						}
						} 
					}
					setState(280);
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
			setState(283);
			match(LBracket);
			setState(284);
			expression(0);
			setState(285);
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
			setState(287);
			match(LBracket);
			setState(288);
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
			setState(290);
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
			setState(292);
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
			setState(294);
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
			setState(296);
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
			setState(298);
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
			setState(300);
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
		public LhsExpressionContext lhsExpression() {
			return getRuleContext(LhsExpressionContext.class,0);
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
	public static class LambdaExprContext extends ExpressionContext {
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public LambdaExprContext(ExpressionContext ctx) { copyFrom(ctx); }
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
		public LhsExpressionContext l;
		public ExpressionContext r;
		public TerminalNode OpAssign() { return getToken(MxParser.OpAssign, 0); }
		public LhsExpressionContext lhsExpression() {
			return getRuleContext(LhsExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new LhsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(303);
				lhsExpression(0);
				}
				break;
			case 2:
				{
				_localctx = new LambdaExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(304);
				lambdaExpression();
				}
				break;
			case 3:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(305);
				newExpression();
				}
				break;
			case 4:
				{
				_localctx = new PostfixUpdateExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(306);
				lhsExpression(0);
				setState(307);
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
			case 5:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(309);
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
				setState(310);
				((UnaryExprContext)_localctx).r = expression(12);
				}
				break;
			case 6:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311);
				((AssignExprContext)_localctx).l = lhsExpression(0);
				setState(312);
				match(OpAssign);
				setState(313);
				((AssignExprContext)_localctx).r = expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(350);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(318);
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
						setState(319);
						((BinaryExprContext)_localctx).r = expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(321);
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
						setState(322);
						((BinaryExprContext)_localctx).r = expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(323);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(324);
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
						setState(325);
						((BinaryExprContext)_localctx).r = expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(326);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(327);
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
						setState(328);
						((BinaryExprContext)_localctx).r = expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(330);
						((BinaryExprContext)_localctx).op = match(OpBitAnd);
						setState(331);
						((BinaryExprContext)_localctx).r = expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(333);
						((BinaryExprContext)_localctx).op = match(OpBitOr);
						setState(334);
						((BinaryExprContext)_localctx).r = expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(335);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(336);
						((BinaryExprContext)_localctx).op = match(OpBitXor);
						setState(337);
						((BinaryExprContext)_localctx).r = expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(338);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(339);
						((BinaryExprContext)_localctx).op = match(OpAnd);
						setState(340);
						((BinaryExprContext)_localctx).r = expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(342);
						((BinaryExprContext)_localctx).op = match(OpOr);
						setState(343);
						((BinaryExprContext)_localctx).r = expression(4);
						}
						break;
					case 10:
						{
						_localctx = new TernaryexpContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryexpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(344);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(345);
						((TernaryexpContext)_localctx).op = match(Question);
						setState(346);
						((TernaryexpContext)_localctx).b = expression(0);
						setState(347);
						match(Colon);
						setState(348);
						((TernaryexpContext)_localctx).c = expression(2);
						}
						break;
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
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
	public static class PrefixUpdateExprContext extends LhsExpressionContext {
		public Token op;
		public LhsExpressionContext lhsExpression() {
			return getRuleContext(LhsExpressionContext.class,0);
		}
		public TerminalNode OpIncre() { return getToken(MxParser.OpIncre, 0); }
		public TerminalNode OpDecre() { return getToken(MxParser.OpDecre, 0); }
		public PrefixUpdateExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
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
	public static class LambdaCallExprContext extends LhsExpressionContext {
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public FunctionCallArgListContext functionCallArgList() {
			return getRuleContext(FunctionCallArgListContext.class,0);
		}
		public LambdaCallExprContext(LhsExpressionContext ctx) { copyFrom(ctx); }
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
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
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
				_localctx = new PrefixUpdateExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(377);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OpIncre:
					{
					setState(375);
					((PrefixUpdateExprContext)_localctx).op = match(OpIncre);
					}
					break;
				case OpDecre:
					{
					setState(376);
					((PrefixUpdateExprContext)_localctx).op = match(OpDecre);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(379);
				lhsExpression(3);
				}
				break;
			case 5:
				{
				_localctx = new FunCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(380);
				identifier();
				setState(381);
				match(LParenthese);
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(382);
					functionCallArgList();
					}
				}

				setState(385);
				match(RParenthese);
				}
				break;
			case 6:
				{
				_localctx = new LambdaCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(387);
				lambdaExpression();
				setState(388);
				match(LParenthese);
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
					{
					setState(389);
					functionCallArgList();
					}
				}

				setState(392);
				match(RParenthese);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(413);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new MemberVariableAccessExprContext(new LhsExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lhsExpression);
						setState(396);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(397);
						match(OpMemberAccess);
						setState(398);
						((MemberVariableAccessExprContext)_localctx).variable = identifier();
						}
						break;
					case 2:
						{
						_localctx = new MemberFunctionAccessExprContext(new LhsExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lhsExpression);
						setState(399);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(400);
						match(OpMemberAccess);
						setState(401);
						((MemberFunctionAccessExprContext)_localctx).method = identifier();
						setState(402);
						match(LParenthese);
						setState(404);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << OpIncre) | (1L << OpDecre) | (1L << OpNot) | (1L << OpBitCompl) | (1L << OpAdd) | (1L << OPSub) | (1L << LBracket) | (1L << LParenthese) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
							{
							setState(403);
							functionCallArgList();
							}
						}

						setState(406);
						match(RParenthese);
						}
						break;
					case 3:
						{
						_localctx = new ArrayExprContext(new LhsExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lhsExpression);
						setState(408);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(409);
						match(LBracket);
						setState(410);
						expression(0);
						setState(411);
						match(RBracket);
						}
						break;
					}
					} 
				}
				setState(417);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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

	public static class LambdaExpressionContext extends ParserRuleContext {
		public Token capture;
		public BlockStatementContext body;
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public TerminalNode OpArrow() { return getToken(MxParser.OpArrow, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode LParenthese() { return getToken(MxParser.LParenthese, 0); }
		public TerminalNode RParenthese() { return getToken(MxParser.RParenthese, 0); }
		public TerminalNode OpBitAnd() { return getToken(MxParser.OpBitAnd, 0); }
		public FunctionDeclParamListContext functionDeclParamList() {
			return getRuleContext(FunctionDeclParamListContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_lambdaExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(LBracket);
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpBitAnd) {
				{
				setState(419);
				((LambdaExpressionContext)_localctx).capture = match(OpBitAnd);
				}
			}

			setState(422);
			match(RBracket);
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParenthese) {
				{
				setState(423);
				match(LParenthese);
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
					{
					setState(424);
					functionDeclParamList();
					}
				}

				setState(427);
				match(RParenthese);
				}
			}

			setState(430);
			match(OpArrow);
			setState(431);
			((LambdaExpressionContext)_localctx).body = blockStatement();
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
		enterRule(_localctx, 72, RULE_primitiveTypename);
		try {
			setState(437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				match(Void);
				}
				break;
			case Bool:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(434);
				match(Bool);
				}
				break;
			case Int:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(435);
				match(Int);
				}
				break;
			case String:
				_localctx = new StringTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(436);
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
		}
		return true;
	}
	private boolean lhsExpression_sempred(LhsExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 6);
		case 12:
			return precpred(_ctx, 5);
		case 13:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u01ba\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\2\3"+
		"\2\3\3\3\3\3\3\5\3X\n\3\3\4\3\4\3\4\3\4\5\4^\n\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\7\5f\n\5\f\5\16\5i\13\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7s\n\7\f"+
		"\7\16\7v\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b~\n\b\f\b\16\b\u0081\13\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0097\n\13\3\f\3\f\7\f\u009b\n\f\f\f\16\f\u009e"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00a6\n\r\f\r\16\r\u00a9\13\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\5\16\u00b1\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u00bd\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00c9\n\21\3\21\3\21\5\21\u00cd\n\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u00d5\n\21\3\21\3\21\5\21\u00d9\n\21\3\21\3\21"+
		"\5\21\u00dd\n\21\3\21\3\21\5\21\u00e1\n\21\3\22\3\22\3\22\5\22\u00e6\n"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\5\25\u00f0\n\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\5\27\u00f9\n\27\3\27\3\27\3\27\7\27\u00fe\n"+
		"\27\f\27\16\27\u0101\13\27\3\30\3\30\3\30\6\30\u0106\n\30\r\30\16\30\u0107"+
		"\3\30\7\30\u010b\n\30\f\30\16\30\u010e\13\30\3\30\3\30\6\30\u0112\n\30"+
		"\r\30\16\30\u0113\3\30\7\30\u0117\n\30\f\30\16\30\u011a\13\30\5\30\u011c"+
		"\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u013e"+
		"\n!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0161\n!\f!\16!\u0164\13!\3\"\3\""+
		"\3\"\3\"\5\"\u016a\n\"\3#\3#\3#\3#\3#\5#\u0171\n#\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\5$\u017c\n$\3$\3$\3$\3$\5$\u0182\n$\3$\3$\3$\3$\3$\5$\u0189\n"+
		"$\3$\3$\5$\u018d\n$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u0197\n$\3$\3$\3$\3$\3"+
		"$\3$\3$\7$\u01a0\n$\f$\16$\u01a3\13$\3%\3%\5%\u01a7\n%\3%\3%\3%\5%\u01ac"+
		"\n%\3%\5%\u01af\n%\3%\3%\3%\3&\3&\3&\3&\5&\u01b8\n&\3&\2\5,@F\'\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\t\3"+
		"\2\f\r\3\2\27\30\4\2\33\33!#\3\2$&\3\2\"#\3\2\34\35\3\2\',\2\u01df\2O"+
		"\3\2\2\2\4W\3\2\2\2\6Y\3\2\2\2\bg\3\2\2\2\nl\3\2\2\2\ft\3\2\2\2\16y\3"+
		"\2\2\2\20\u0088\3\2\2\2\22\u008a\3\2\2\2\24\u0096\3\2\2\2\26\u0098\3\2"+
		"\2\2\30\u00a1\3\2\2\2\32\u00ad\3\2\2\2\34\u00b2\3\2\2\2\36\u00b5\3\2\2"+
		"\2 \u00e0\3\2\2\2\"\u00e5\3\2\2\2$\u00e7\3\2\2\2&\u00ea\3\2\2\2(\u00ed"+
		"\3\2\2\2*\u00f3\3\2\2\2,\u00f8\3\2\2\2.\u011b\3\2\2\2\60\u011d\3\2\2\2"+
		"\62\u0121\3\2\2\2\64\u0124\3\2\2\2\66\u0126\3\2\2\28\u0128\3\2\2\2:\u012a"+
		"\3\2\2\2<\u012c\3\2\2\2>\u012e\3\2\2\2@\u013d\3\2\2\2B\u0165\3\2\2\2D"+
		"\u0170\3\2\2\2F\u018c\3\2\2\2H\u01a4\3\2\2\2J\u01b7\3\2\2\2LN\5\4\3\2"+
		"ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\2\2\3"+
		"S\3\3\2\2\2TX\5\6\4\2UX\5\16\b\2VX\5\30\r\2WT\3\2\2\2WU\3\2\2\2WV\3\2"+
		"\2\2X\5\3\2\2\2YZ\5,\27\2Z[\5\64\33\2[]\7\61\2\2\\^\5\b\5\2]\\\3\2\2\2"+
		"]^\3\2\2\2^_\3\2\2\2_`\7\62\2\2`a\5\26\f\2a\7\3\2\2\2bc\5\n\6\2cd\7\66"+
		"\2\2df\3\2\2\2eb\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2"+
		"\2\2jk\5\n\6\2k\t\3\2\2\2lm\5,\27\2mn\5\64\33\2n\13\3\2\2\2op\5@!\2pq"+
		"\7\66\2\2qs\3\2\2\2ro\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2"+
		"vt\3\2\2\2wx\5@!\2x\r\3\2\2\2yz\7\n\2\2z{\5\64\33\2{\177\7\63\2\2|~\5"+
		"\20\t\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\64\2\2\u0083\u0084\7\65"+
		"\2\2\u0084\17\3\2\2\2\u0085\u0089\5\30\r\2\u0086\u0089\5\6\4\2\u0087\u0089"+
		"\5\22\n\2\u0088\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2"+
		"\u0089\21\3\2\2\2\u008a\u008b\5\64\33\2\u008b\u008c\7\61\2\2\u008c\u008d"+
		"\7\62\2\2\u008d\u008e\5\26\f\2\u008e\23\3\2\2\2\u008f\u0097\5\26\f\2\u0090"+
		"\u0097\5\30\r\2\u0091\u0097\5\34\17\2\u0092\u0097\5\36\20\2\u0093\u0097"+
		"\5 \21\2\u0094\u0097\5\"\22\2\u0095\u0097\5*\26\2\u0096\u008f\3\2\2\2"+
		"\u0096\u0090\3\2\2\2\u0096\u0091\3\2\2\2\u0096\u0092\3\2\2\2\u0096\u0093"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\25\3\2\2\2\u0098"+
		"\u009c\7\63\2\2\u0099\u009b\5\24\13\2\u009a\u0099\3\2\2\2\u009b\u009e"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\7\64\2\2\u00a0\27\3\2\2\2\u00a1\u00a7\5,\27"+
		"\2\u00a2\u00a3\5\32\16\2\u00a3\u00a4\7\66\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u00a2\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\5\32\16\2\u00ab"+
		"\u00ac\7\65\2\2\u00ac\31\3\2\2\2\u00ad\u00b0\5\64\33\2\u00ae\u00af\7-"+
		"\2\2\u00af\u00b1\5@!\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\33"+
		"\3\2\2\2\u00b2\u00b3\5@!\2\u00b3\u00b4\7\65\2\2\u00b4\35\3\2\2\2\u00b5"+
		"\u00b6\7\17\2\2\u00b6\u00b7\7\61\2\2\u00b7\u00b8\5@!\2\u00b8\u00b9\7\62"+
		"\2\2\u00b9\u00bc\5\24\13\2\u00ba\u00bb\7\20\2\2\u00bb\u00bd\5\24\13\2"+
		"\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\37\3\2\2\2\u00be\u00bf"+
		"\7\22\2\2\u00bf\u00c0\7\61\2\2\u00c0\u00c1\5@!\2\u00c1\u00c2\7\62\2\2"+
		"\u00c2\u00c3\5\24\13\2\u00c3\u00e1\3\2\2\2\u00c4\u00c5\7\21\2\2\u00c5"+
		"\u00c6\7\61\2\2\u00c6\u00c8\5\30\r\2\u00c7\u00c9\5@!\2\u00c8\u00c7\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\7\65\2\2\u00cb"+
		"\u00cd\5@!\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2"+
		"\2\u00ce\u00cf\7\62\2\2\u00cf\u00d0\5\24\13\2\u00d0\u00e1\3\2\2\2\u00d1"+
		"\u00d2\7\21\2\2\u00d2\u00d4\7\61\2\2\u00d3\u00d5\5@!\2\u00d4\u00d3\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\7\65\2\2\u00d7"+
		"\u00d9\5@!\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2"+
		"\2\u00da\u00dc\7\65\2\2\u00db\u00dd\5@!\2\u00dc\u00db\3\2\2\2\u00dc\u00dd"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7\62\2\2\u00df\u00e1\5\24\13"+
		"\2\u00e0\u00be\3\2\2\2\u00e0\u00c4\3\2\2\2\u00e0\u00d1\3\2\2\2\u00e1!"+
		"\3\2\2\2\u00e2\u00e6\5$\23\2\u00e3\u00e6\5&\24\2\u00e4\u00e6\5(\25\2\u00e5"+
		"\u00e2\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6#\3\2\2\2"+
		"\u00e7\u00e8\7\24\2\2\u00e8\u00e9\7\65\2\2\u00e9%\3\2\2\2\u00ea\u00eb"+
		"\7\23\2\2\u00eb\u00ec\7\65\2\2\u00ec\'\3\2\2\2\u00ed\u00ef\7\25\2\2\u00ee"+
		"\u00f0\5@!\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2"+
		"\2\u00f1\u00f2\7\65\2\2\u00f2)\3\2\2\2\u00f3\u00f4\7\65\2\2\u00f4+\3\2"+
		"\2\2\u00f5\u00f6\b\27\1\2\u00f6\u00f9\5J&\2\u00f7\u00f9\5\64\33\2\u00f8"+
		"\u00f5\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00ff\3\2\2\2\u00fa\u00fb\f\3"+
		"\2\2\u00fb\u00fc\7/\2\2\u00fc\u00fe\7\60\2\2\u00fd\u00fa\3\2\2\2\u00fe"+
		"\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100-\3\2\2\2"+
		"\u0101\u00ff\3\2\2\2\u0102\u011c\5\64\33\2\u0103\u0105\5\64\33\2\u0104"+
		"\u0106\5\60\31\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3"+
		"\2\2\2\u0107\u0108\3\2\2\2\u0108\u010c\3\2\2\2\u0109\u010b\5\62\32\2\u010a"+
		"\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u011c\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0111\5J&\2\u0110\u0112"+
		"\5\60\31\2\u0111\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2"+
		"\u0113\u0114\3\2\2\2\u0114\u0118\3\2\2\2\u0115\u0117\5\62\32\2\u0116\u0115"+
		"\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u0102\3\2\2\2\u011b\u0103\3\2"+
		"\2\2\u011b\u010f\3\2\2\2\u011c/\3\2\2\2\u011d\u011e\7/\2\2\u011e\u011f"+
		"\5@!\2\u011f\u0120\7\60\2\2\u0120\61\3\2\2\2\u0121\u0122\7/\2\2\u0122"+
		"\u0123\7\60\2\2\u0123\63\3\2\2\2\u0124\u0125\79\2\2\u0125\65\3\2\2\2\u0126"+
		"\u0127\7<\2\2\u0127\67\3\2\2\2\u0128\u0129\7\16\2\2\u01299\3\2\2\2\u012a"+
		"\u012b\t\2\2\2\u012b;\3\2\2\2\u012c\u012d\7\13\2\2\u012d=\3\2\2\2\u012e"+
		"\u012f\7;\2\2\u012f?\3\2\2\2\u0130\u0131\b!\1\2\u0131\u013e\5F$\2\u0132"+
		"\u013e\5H%\2\u0133\u013e\5B\"\2\u0134\u0135\5F$\2\u0135\u0136\t\3\2\2"+
		"\u0136\u013e\3\2\2\2\u0137\u0138\t\4\2\2\u0138\u013e\5@!\16\u0139\u013a"+
		"\5F$\2\u013a\u013b\7-\2\2\u013b\u013c\5@!\3\u013c\u013e\3\2\2\2\u013d"+
		"\u0130\3\2\2\2\u013d\u0132\3\2\2\2\u013d\u0133\3\2\2\2\u013d\u0134\3\2"+
		"\2\2\u013d\u0137\3\2\2\2\u013d\u0139\3\2\2\2\u013e\u0162\3\2\2\2\u013f"+
		"\u0140\f\r\2\2\u0140\u0141\t\5\2\2\u0141\u0161\5@!\16\u0142\u0143\f\f"+
		"\2\2\u0143\u0144\t\6\2\2\u0144\u0161\5@!\r\u0145\u0146\f\13\2\2\u0146"+
		"\u0147\t\7\2\2\u0147\u0161\5@!\f\u0148\u0149\f\n\2\2\u0149\u014a\t\b\2"+
		"\2\u014a\u0161\5@!\13\u014b\u014c\f\t\2\2\u014c\u014d\7\36\2\2\u014d\u0161"+
		"\5@!\n\u014e\u014f\f\b\2\2\u014f\u0150\7\37\2\2\u0150\u0161\5@!\t\u0151"+
		"\u0152\f\7\2\2\u0152\u0153\7 \2\2\u0153\u0161\5@!\b\u0154\u0155\f\6\2"+
		"\2\u0155\u0156\7\31\2\2\u0156\u0161\5@!\7\u0157\u0158\f\5\2\2\u0158\u0159"+
		"\7\32\2\2\u0159\u0161\5@!\6\u015a\u015b\f\4\2\2\u015b\u015c\7\67\2\2\u015c"+
		"\u015d\5@!\2\u015d\u015e\78\2\2\u015e\u015f\5@!\4\u015f\u0161\3\2\2\2"+
		"\u0160\u013f\3\2\2\2\u0160\u0142\3\2\2\2\u0160\u0145\3\2\2\2\u0160\u0148"+
		"\3\2\2\2\u0160\u014b\3\2\2\2\u0160\u014e\3\2\2\2\u0160\u0151\3\2\2\2\u0160"+
		"\u0154\3\2\2\2\u0160\u0157\3\2\2\2\u0160\u015a\3\2\2\2\u0161\u0164\3\2"+
		"\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163A\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0165\u0166\7\t\2\2\u0166\u0169\5.\30\2\u0167\u0168\7\61\2\2"+
		"\u0168\u016a\7\62\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016aC\3"+
		"\2\2\2\u016b\u0171\5\66\34\2\u016c\u0171\58\35\2\u016d\u0171\5:\36\2\u016e"+
		"\u0171\5<\37\2\u016f\u0171\5> \2\u0170\u016b\3\2\2\2\u0170\u016c\3\2\2"+
		"\2\u0170\u016d\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171E"+
		"\3\2\2\2\u0172\u0173\b$\1\2\u0173\u018d\5\64\33\2\u0174\u018d\5D#\2\u0175"+
		"\u0176\7\61\2\2\u0176\u0177\5@!\2\u0177\u0178\7\62\2\2\u0178\u018d\3\2"+
		"\2\2\u0179\u017c\7\27\2\2\u017a\u017c\7\30\2\2\u017b\u0179\3\2\2\2\u017b"+
		"\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u018d\5F$\5\u017e\u017f\5\64"+
		"\33\2\u017f\u0181\7\61\2\2\u0180\u0182\5\f\7\2\u0181\u0180\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\7\62\2\2\u0184\u018d\3"+
		"\2\2\2\u0185\u0186\5H%\2\u0186\u0188\7\61\2\2\u0187\u0189\5\f\7\2\u0188"+
		"\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\7\62"+
		"\2\2\u018b\u018d\3\2\2\2\u018c\u0172\3\2\2\2\u018c\u0174\3\2\2\2\u018c"+
		"\u0175\3\2\2\2\u018c\u017b\3\2\2\2\u018c\u017e\3\2\2\2\u018c\u0185\3\2"+
		"\2\2\u018d\u01a1\3\2\2\2\u018e\u018f\f\b\2\2\u018f\u0190\7.\2\2\u0190"+
		"\u01a0\5\64\33\2\u0191\u0192\f\7\2\2\u0192\u0193\7.\2\2\u0193\u0194\5"+
		"\64\33\2\u0194\u0196\7\61\2\2\u0195\u0197\5\f\7\2\u0196\u0195\3\2\2\2"+
		"\u0196\u0197\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\7\62\2\2\u0199\u01a0"+
		"\3\2\2\2\u019a\u019b\f\6\2\2\u019b\u019c\7/\2\2\u019c\u019d\5@!\2\u019d"+
		"\u019e\7\60\2\2\u019e\u01a0\3\2\2\2\u019f\u018e\3\2\2\2\u019f\u0191\3"+
		"\2\2\2\u019f\u019a\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2G\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a6\7/\2\2\u01a5"+
		"\u01a7\7\36\2\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\3"+
		"\2\2\2\u01a8\u01ae\7\60\2\2\u01a9\u01ab\7\61\2\2\u01aa\u01ac\5\b\5\2\u01ab"+
		"\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af\7\62"+
		"\2\2\u01ae\u01a9\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01b1\7\26\2\2\u01b1\u01b2\5\26\f\2\u01b2I\3\2\2\2\u01b3\u01b8\7\5\2"+
		"\2\u01b4\u01b8\7\6\2\2\u01b5\u01b8\7\7\2\2\u01b6\u01b8\7\b\2\2\u01b7\u01b3"+
		"\3\2\2\2\u01b7\u01b4\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8"+
		"K\3\2\2\2-OW]gt\177\u0088\u0096\u009c\u00a7\u00b0\u00bc\u00c8\u00cc\u00d4"+
		"\u00d8\u00dc\u00e0\u00e5\u00ef\u00f8\u00ff\u0107\u010c\u0113\u0118\u011b"+
		"\u013d\u0160\u0162\u0169\u0170\u017b\u0181\u0188\u018c\u0196\u019f\u01a1"+
		"\u01a6\u01ab\u01ae\u01b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}