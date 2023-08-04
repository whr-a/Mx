// Generated from /home/whr/Mx/antlr/MxLexer.g4 by ANTLR 4.9.2
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LineComments", "BlockComments", "Void", "Bool", "Int", "String", "New", 
			"Class", "Null", "True", "False", "This", "If", "Else", "For", "While", 
			"Break", "Continue", "Return", "OpArrow", "OpIncre", "OpDecre", "OpAnd", 
			"OpOr", "OpNot", "OpShr", "OpShl", "OpBitAnd", "OpBitOr", "OpBitXor", 
			"OpBitCompl", "OpAdd", "OPSub", "OPMul", "OpDiv", "OpMod", "OpGeq", "OpLeq", 
			"OpGt", "OpLt", "OpNeq", "OpEq", "OpAssign", "OpMemberAccess", "LBracket", 
			"RBracket", "LParenthese", "RParenthese", "LBrace", "RBrace", "SemiColon", 
			"Comma", "Question", "Colon", "Digit", "DigitExceptZero", "Letter", "IdentifierCharacter", 
			"EscapeCharacter", "StringCharacter", "Identifier", "LogicalLiteral", 
			"IntegerLiteral", "StringLiteral", "NullLiteral", "Whitespace", "NewLine"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u0186\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\2\3\2\7\2\u008e\n"+
		"\2\f\2\16\2\u0091\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u0099\n\3\f\3\16\3"+
		"\u009c\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3"+
		"/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\5=\u015d\n=\3>"+
		"\3>\7>\u0161\n>\f>\16>\u0164\13>\3?\3?\5?\u0168\n?\3@\3@\3@\7@\u016d\n"+
		"@\f@\16@\u0170\13@\5@\u0172\n@\3A\3A\7A\u0176\nA\fA\16A\u0179\13A\3A\3"+
		"A\3B\3B\3C\3C\3C\3C\3D\3D\3D\3D\3\u009a\2E\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o\2q\2s\2u\2w\2y\2{9}:\177;"+
		"\u0081<\u0083=\u0085>\u0087?\3\2\n\5\2\f\f\17\17\u202a\u202b\3\2\62;\3"+
		"\2\63;\4\2C\\c|\6\2\62;C\\aac|\5\2$$^^pp\7\2\f\f\17\17$$^^\u202a\u202b"+
		"\6\2\13\13\r\16\"\"\u00a2\u00a2\2\u0187\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\3\u0089\3\2\2\2\5\u0094\3\2\2\2\7\u00a2\3\2\2\2\t\u00a7\3\2\2\2\13"+
		"\u00ac\3\2\2\2\r\u00b0\3\2\2\2\17\u00b7\3\2\2\2\21\u00bb\3\2\2\2\23\u00c1"+
		"\3\2\2\2\25\u00c6\3\2\2\2\27\u00cb\3\2\2\2\31\u00d1\3\2\2\2\33\u00d6\3"+
		"\2\2\2\35\u00d9\3\2\2\2\37\u00de\3\2\2\2!\u00e2\3\2\2\2#\u00e8\3\2\2\2"+
		"%\u00ee\3\2\2\2\'\u00f7\3\2\2\2)\u00fe\3\2\2\2+\u0101\3\2\2\2-\u0104\3"+
		"\2\2\2/\u0107\3\2\2\2\61\u010a\3\2\2\2\63\u010d\3\2\2\2\65\u010f\3\2\2"+
		"\2\67\u0112\3\2\2\29\u0115\3\2\2\2;\u0117\3\2\2\2=\u0119\3\2\2\2?\u011b"+
		"\3\2\2\2A\u011d\3\2\2\2C\u011f\3\2\2\2E\u0121\3\2\2\2G\u0123\3\2\2\2I"+
		"\u0125\3\2\2\2K\u0127\3\2\2\2M\u012a\3\2\2\2O\u012d\3\2\2\2Q\u012f\3\2"+
		"\2\2S\u0131\3\2\2\2U\u0134\3\2\2\2W\u0137\3\2\2\2Y\u0139\3\2\2\2[\u013b"+
		"\3\2\2\2]\u013d\3\2\2\2_\u013f\3\2\2\2a\u0141\3\2\2\2c\u0143\3\2\2\2e"+
		"\u0145\3\2\2\2g\u0147\3\2\2\2i\u0149\3\2\2\2k\u014b\3\2\2\2m\u014d\3\2"+
		"\2\2o\u014f\3\2\2\2q\u0151\3\2\2\2s\u0153\3\2\2\2u\u0155\3\2\2\2w\u0157"+
		"\3\2\2\2y\u015c\3\2\2\2{\u015e\3\2\2\2}\u0167\3\2\2\2\177\u0171\3\2\2"+
		"\2\u0081\u0173\3\2\2\2\u0083\u017c\3\2\2\2\u0085\u017e\3\2\2\2\u0087\u0182"+
		"\3\2\2\2\u0089\u008a\7\61\2\2\u008a\u008b\7\61\2\2\u008b\u008f\3\2\2\2"+
		"\u008c\u008e\n\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\b\2\2\2\u0093\4\3\2\2\2\u0094\u0095\7\61\2\2\u0095\u0096\7,\2\2"+
		"\u0096\u009a\3\2\2\2\u0097\u0099\13\2\2\2\u0098\u0097\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\7,\2\2\u009e\u009f\7\61\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\b\3\2\2\u00a1\6\3\2\2\2\u00a2\u00a3\7x\2\2\u00a3\u00a4"+
		"\7q\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7f\2\2\u00a6\b\3\2\2\2\u00a7\u00a8"+
		"\7d\2\2\u00a8\u00a9\7q\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7n\2\2\u00ab"+
		"\n\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7v\2\2\u00af"+
		"\f\3\2\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7i\2\2\u00b6\16\3\2\2\2\u00b7"+
		"\u00b8\7p\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7y\2\2\u00ba\20\3\2\2\2\u00bb"+
		"\u00bc\7e\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7u\2\2"+
		"\u00bf\u00c0\7u\2\2\u00c0\22\3\2\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3\7"+
		"w\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7n\2\2\u00c5\24\3\2\2\2\u00c6\u00c7"+
		"\7v\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"\26\3\2\2\2\u00cb\u00cc\7h\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7n\2\2\u00ce"+
		"\u00cf\7u\2\2\u00cf\u00d0\7g\2\2\u00d0\30\3\2\2\2\u00d1\u00d2\7v\2\2\u00d2"+
		"\u00d3\7j\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7u\2\2\u00d5\32\3\2\2\2\u00d6"+
		"\u00d7\7k\2\2\u00d7\u00d8\7h\2\2\u00d8\34\3\2\2\2\u00d9\u00da\7g\2\2\u00da"+
		"\u00db\7n\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7g\2\2\u00dd\36\3\2\2\2\u00de"+
		"\u00df\7h\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7t\2\2\u00e1 \3\2\2\2\u00e2"+
		"\u00e3\7y\2\2\u00e3\u00e4\7j\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7n\2\2"+
		"\u00e6\u00e7\7g\2\2\u00e7\"\3\2\2\2\u00e8\u00e9\7d\2\2\u00e9\u00ea\7t"+
		"\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed\7m\2\2\u00ed$\3"+
		"\2\2\2\u00ee\u00ef\7e\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7p\2\2\u00f1"+
		"\u00f2\7v\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5\7w\2\2"+
		"\u00f5\u00f6\7g\2\2\u00f6&\3\2\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7g\2"+
		"\2\u00f9\u00fa\7v\2\2\u00fa\u00fb\7w\2\2\u00fb\u00fc\7t\2\2\u00fc\u00fd"+
		"\7p\2\2\u00fd(\3\2\2\2\u00fe\u00ff\7/\2\2\u00ff\u0100\7@\2\2\u0100*\3"+
		"\2\2\2\u0101\u0102\7-\2\2\u0102\u0103\7-\2\2\u0103,\3\2\2\2\u0104\u0105"+
		"\7/\2\2\u0105\u0106\7/\2\2\u0106.\3\2\2\2\u0107\u0108\7(\2\2\u0108\u0109"+
		"\7(\2\2\u0109\60\3\2\2\2\u010a\u010b\7~\2\2\u010b\u010c\7~\2\2\u010c\62"+
		"\3\2\2\2\u010d\u010e\7#\2\2\u010e\64\3\2\2\2\u010f\u0110\7@\2\2\u0110"+
		"\u0111\7@\2\2\u0111\66\3\2\2\2\u0112\u0113\7>\2\2\u0113\u0114\7>\2\2\u0114"+
		"8\3\2\2\2\u0115\u0116\7(\2\2\u0116:\3\2\2\2\u0117\u0118\7~\2\2\u0118<"+
		"\3\2\2\2\u0119\u011a\7`\2\2\u011a>\3\2\2\2\u011b\u011c\7\u0080\2\2\u011c"+
		"@\3\2\2\2\u011d\u011e\7-\2\2\u011eB\3\2\2\2\u011f\u0120\7/\2\2\u0120D"+
		"\3\2\2\2\u0121\u0122\7,\2\2\u0122F\3\2\2\2\u0123\u0124\7\61\2\2\u0124"+
		"H\3\2\2\2\u0125\u0126\7\'\2\2\u0126J\3\2\2\2\u0127\u0128\7@\2\2\u0128"+
		"\u0129\7?\2\2\u0129L\3\2\2\2\u012a\u012b\7>\2\2\u012b\u012c\7?\2\2\u012c"+
		"N\3\2\2\2\u012d\u012e\7@\2\2\u012eP\3\2\2\2\u012f\u0130\7>\2\2\u0130R"+
		"\3\2\2\2\u0131\u0132\7#\2\2\u0132\u0133\7?\2\2\u0133T\3\2\2\2\u0134\u0135"+
		"\7?\2\2\u0135\u0136\7?\2\2\u0136V\3\2\2\2\u0137\u0138\7?\2\2\u0138X\3"+
		"\2\2\2\u0139\u013a\7\60\2\2\u013aZ\3\2\2\2\u013b\u013c\7]\2\2\u013c\\"+
		"\3\2\2\2\u013d\u013e\7_\2\2\u013e^\3\2\2\2\u013f\u0140\7*\2\2\u0140`\3"+
		"\2\2\2\u0141\u0142\7+\2\2\u0142b\3\2\2\2\u0143\u0144\7}\2\2\u0144d\3\2"+
		"\2\2\u0145\u0146\7\177\2\2\u0146f\3\2\2\2\u0147\u0148\7=\2\2\u0148h\3"+
		"\2\2\2\u0149\u014a\7.\2\2\u014aj\3\2\2\2\u014b\u014c\7A\2\2\u014cl\3\2"+
		"\2\2\u014d\u014e\7<\2\2\u014en\3\2\2\2\u014f\u0150\t\3\2\2\u0150p\3\2"+
		"\2\2\u0151\u0152\t\4\2\2\u0152r\3\2\2\2\u0153\u0154\t\5\2\2\u0154t\3\2"+
		"\2\2\u0155\u0156\t\6\2\2\u0156v\3\2\2\2\u0157\u0158\t\7\2\2\u0158x\3\2"+
		"\2\2\u0159\u015d\n\b\2\2\u015a\u015b\7^\2\2\u015b\u015d\5w<\2\u015c\u0159"+
		"\3\2\2\2\u015c\u015a\3\2\2\2\u015dz\3\2\2\2\u015e\u0162\5s:\2\u015f\u0161"+
		"\5u;\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163|\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0168\5\25\13"+
		"\2\u0166\u0168\5\27\f\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168"+
		"~\3\2\2\2\u0169\u0172\7\62\2\2\u016a\u016e\5q9\2\u016b\u016d\5o8\2\u016c"+
		"\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2"+
		"\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0169\3\2\2\2\u0171"+
		"\u016a\3\2\2\2\u0172\u0080\3\2\2\2\u0173\u0177\7$\2\2\u0174\u0176\5y="+
		"\2\u0175\u0174\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178"+
		"\3\2\2\2\u0178\u017a\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7$\2\2\u017b"+
		"\u0082\3\2\2\2\u017c\u017d\5\23\n\2\u017d\u0084\3\2\2\2\u017e\u017f\t"+
		"\t\2\2\u017f\u0180\3\2\2\2\u0180\u0181\bC\2\2\u0181\u0086\3\2\2\2\u0182"+
		"\u0183\t\2\2\2\u0183\u0184\3\2\2\2\u0184\u0185\bD\2\2\u0185\u0088\3\2"+
		"\2\2\13\2\u008f\u009a\u015c\u0162\u0167\u016e\u0171\u0177\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}