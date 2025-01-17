// Generated from D:/Joe/DevJava/ComputerAlgebraSystem/src/UserInterface\Interpreter.g4 by ANTLR 4.8
package Antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InterpreterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGIT=1, LOWERCASE=2, UPPERCASE=3, PLUS=4, MINUS=5, MULTIPLY=6, DIVIDE=7, 
		POWER=8, OBRACKET=9, CBRACKET=10, SIN=11, COS=12, TAN=13, COT=14, SEC=15, 
		CSC=16;
	public static final int
		RULE_number = 0, RULE_variable = 1, RULE_expression = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"number", "variable", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", 
			"'sin'", "'cos'", "'tan'", "'cot'", "'sec'", "'csc'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DIGIT", "LOWERCASE", "UPPERCASE", "PLUS", "MINUS", "MULTIPLY", 
			"DIVIDE", "POWER", "OBRACKET", "CBRACKET", "SIN", "COS", "TAN", "COT", 
			"SEC", "CSC"
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
	public String getGrammarFileName() { return "Interpreter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InterpreterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(InterpreterParser.DIGIT, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_number);
		try {
			setState(10);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(7);
				match(DIGIT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(8);
				match(DIGIT);
				setState(9);
				number();
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode LOWERCASE() { return getToken(InterpreterParser.LOWERCASE, 0); }
		public TerminalNode UPPERCASE() { return getToken(InterpreterParser.UPPERCASE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variable);
		try {
			setState(15);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				match(LOWERCASE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(14);
				match(UPPERCASE);
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

	public static class ExpressionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode OBRACKET() { return getToken(InterpreterParser.OBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CBRACKET() { return getToken(InterpreterParser.CBRACKET, 0); }
		public TerminalNode SIN() { return getToken(InterpreterParser.SIN, 0); }
		public TerminalNode COS() { return getToken(InterpreterParser.COS, 0); }
		public TerminalNode TAN() { return getToken(InterpreterParser.TAN, 0); }
		public TerminalNode COT() { return getToken(InterpreterParser.COT, 0); }
		public TerminalNode SEC() { return getToken(InterpreterParser.SEC, 0); }
		public TerminalNode CSC() { return getToken(InterpreterParser.CSC, 0); }
		public TerminalNode MULTIPLY() { return getToken(InterpreterParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(InterpreterParser.DIVIDE, 0); }
		public TerminalNode PLUS() { return getToken(InterpreterParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(InterpreterParser.MINUS, 0); }
		public TerminalNode POWER() { return getToken(InterpreterParser.POWER, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InterpreterListener ) ((InterpreterListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InterpreterVisitor ) return ((InterpreterVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(18);
				variable();
				}
				break;
			case 3:
				{
				setState(19);
				number();
				}
				break;
			case 4:
				{
				setState(20);
				match(OBRACKET);
				setState(21);
				expression(0);
				setState(22);
				match(CBRACKET);
				}
				break;
			case 5:
				{
				setState(24);
				match(SIN);
				setState(25);
				match(OBRACKET);
				setState(26);
				expression(0);
				setState(27);
				match(CBRACKET);
				}
				break;
			case 6:
				{
				setState(29);
				match(COS);
				setState(30);
				match(OBRACKET);
				setState(31);
				expression(0);
				setState(32);
				match(CBRACKET);
				}
				break;
			case 7:
				{
				setState(34);
				match(TAN);
				setState(35);
				match(OBRACKET);
				setState(36);
				expression(0);
				setState(37);
				match(CBRACKET);
				}
				break;
			case 8:
				{
				setState(39);
				match(COT);
				setState(40);
				match(OBRACKET);
				setState(41);
				expression(0);
				setState(42);
				match(CBRACKET);
				}
				break;
			case 9:
				{
				setState(44);
				match(SEC);
				setState(45);
				match(OBRACKET);
				setState(46);
				expression(0);
				setState(47);
				match(CBRACKET);
				}
				break;
			case 10:
				{
				setState(49);
				match(CSC);
				setState(50);
				match(OBRACKET);
				setState(51);
				expression(0);
				setState(52);
				match(CBRACKET);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(68);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(56);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(57);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(58);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(59);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(60);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(61);
						expression(2);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(62);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(63);
						match(POWER);
						setState(64);
						match(OBRACKET);
						setState(65);
						expression(0);
						setState(66);
						match(CBRACKET);
						}
						break;
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22L\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\5\2\r\n\2\3\3\3\3\3\3\5\3\22\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\49\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4G\n\4\f\4\16"+
		"\4J\13\4\3\4\2\3\6\5\2\4\6\2\4\3\2\b\t\3\2\6\7\2X\2\f\3\2\2\2\4\21\3\2"+
		"\2\2\68\3\2\2\2\b\r\3\2\2\2\t\r\7\3\2\2\n\13\7\3\2\2\13\r\5\2\2\2\f\b"+
		"\3\2\2\2\f\t\3\2\2\2\f\n\3\2\2\2\r\3\3\2\2\2\16\22\3\2\2\2\17\22\7\4\2"+
		"\2\20\22\7\5\2\2\21\16\3\2\2\2\21\17\3\2\2\2\21\20\3\2\2\2\22\5\3\2\2"+
		"\2\239\b\4\1\2\249\5\4\3\2\259\5\2\2\2\26\27\7\13\2\2\27\30\5\6\4\2\30"+
		"\31\7\f\2\2\319\3\2\2\2\32\33\7\r\2\2\33\34\7\13\2\2\34\35\5\6\4\2\35"+
		"\36\7\f\2\2\369\3\2\2\2\37 \7\16\2\2 !\7\13\2\2!\"\5\6\4\2\"#\7\f\2\2"+
		"#9\3\2\2\2$%\7\17\2\2%&\7\13\2\2&\'\5\6\4\2\'(\7\f\2\2(9\3\2\2\2)*\7\20"+
		"\2\2*+\7\13\2\2+,\5\6\4\2,-\7\f\2\2-9\3\2\2\2./\7\21\2\2/\60\7\13\2\2"+
		"\60\61\5\6\4\2\61\62\7\f\2\2\629\3\2\2\2\63\64\7\22\2\2\64\65\7\13\2\2"+
		"\65\66\5\6\4\2\66\67\7\f\2\2\679\3\2\2\28\23\3\2\2\28\24\3\2\2\28\25\3"+
		"\2\2\28\26\3\2\2\28\32\3\2\2\28\37\3\2\2\28$\3\2\2\28)\3\2\2\28.\3\2\2"+
		"\28\63\3\2\2\29H\3\2\2\2:;\f\4\2\2;<\t\2\2\2<G\5\6\4\5=>\f\3\2\2>?\t\3"+
		"\2\2?G\5\6\4\4@A\f\5\2\2AB\7\n\2\2BC\7\13\2\2CD\5\6\4\2DE\7\f\2\2EG\3"+
		"\2\2\2F:\3\2\2\2F=\3\2\2\2F@\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\7"+
		"\3\2\2\2JH\3\2\2\2\7\f\218FH";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}