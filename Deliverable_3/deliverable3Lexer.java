// Generated from deliverable3.g4 by ANTLR 4.13.2

    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.List;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class deliverable3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, COMMENT=33, MULTILINE_COMMENT=34, VARIABLE=35, NUMBER=36, STRING=37, 
		BOOLEAN=38, WS=39, NEWLINE=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "COMMENT", 
			"MULTILINE_COMMENT", "VARIABLE", "NUMBER", "DIGIT", "STRING", "BOOLEAN", 
			"WS", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'+='", "'-='", "'*='", "'/='", "'if'", "':'", "'elif'", 
			"'else'", "'while'", "'for'", "'in'", "'range'", "'('", "','", "')'", 
			"'and'", "'or'", "'not'", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "COMMENT", "MULTILINE_COMMENT", 
			"VARIABLE", "NUMBER", "STRING", "BOOLEAN", "WS", "NEWLINE"
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


	    Stack<Integer> indents = new Stack<Integer>(); // stack to track indent levels
	    List<org.antlr.v4.runtime.Token> pendingTokens = new ArrayList<>(); // tokens waiting to be processed

	    {
	        indents.push(0); // start with base indent at 0
	    }

	    int getIndentationCount(String whitespace) { // get the indentation count for a line
	        int count = 0; 
	        for (char ch : whitespace.toCharArray()) {
	            if (ch == '\t') {
	                count++; // count tabs
	            }
	        }
	        return count; // return current indentation level
	    }

	    org.antlr.v4.runtime.Token createToken(int ttype, String text) { // creating token for antlr
	        org.antlr.v4.runtime.CommonToken token = new org.antlr.v4.runtime.CommonToken(_tokenFactorySourcePair, ttype, DEFAULT_TOKEN_CHANNEL, getCharIndex(), getCharIndex());
	        token.setLine(getLine()); 
	        token.setCharPositionInLine(getCharPositionInLine()); 
	        token.setText(text); 
	        return token; 
	    }

	    void handleIndentation(String newLineText) {
	        int nextChar = _input.LA(1); // peek next char
	        StringBuilder buffer = new StringBuilder(); // buffer for whitespace

	        // consume whitespace chars
	        while (nextChar == '\t') {
	            buffer.append((char)nextChar); // add tab to buffer
	            _input.consume(); // consume char
	            nextChar = _input.LA(1); // peek next char
	        }

	        String ws = buffer.toString(); // get indentation whitespace
	        int currentIndent = getIndentationCount(ws); // current indent count
	        int previousIndent = indents.peek(); // previous indent level on stack

	        if (currentIndent > previousIndent) {
	            // check for going up 2 in indent which is illegal
	            if (currentIndent - previousIndent > 1) { // too big jump
	                throw new org.antlr.v4.runtime.LexerNoViableAltException(this, _input, _tokenStartCharIndex, null); // throw error
	            }

	            // if indent is okay (less than or equal to 1)
	            indents.push(currentIndent); // push new indent level
	            pendingTokens.add(createToken(deliverable3Parser.INDENT, ws)); // add indent token
	        } else if (currentIndent < previousIndent) {
	            // allow multiple dedents (ex: end of nested structure where indent goes from 2 to 0)
	            while (!indents.isEmpty() && indents.peek() > currentIndent) {
	                indents.pop(); // pop higher indent levels
	                pendingTokens.add(createToken(deliverable3Parser.DEDENT, "")); // add dedent token
	            }
	        }
	    }

	    @Override
	    public org.antlr.v4.runtime.Token nextToken() {
	        if (!pendingTokens.isEmpty()) {
	            // return pending token if available
	            return pendingTokens.remove(0); 
	        }

	        org.antlr.v4.runtime.Token t = super.nextToken(); // get next token from super
	        if (t.getType() == NEWLINE) {
	            if (_input.LA(1) != org.antlr.v4.runtime.IntStream.EOF) {
	                handleIndentation(t.getText()); // handle indentation after newline
	                if (!pendingTokens.isEmpty()) {
	                    // return pending indentation or dedentation token
	                    return pendingTokens.remove(0);
	                }
	            }
	        }
	        return t; // return token if no indent changes
	    }


	public deliverable3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "deliverable3.g4"; }

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
		"\u0004\u0000(\u0113\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0005 \u00b5\b \n \f \u00b8\t \u0001 \u0001 \u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0005!\u00c1\b!\n!\f!\u00c4\t!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0005\"\u00ce\b\"\n\"\f"+
		"\"\u00d1\t\"\u0001#\u0003#\u00d4\b#\u0001#\u0004#\u00d7\b#\u000b#\f#\u00d8"+
		"\u0001#\u0001#\u0004#\u00dd\b#\u000b#\f#\u00de\u0003#\u00e1\b#\u0001$"+
		"\u0001$\u0001%\u0001%\u0001%\u0001%\u0005%\u00e9\b%\n%\f%\u00ec\t%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0005%\u00f3\b%\n%\f%\u00f6\t%\u0001%\u0003"+
		"%\u00f9\b%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0003&\u0104\b&\u0001\'\u0004\'\u0107\b\'\u000b\'\f\'\u0108\u0001\'"+
		"\u0001\'\u0001(\u0001(\u0001(\u0004(\u0110\b(\u000b(\f(\u0111\u0001\u00c2"+
		"\u0000)\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\""+
		"E#G$I\u0000K%M&O\'Q(\u0001\u0000\u0007\u0002\u0000\n\n\r\r\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\"\"\\\\\u0002\u0000"+
		"\'\'\\\\\u0003\u0000\t\t\r\r  \u0121\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000"+
		";\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001"+
		"\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000"+
		"\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000"+
		"K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001"+
		"\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0001S\u0001\u0000\u0000"+
		"\u0000\u0003U\u0001\u0000\u0000\u0000\u0005X\u0001\u0000\u0000\u0000\u0007"+
		"[\u0001\u0000\u0000\u0000\t^\u0001\u0000\u0000\u0000\u000ba\u0001\u0000"+
		"\u0000\u0000\rd\u0001\u0000\u0000\u0000\u000ff\u0001\u0000\u0000\u0000"+
		"\u0011k\u0001\u0000\u0000\u0000\u0013p\u0001\u0000\u0000\u0000\u0015v"+
		"\u0001\u0000\u0000\u0000\u0017z\u0001\u0000\u0000\u0000\u0019}\u0001\u0000"+
		"\u0000\u0000\u001b\u0083\u0001\u0000\u0000\u0000\u001d\u0085\u0001\u0000"+
		"\u0000\u0000\u001f\u0087\u0001\u0000\u0000\u0000!\u0089\u0001\u0000\u0000"+
		"\u0000#\u008d\u0001\u0000\u0000\u0000%\u0090\u0001\u0000\u0000\u0000\'"+
		"\u0094\u0001\u0000\u0000\u0000)\u0096\u0001\u0000\u0000\u0000+\u0098\u0001"+
		"\u0000\u0000\u0000-\u009a\u0001\u0000\u0000\u0000/\u009c\u0001\u0000\u0000"+
		"\u00001\u009e\u0001\u0000\u0000\u00003\u00a0\u0001\u0000\u0000\u00005"+
		"\u00a3\u0001\u0000\u0000\u00007\u00a5\u0001\u0000\u0000\u00009\u00a8\u0001"+
		"\u0000\u0000\u0000;\u00ab\u0001\u0000\u0000\u0000=\u00ae\u0001\u0000\u0000"+
		"\u0000?\u00b0\u0001\u0000\u0000\u0000A\u00b2\u0001\u0000\u0000\u0000C"+
		"\u00bb\u0001\u0000\u0000\u0000E\u00cb\u0001\u0000\u0000\u0000G\u00d3\u0001"+
		"\u0000\u0000\u0000I\u00e2\u0001\u0000\u0000\u0000K\u00f8\u0001\u0000\u0000"+
		"\u0000M\u0103\u0001\u0000\u0000\u0000O\u0106\u0001\u0000\u0000\u0000Q"+
		"\u010f\u0001\u0000\u0000\u0000ST\u0005=\u0000\u0000T\u0002\u0001\u0000"+
		"\u0000\u0000UV\u0005+\u0000\u0000VW\u0005=\u0000\u0000W\u0004\u0001\u0000"+
		"\u0000\u0000XY\u0005-\u0000\u0000YZ\u0005=\u0000\u0000Z\u0006\u0001\u0000"+
		"\u0000\u0000[\\\u0005*\u0000\u0000\\]\u0005=\u0000\u0000]\b\u0001\u0000"+
		"\u0000\u0000^_\u0005/\u0000\u0000_`\u0005=\u0000\u0000`\n\u0001\u0000"+
		"\u0000\u0000ab\u0005i\u0000\u0000bc\u0005f\u0000\u0000c\f\u0001\u0000"+
		"\u0000\u0000de\u0005:\u0000\u0000e\u000e\u0001\u0000\u0000\u0000fg\u0005"+
		"e\u0000\u0000gh\u0005l\u0000\u0000hi\u0005i\u0000\u0000ij\u0005f\u0000"+
		"\u0000j\u0010\u0001\u0000\u0000\u0000kl\u0005e\u0000\u0000lm\u0005l\u0000"+
		"\u0000mn\u0005s\u0000\u0000no\u0005e\u0000\u0000o\u0012\u0001\u0000\u0000"+
		"\u0000pq\u0005w\u0000\u0000qr\u0005h\u0000\u0000rs\u0005i\u0000\u0000"+
		"st\u0005l\u0000\u0000tu\u0005e\u0000\u0000u\u0014\u0001\u0000\u0000\u0000"+
		"vw\u0005f\u0000\u0000wx\u0005o\u0000\u0000xy\u0005r\u0000\u0000y\u0016"+
		"\u0001\u0000\u0000\u0000z{\u0005i\u0000\u0000{|\u0005n\u0000\u0000|\u0018"+
		"\u0001\u0000\u0000\u0000}~\u0005r\u0000\u0000~\u007f\u0005a\u0000\u0000"+
		"\u007f\u0080\u0005n\u0000\u0000\u0080\u0081\u0005g\u0000\u0000\u0081\u0082"+
		"\u0005e\u0000\u0000\u0082\u001a\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"(\u0000\u0000\u0084\u001c\u0001\u0000\u0000\u0000\u0085\u0086\u0005,\u0000"+
		"\u0000\u0086\u001e\u0001\u0000\u0000\u0000\u0087\u0088\u0005)\u0000\u0000"+
		"\u0088 \u0001\u0000\u0000\u0000\u0089\u008a\u0005a\u0000\u0000\u008a\u008b"+
		"\u0005n\u0000\u0000\u008b\u008c\u0005d\u0000\u0000\u008c\"\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005o\u0000\u0000\u008e\u008f\u0005r\u0000\u0000"+
		"\u008f$\u0001\u0000\u0000\u0000\u0090\u0091\u0005n\u0000\u0000\u0091\u0092"+
		"\u0005o\u0000\u0000\u0092\u0093\u0005t\u0000\u0000\u0093&\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0005+\u0000\u0000\u0095(\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005-\u0000\u0000\u0097*\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005*\u0000\u0000\u0099,\u0001\u0000\u0000\u0000\u009a\u009b\u0005/"+
		"\u0000\u0000\u009b.\u0001\u0000\u0000\u0000\u009c\u009d\u0005%\u0000\u0000"+
		"\u009d0\u0001\u0000\u0000\u0000\u009e\u009f\u0005<\u0000\u0000\u009f2"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005<\u0000\u0000\u00a1\u00a2\u0005"+
		"=\u0000\u0000\u00a24\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005>\u0000"+
		"\u0000\u00a46\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005>\u0000\u0000\u00a6"+
		"\u00a7\u0005=\u0000\u0000\u00a78\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005"+
		"=\u0000\u0000\u00a9\u00aa\u0005=\u0000\u0000\u00aa:\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005!\u0000\u0000\u00ac\u00ad\u0005=\u0000\u0000\u00ad"+
		"<\u0001\u0000\u0000\u0000\u00ae\u00af\u0005[\u0000\u0000\u00af>\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005]\u0000\u0000\u00b1@\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b6\u0005#\u0000\u0000\u00b3\u00b5\b\u0000\u0000\u0000"+
		"\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0006 \u0000\u0000\u00baB\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0005\'\u0000\u0000\u00bc\u00bd\u0005\'\u0000\u0000\u00bd\u00be\u0005"+
		"\'\u0000\u0000\u00be\u00c2\u0001\u0000\u0000\u0000\u00bf\u00c1\t\u0000"+
		"\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0005\'\u0000\u0000\u00c6\u00c7\u0005\'\u0000"+
		"\u0000\u00c7\u00c8\u0005\'\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0006!\u0000\u0000\u00caD\u0001\u0000\u0000\u0000\u00cb\u00cf"+
		"\u0007\u0001\u0000\u0000\u00cc\u00ce\u0007\u0002\u0000\u0000\u00cd\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0F\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d4\u0005"+
		"-\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000\u00d5\u00d7\u0003I$\u0000"+
		"\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00e0\u0001\u0000\u0000\u0000\u00da\u00dc\u0005.\u0000\u0000\u00db"+
		"\u00dd\u0003I$\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001"+
		"\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001"+
		"\u0000\u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00da\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1H\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0007\u0003\u0000\u0000\u00e3J\u0001\u0000\u0000"+
		"\u0000\u00e4\u00ea\u0005\"\u0000\u0000\u00e5\u00e9\b\u0004\u0000\u0000"+
		"\u00e6\u00e7\u0005\\\u0000\u0000\u00e7\u00e9\t\u0000\u0000\u0000\u00e8"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea"+
		"\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ed\u00f9\u0005\"\u0000\u0000\u00ee\u00f4"+
		"\u0005\'\u0000\u0000\u00ef\u00f3\b\u0005\u0000\u0000\u00f0\u00f1\u0005"+
		"\\\u0000\u0000\u00f1\u00f3\t\u0000\u0000\u0000\u00f2\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f9\u0005\'\u0000\u0000\u00f8\u00e4\u0001\u0000\u0000"+
		"\u0000\u00f8\u00ee\u0001\u0000\u0000\u0000\u00f9L\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0005T\u0000\u0000\u00fb\u00fc\u0005r\u0000\u0000\u00fc\u00fd"+
		"\u0005u\u0000\u0000\u00fd\u0104\u0005e\u0000\u0000\u00fe\u00ff\u0005F"+
		"\u0000\u0000\u00ff\u0100\u0005a\u0000\u0000\u0100\u0101\u0005l\u0000\u0000"+
		"\u0101\u0102\u0005s\u0000\u0000\u0102\u0104\u0005e\u0000\u0000\u0103\u00fa"+
		"\u0001\u0000\u0000\u0000\u0103\u00fe\u0001\u0000\u0000\u0000\u0104N\u0001"+
		"\u0000\u0000\u0000\u0105\u0107\u0007\u0006\u0000\u0000\u0106\u0105\u0001"+
		"\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0106\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0006\'\u0000\u0000\u010bP\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0005\r\u0000\u0000\u010d\u0110\u0005\n\u0000"+
		"\u0000\u010e\u0110\u0007\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000"+
		"\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000"+
		"\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000"+
		"\u0000\u0112R\u0001\u0000\u0000\u0000\u0011\u0000\u00b6\u00c2\u00cf\u00d3"+
		"\u00d8\u00de\u00e0\u00e8\u00ea\u00f2\u00f4\u00f8\u0103\u0108\u010f\u0111"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}