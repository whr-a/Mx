// Generated from /home/whr/Mx/MxLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LineComment", "BlockComment", "Void", "Bool", "Int", "String", "New", 
			"Class", "Null", "True", "False", "This", "If", "Else", "For", "While", 
			"Break", "Continue", "Return", "OpArrow", "OpIncre", "OpDecre", "OpAnd", 
			"OpOr", "OpNot", "OpShr", "OpShl", "OpBitAnd", "OpBitOr", "OpBitXor", 
			"OpBitCompl", "OpAdd", "OPSub", "OPMul", "OpDiv", "OpMod", "OpGeq", "OpLeq", 
			"OpGt", "OpLt", "OpNeq", "OpEq", "OpAssign", "OpMemberAccess", "LBracket", 
			"RBracket", "LParenthese", "RParenthese", "LBrace", "RBrace", "SemiColon", 
			"Comma", "Question", "Colon", "Digit", "Symbol", "DigitExceptZero", "Letter", 
			"IdentifierCharacter", "EscapeCharacter", "StringCharacter", "Identifier", 
			"LogicalLiteral", "IntegerLiteral", "StringLiteral", "NullLiteral", "Whitespace", 
			"NewLine"
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u018a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\7\2\u0090"+
		"\n\2\f\2\16\2\u0093\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u009b\n\3\f\3\16"+
		"\3\u009e\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3"+
		"%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3"+
		".\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3>\5>\u0161"+
		"\n>\3?\3?\7?\u0165\n?\f?\16?\u0168\13?\3@\3@\5@\u016c\n@\3A\3A\3A\7A\u0171"+
		"\nA\fA\16A\u0174\13A\5A\u0176\nA\3B\3B\7B\u017a\nB\fB\16B\u017d\13B\3"+
		"B\3B\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3\u009c\2F\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o\2q\2s\2u\2w\2y\2{\2}9\177"+
		":\u0081;\u0083<\u0085=\u0087>\u0089?\3\2\13\5\2\f\f\17\17\u202a\u202b"+
		"\3\2\62;\7\2#\61<B]]_b}\u0080\3\2\63;\4\2C\\c|\6\2\62;C\\aac|\5\2$$^^"+
		"pp\7\2\f\f\17\17$$^^\u202a\u202b\6\2\13\13\r\16\"\"\u00a2\u00a2\2\u018a"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3"+
		"\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\3\u008b\3\2\2\2\5\u0096\3\2\2\2"+
		"\7\u00a4\3\2\2\2\t\u00a9\3\2\2\2\13\u00ae\3\2\2\2\r\u00b2\3\2\2\2\17\u00b9"+
		"\3\2\2\2\21\u00bd\3\2\2\2\23\u00c3\3\2\2\2\25\u00c8\3\2\2\2\27\u00cd\3"+
		"\2\2\2\31\u00d3\3\2\2\2\33\u00d8\3\2\2\2\35\u00db\3\2\2\2\37\u00e0\3\2"+
		"\2\2!\u00e4\3\2\2\2#\u00ea\3\2\2\2%\u00f0\3\2\2\2\'\u00f9\3\2\2\2)\u0100"+
		"\3\2\2\2+\u0103\3\2\2\2-\u0106\3\2\2\2/\u0109\3\2\2\2\61\u010c\3\2\2\2"+
		"\63\u010f\3\2\2\2\65\u0111\3\2\2\2\67\u0114\3\2\2\29\u0117\3\2\2\2;\u0119"+
		"\3\2\2\2=\u011b\3\2\2\2?\u011d\3\2\2\2A\u011f\3\2\2\2C\u0121\3\2\2\2E"+
		"\u0123\3\2\2\2G\u0125\3\2\2\2I\u0127\3\2\2\2K\u0129\3\2\2\2M\u012c\3\2"+
		"\2\2O\u012f\3\2\2\2Q\u0131\3\2\2\2S\u0133\3\2\2\2U\u0136\3\2\2\2W\u0139"+
		"\3\2\2\2Y\u013b\3\2\2\2[\u013d\3\2\2\2]\u013f\3\2\2\2_\u0141\3\2\2\2a"+
		"\u0143\3\2\2\2c\u0145\3\2\2\2e\u0147\3\2\2\2g\u0149\3\2\2\2i\u014b\3\2"+
		"\2\2k\u014d\3\2\2\2m\u014f\3\2\2\2o\u0151\3\2\2\2q\u0153\3\2\2\2s\u0155"+
		"\3\2\2\2u\u0157\3\2\2\2w\u0159\3\2\2\2y\u015b\3\2\2\2{\u0160\3\2\2\2}"+
		"\u0162\3\2\2\2\177\u016b\3\2\2\2\u0081\u0175\3\2\2\2\u0083\u0177\3\2\2"+
		"\2\u0085\u0180\3\2\2\2\u0087\u0182\3\2\2\2\u0089\u0186\3\2\2\2\u008b\u008c"+
		"\7\61\2\2\u008c\u008d\7\61\2\2\u008d\u0091\3\2\2\2\u008e\u0090\n\2\2\2"+
		"\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\b\2\2\2\u0095"+
		"\4\3\2\2\2\u0096\u0097\7\61\2\2\u0097\u0098\7,\2\2\u0098\u009c\3\2\2\2"+
		"\u0099\u009b\13\2\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\7,\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\3"+
		"\2\2\u00a3\6\3\2\2\2\u00a4\u00a5\7x\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7"+
		"\7k\2\2\u00a7\u00a8\7f\2\2\u00a8\b\3\2\2\2\u00a9\u00aa\7d\2\2\u00aa\u00ab"+
		"\7q\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7n\2\2\u00ad\n\3\2\2\2\u00ae\u00af"+
		"\7k\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7v\2\2\u00b1\f\3\2\2\2\u00b2\u00b3"+
		"\7u\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6\7k\2\2\u00b6"+
		"\u00b7\7p\2\2\u00b7\u00b8\7i\2\2\u00b8\16\3\2\2\2\u00b9\u00ba\7p\2\2\u00ba"+
		"\u00bb\7g\2\2\u00bb\u00bc\7y\2\2\u00bc\20\3\2\2\2\u00bd\u00be\7e\2\2\u00be"+
		"\u00bf\7n\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7u\2\2"+
		"\u00c2\22\3\2\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7"+
		"n\2\2\u00c6\u00c7\7n\2\2\u00c7\24\3\2\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca"+
		"\7t\2\2\u00ca\u00cb\7w\2\2\u00cb\u00cc\7g\2\2\u00cc\26\3\2\2\2\u00cd\u00ce"+
		"\7h\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7u\2\2\u00d1"+
		"\u00d2\7g\2\2\u00d2\30\3\2\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7j\2\2\u00d5"+
		"\u00d6\7k\2\2\u00d6\u00d7\7u\2\2\u00d7\32\3\2\2\2\u00d8\u00d9\7k\2\2\u00d9"+
		"\u00da\7h\2\2\u00da\34\3\2\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7n\2\2\u00dd"+
		"\u00de\7u\2\2\u00de\u00df\7g\2\2\u00df\36\3\2\2\2\u00e0\u00e1\7h\2\2\u00e1"+
		"\u00e2\7q\2\2\u00e2\u00e3\7t\2\2\u00e3 \3\2\2\2\u00e4\u00e5\7y\2\2\u00e5"+
		"\u00e6\7j\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9\7g\2\2"+
		"\u00e9\"\3\2\2\2\u00ea\u00eb\7d\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7g"+
		"\2\2\u00ed\u00ee\7c\2\2\u00ee\u00ef\7m\2\2\u00ef$\3\2\2\2\u00f0\u00f1"+
		"\7e\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7v\2\2\u00f4"+
		"\u00f5\7k\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7g\2\2"+
		"\u00f8&\3\2\2\2\u00f9\u00fa\7t\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7v\2"+
		"\2\u00fc\u00fd\7w\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff\7p\2\2\u00ff(\3\2"+
		"\2\2\u0100\u0101\7/\2\2\u0101\u0102\7@\2\2\u0102*\3\2\2\2\u0103\u0104"+
		"\7-\2\2\u0104\u0105\7-\2\2\u0105,\3\2\2\2\u0106\u0107\7/\2\2\u0107\u0108"+
		"\7/\2\2\u0108.\3\2\2\2\u0109\u010a\7(\2\2\u010a\u010b\7(\2\2\u010b\60"+
		"\3\2\2\2\u010c\u010d\7~\2\2\u010d\u010e\7~\2\2\u010e\62\3\2\2\2\u010f"+
		"\u0110\7#\2\2\u0110\64\3\2\2\2\u0111\u0112\7@\2\2\u0112\u0113\7@\2\2\u0113"+
		"\66\3\2\2\2\u0114\u0115\7>\2\2\u0115\u0116\7>\2\2\u01168\3\2\2\2\u0117"+
		"\u0118\7(\2\2\u0118:\3\2\2\2\u0119\u011a\7~\2\2\u011a<\3\2\2\2\u011b\u011c"+
		"\7`\2\2\u011c>\3\2\2\2\u011d\u011e\7\u0080\2\2\u011e@\3\2\2\2\u011f\u0120"+
		"\7-\2\2\u0120B\3\2\2\2\u0121\u0122\7/\2\2\u0122D\3\2\2\2\u0123\u0124\7"+
		",\2\2\u0124F\3\2\2\2\u0125\u0126\7\61\2\2\u0126H\3\2\2\2\u0127\u0128\7"+
		"\'\2\2\u0128J\3\2\2\2\u0129\u012a\7@\2\2\u012a\u012b\7?\2\2\u012bL\3\2"+
		"\2\2\u012c\u012d\7>\2\2\u012d\u012e\7?\2\2\u012eN\3\2\2\2\u012f\u0130"+
		"\7@\2\2\u0130P\3\2\2\2\u0131\u0132\7>\2\2\u0132R\3\2\2\2\u0133\u0134\7"+
		"#\2\2\u0134\u0135\7?\2\2\u0135T\3\2\2\2\u0136\u0137\7?\2\2\u0137\u0138"+
		"\7?\2\2\u0138V\3\2\2\2\u0139\u013a\7?\2\2\u013aX\3\2\2\2\u013b\u013c\7"+
		"\60\2\2\u013cZ\3\2\2\2\u013d\u013e\7]\2\2\u013e\\\3\2\2\2\u013f\u0140"+
		"\7_\2\2\u0140^\3\2\2\2\u0141\u0142\7*\2\2\u0142`\3\2\2\2\u0143\u0144\7"+
		"+\2\2\u0144b\3\2\2\2\u0145\u0146\7}\2\2\u0146d\3\2\2\2\u0147\u0148\7\177"+
		"\2\2\u0148f\3\2\2\2\u0149\u014a\7=\2\2\u014ah\3\2\2\2\u014b\u014c\7.\2"+
		"\2\u014cj\3\2\2\2\u014d\u014e\7A\2\2\u014el\3\2\2\2\u014f\u0150\7<\2\2"+
		"\u0150n\3\2\2\2\u0151\u0152\t\3\2\2\u0152p\3\2\2\2\u0153\u0154\t\4\2\2"+
		"\u0154r\3\2\2\2\u0155\u0156\t\5\2\2\u0156t\3\2\2\2\u0157\u0158\t\6\2\2"+
		"\u0158v\3\2\2\2\u0159\u015a\t\7\2\2\u015ax\3\2\2\2\u015b\u015c\t\b\2\2"+
		"\u015cz\3\2\2\2\u015d\u0161\n\t\2\2\u015e\u015f\7^\2\2\u015f\u0161\5y"+
		"=\2\u0160\u015d\3\2\2\2\u0160\u015e\3\2\2\2\u0161|\3\2\2\2\u0162\u0166"+
		"\5u;\2\u0163\u0165\5w<\2\u0164\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166"+
		"\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167~\3\2\2\2\u0168\u0166\3\2\2\2"+
		"\u0169\u016c\5\25\13\2\u016a\u016c\5\27\f\2\u016b\u0169\3\2\2\2\u016b"+
		"\u016a\3\2\2\2\u016c\u0080\3\2\2\2\u016d\u0176\7\62\2\2\u016e\u0172\5"+
		"s:\2\u016f\u0171\5o8\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0175"+
		"\u016d\3\2\2\2\u0175\u016e\3\2\2\2\u0176\u0082\3\2\2\2\u0177\u017b\7$"+
		"\2\2\u0178\u017a\5{>\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u017b\3\2\2\2\u017e"+
		"\u017f\7$\2\2\u017f\u0084\3\2\2\2\u0180\u0181\5\23\n\2\u0181\u0086\3\2"+
		"\2\2\u0182\u0183\t\n\2\2\u0183\u0184\3\2\2\2\u0184\u0185\bD\2\2\u0185"+
		"\u0088\3\2\2\2\u0186\u0187\t\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\bE"+
		"\2\2\u0189\u008a\3\2\2\2\13\2\u0091\u009c\u0160\u0166\u016b\u0172\u0175"+
		"\u017b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}