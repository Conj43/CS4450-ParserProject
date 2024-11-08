// Generated from e://rgood//Documents//IMPORTANT//CODE//SchoolProjects//POPL//CS4450-ParserProject//Deliverable_1//deliverable1.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class deliverable1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, VARIABLE=14, NUMBER=15, STRING=16, 
		BOOLEAN=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "VARIABLE", "NUMBER", "STRING", "BOOLEAN", 
			"DIGIT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+='", "'-='", "'*='", "'/='", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'['", "','", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "VARIABLE", "NUMBER", "STRING", "BOOLEAN", "WS"
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


	public deliverable1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "deliverable1.g4"; }

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
		"\u0004\u0000\u0012\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0005\rH\b\r\n\r\f\rK\t\r\u0001\u000e\u0004\u000eN\b\u000e"+
		"\u000b\u000e\f\u000eO\u0001\u000e\u0001\u000e\u0004\u000eT\b\u000e\u000b"+
		"\u000e\f\u000eU\u0003\u000eX\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f^\b\u000f\n\u000f\f\u000fa\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000fh\b\u000f"+
		"\n\u000f\f\u000fk\t\u000f\u0001\u000f\u0003\u000fn\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010y\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0004\u0012~\b\u0012\u000b\u0012\f\u0012\u007f\u0001\u0012"+
		"\u0001\u0012\u0000\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0000%\u0012"+
		"\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000\""+
		"\"\\\\\u0001\u000009\u0003\u0000\t\n\r\r  \u008c\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003)\u0001"+
		"\u0000\u0000\u0000\u0005,\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000"+
		"\u0000\t2\u0001\u0000\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\r7\u0001"+
		"\u0000\u0000\u0000\u000f9\u0001\u0000\u0000\u0000\u0011;\u0001\u0000\u0000"+
		"\u0000\u0013=\u0001\u0000\u0000\u0000\u0015?\u0001\u0000\u0000\u0000\u0017"+
		"A\u0001\u0000\u0000\u0000\u0019C\u0001\u0000\u0000\u0000\u001bE\u0001"+
		"\u0000\u0000\u0000\u001dM\u0001\u0000\u0000\u0000\u001fm\u0001\u0000\u0000"+
		"\u0000!x\u0001\u0000\u0000\u0000#z\u0001\u0000\u0000\u0000%}\u0001\u0000"+
		"\u0000\u0000\'(\u0005=\u0000\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005"+
		"+\u0000\u0000*+\u0005=\u0000\u0000+\u0004\u0001\u0000\u0000\u0000,-\u0005"+
		"-\u0000\u0000-.\u0005=\u0000\u0000.\u0006\u0001\u0000\u0000\u0000/0\u0005"+
		"*\u0000\u000001\u0005=\u0000\u00001\b\u0001\u0000\u0000\u000023\u0005"+
		"/\u0000\u000034\u0005=\u0000\u00004\n\u0001\u0000\u0000\u000056\u0005"+
		"+\u0000\u00006\f\u0001\u0000\u0000\u000078\u0005-\u0000\u00008\u000e\u0001"+
		"\u0000\u0000\u00009:\u0005*\u0000\u0000:\u0010\u0001\u0000\u0000\u0000"+
		";<\u0005/\u0000\u0000<\u0012\u0001\u0000\u0000\u0000=>\u0005%\u0000\u0000"+
		">\u0014\u0001\u0000\u0000\u0000?@\u0005[\u0000\u0000@\u0016\u0001\u0000"+
		"\u0000\u0000AB\u0005,\u0000\u0000B\u0018\u0001\u0000\u0000\u0000CD\u0005"+
		"]\u0000\u0000D\u001a\u0001\u0000\u0000\u0000EI\u0007\u0000\u0000\u0000"+
		"FH\u0007\u0001\u0000\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u001c\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LN\u0003#\u0011\u0000ML\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PW\u0001\u0000\u0000\u0000QS\u0005.\u0000\u0000"+
		"RT\u0003#\u0011\u0000SR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000\u0000"+
		"\u0000WQ\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X\u001e\u0001"+
		"\u0000\u0000\u0000Y_\u0005\"\u0000\u0000Z^\b\u0002\u0000\u0000[\\\u0005"+
		"\\\u0000\u0000\\^\t\u0000\u0000\u0000]Z\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000bn\u0005\"\u0000\u0000ci\u0005\'\u0000\u0000dh\b\u0002\u0000\u0000"+
		"ef\u0005\\\u0000\u0000fh\t\u0000\u0000\u0000gd\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000"+
		"\u0000\u0000ln\u0005\'\u0000\u0000mY\u0001\u0000\u0000\u0000mc\u0001\u0000"+
		"\u0000\u0000n \u0001\u0000\u0000\u0000op\u0005T\u0000\u0000pq\u0005r\u0000"+
		"\u0000qr\u0005u\u0000\u0000ry\u0005e\u0000\u0000st\u0005F\u0000\u0000"+
		"tu\u0005a\u0000\u0000uv\u0005l\u0000\u0000vw\u0005s\u0000\u0000wy\u0005"+
		"e\u0000\u0000xo\u0001\u0000\u0000\u0000xs\u0001\u0000\u0000\u0000y\"\u0001"+
		"\u0000\u0000\u0000z{\u0007\u0003\u0000\u0000{$\u0001\u0000\u0000\u0000"+
		"|~\u0007\u0004\u0000\u0000}|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0006\u0012\u0000"+
		"\u0000\u0082&\u0001\u0000\u0000\u0000\f\u0000IOUW]_gimx\u007f\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}