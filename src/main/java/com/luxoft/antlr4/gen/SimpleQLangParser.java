// Generated from C:/Users/ma29379/workspace/svn/browser/src/main/resources\SimpleQLang.g4 by ANTLR 4.6
package com.luxoft.antlr4.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleQLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, AND=8, OR=9, IS=10, 
		NULL=11, LIKE=12, BETWEEN=13, IN=14, NOT=15, INT=16, EQ=17, LTH=18, GTH=19, 
		NOT_EQ=20, LET=21, GET=22, ID=23, USER_VAR=24, DOT=25, STRING=26, FLOAT=27, 
		REAL=28, A=29, N=30, D=31, X=32, O=33, R=34, I=35, S=36, U=37, L=38, K=39, 
		E=40, T=41, B=42, W=43, WS=44;
	public static final int
		RULE_expression = 0, RULE_logicalOp = 1, RULE_simpleExpression = 2, RULE_leftRightExpr = 3, 
		RULE_betweenExpr = 4, RULE_isExpr = 5, RULE_inExpr = 6, RULE_inElements = 7, 
		RULE_constant = 8, RULE_leftElement = 9, RULE_rightElement = 10, RULE_element = 11, 
		RULE_schemaName = 12, RULE_tableName = 13, RULE_name = 14, RULE_betweenAnd = 15, 
		RULE_nullVal = 16, RULE_columnName = 17, RULE_relationalOp = 18, RULE_notOp = 19, 
		RULE_isOp = 20, RULE_betweenOp = 21, RULE_inOp = 22, RULE_sign = 23;
	public static final String[] ruleNames = {
		"expression", "logicalOp", "simpleExpression", "leftRightExpr", "betweenExpr", 
		"isExpr", "inExpr", "inElements", "constant", "leftElement", "rightElement", 
		"element", "schemaName", "tableName", "name", "betweenAnd", "nullVal", 
		"columnName", "relationalOp", "notOp", "isOp", "betweenOp", "inOp", "sign"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'$'", "'|'", "'+'", "'-'", null, null, null, 
		null, null, null, null, null, null, "'='", "'<'", "'>'", null, "'<='", 
		"'>='", null, null, "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "AND", "OR", "IS", "NULL", 
		"LIKE", "BETWEEN", "IN", "NOT", "INT", "EQ", "LTH", "GTH", "NOT_EQ", "LET", 
		"GET", "ID", "USER_VAR", "DOT", "STRING", "FLOAT", "REAL", "A", "N", "D", 
		"X", "O", "R", "I", "S", "U", "L", "K", "E", "T", "B", "W", "WS"
	};
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
	public String getGrammarFileName() { return "SimpleQLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleQLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public List<LogicalOpContext> logicalOp() {
			return getRuleContexts(LogicalOpContext.class);
		}
		public LogicalOpContext logicalOp(int i) {
			return getRuleContext(LogicalOpContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			simpleExpression();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(49);
				logicalOp();
				setState(50);
				simpleExpression();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class LogicalOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SimpleQLangParser.AND, 0); }
		public TerminalNode OR() { return getToken(SimpleQLangParser.OR, 0); }
		public LogicalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterLogicalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitLogicalOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitLogicalOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOpContext logicalOp() throws RecognitionException {
		LogicalOpContext _localctx = new LogicalOpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_logicalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public static class SimpleExpressionContext extends ParserRuleContext {
		public LeftRightExprContext leftRightExpr() {
			return getRuleContext(LeftRightExprContext.class,0);
		}
		public BetweenExprContext betweenExpr() {
			return getRuleContext(BetweenExprContext.class,0);
		}
		public IsExprContext isExpr() {
			return getRuleContext(IsExprContext.class,0);
		}
		public InExprContext inExpr() {
			return getRuleContext(InExprContext.class,0);
		}
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitSimpleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitSimpleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleExpression);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				leftRightExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				betweenExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				isExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				inExpr();
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

	public static class LeftRightExprContext extends ParserRuleContext {
		public LeftElementContext leftElement() {
			return getRuleContext(LeftElementContext.class,0);
		}
		public RelationalOpContext relationalOp() {
			return getRuleContext(RelationalOpContext.class,0);
		}
		public RightElementContext rightElement() {
			return getRuleContext(RightElementContext.class,0);
		}
		public LeftRightExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftRightExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterLeftRightExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitLeftRightExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitLeftRightExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftRightExprContext leftRightExpr() throws RecognitionException {
		LeftRightExprContext _localctx = new LeftRightExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_leftRightExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			leftElement();
			setState(66);
			relationalOp();
			setState(67);
			rightElement();
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

	public static class BetweenExprContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public BetweenOpContext betweenOp() {
			return getRuleContext(BetweenOpContext.class,0);
		}
		public LeftElementContext leftElement() {
			return getRuleContext(LeftElementContext.class,0);
		}
		public BetweenAndContext betweenAnd() {
			return getRuleContext(BetweenAndContext.class,0);
		}
		public RightElementContext rightElement() {
			return getRuleContext(RightElementContext.class,0);
		}
		public NotOpContext notOp() {
			return getRuleContext(NotOpContext.class,0);
		}
		public BetweenExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterBetweenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitBetweenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitBetweenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenExprContext betweenExpr() throws RecognitionException {
		BetweenExprContext _localctx = new BetweenExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_betweenExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			columnName();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(70);
				notOp();
				}
			}

			setState(73);
			betweenOp();
			setState(74);
			leftElement();
			setState(75);
			betweenAnd();
			setState(76);
			rightElement();
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

	public static class IsExprContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public IsOpContext isOp() {
			return getRuleContext(IsOpContext.class,0);
		}
		public NullValContext nullVal() {
			return getRuleContext(NullValContext.class,0);
		}
		public NotOpContext notOp() {
			return getRuleContext(NotOpContext.class,0);
		}
		public IsExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterIsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitIsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitIsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsExprContext isExpr() throws RecognitionException {
		IsExprContext _localctx = new IsExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_isExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			columnName();
			setState(79);
			isOp();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(80);
				notOp();
				}
			}

			setState(83);
			nullVal();
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

	public static class InExprContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public InOpContext inOp() {
			return getRuleContext(InOpContext.class,0);
		}
		public List<InElementsContext> inElements() {
			return getRuleContexts(InElementsContext.class);
		}
		public InElementsContext inElements(int i) {
			return getRuleContext(InElementsContext.class,i);
		}
		public NotOpContext notOp() {
			return getRuleContext(NotOpContext.class,0);
		}
		public InExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitInExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitInExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InExprContext inExpr() throws RecognitionException {
		InExprContext _localctx = new InExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			columnName();
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(86);
				notOp();
				}
			}

			setState(89);
			inOp();
			setState(90);
			match(T__0);
			setState(91);
			inElements();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(92);
				match(T__1);
				setState(93);
				inElements();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(T__2);
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

	public static class InElementsContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public InElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterInElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitInElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitInElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InElementsContext inElements() throws RecognitionException {
		InElementsContext _localctx = new InElementsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inElements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__5:
			case T__6:
			case INT:
			case STRING:
			case FLOAT:
			case REAL:
				{
				setState(101);
				constant();
				}
				break;
			case T__0:
				{
				setState(102);
				match(T__0);
				setState(103);
				constant();
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(104);
					match(T__1);
					setState(105);
					constant();
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				match(T__2);
				}
				break;
			case T__1:
			case T__2:
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstantContext extends ParserRuleContext {
		public Token dollar;
		public TerminalNode STRING() { return getToken(SimpleQLangParser.STRING, 0); }
		public TerminalNode INT() { return getToken(SimpleQLangParser.INT, 0); }
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public TerminalNode REAL() { return getToken(SimpleQLangParser.REAL, 0); }
		public TerminalNode FLOAT() { return getToken(SimpleQLangParser.FLOAT, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constant);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5 || _la==T__6) {
					{
					setState(116);
					sign();
					}
				}

				setState(119);
				match(INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5 || _la==T__6) {
					{
					setState(120);
					sign();
					}
				}

				setState(123);
				_la = _input.LA(1);
				if ( !(_la==FLOAT || _la==REAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5 || _la==T__6) {
					{
					setState(124);
					sign();
					}
				}

				setState(127);
				((ConstantContext)_localctx).dollar = match(T__3);
				setState(128);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==FLOAT) ) {
				_errHandler.recoverInline(this);
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

	public static class LeftElementContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public LeftElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterLeftElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitLeftElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitLeftElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftElementContext leftElement() throws RecognitionException {
		LeftElementContext _localctx = new LeftElementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_leftElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			element();
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

	public static class RightElementContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public RightElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterRightElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitRightElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitRightElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightElementContext rightElement() throws RecognitionException {
		RightElementContext _localctx = new RightElementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rightElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			element();
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

	public static class ElementContext extends ParserRuleContext {
		public TerminalNode USER_VAR() { return getToken(SimpleQLangParser.USER_VAR, 0); }
		public TerminalNode ID() { return getToken(SimpleQLangParser.ID, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_element);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(USER_VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(137);
				match(T__4);
				setState(138);
				match(ID);
				setState(139);
				match(T__4);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				constant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				columnName();
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

	public static class SchemaNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleQLangParser.ID, 0); }
		public SchemaNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schemaName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterSchemaName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitSchemaName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitSchemaName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SchemaNameContext schemaName() throws RecognitionException {
		SchemaNameContext _localctx = new SchemaNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_schemaName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ID);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleQLangParser.ID, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(ID);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleQLangParser.ID, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(ID);
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

	public static class BetweenAndContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SimpleQLangParser.AND, 0); }
		public BetweenAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterBetweenAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitBetweenAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitBetweenAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenAndContext betweenAnd() throws RecognitionException {
		BetweenAndContext _localctx = new BetweenAndContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_betweenAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(AND);
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

	public static class NullValContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SimpleQLangParser.NULL, 0); }
		public NullValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterNullVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitNullVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitNullVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullValContext nullVal() throws RecognitionException {
		NullValContext _localctx = new NullValContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nullVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(NULL);
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

	public static class ColumnNameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(SimpleQLangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleQLangParser.DOT, i);
		}
		public SchemaNameContext schemaName() {
			return getRuleContext(SchemaNameContext.class,0);
		}
		public TerminalNode USER_VAR() { return getToken(SimpleQLangParser.USER_VAR, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_columnName);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(154);
						schemaName();
						setState(155);
						match(DOT);
						}
						break;
					}
					setState(159);
					tableName();
					setState(160);
					match(DOT);
					}
					break;
				}
				setState(164);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(165);
					tableName();
					setState(166);
					match(DOT);
					}
					break;
				}
				setState(170);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(USER_VAR);
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

	public static class RelationalOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SimpleQLangParser.EQ, 0); }
		public TerminalNode LTH() { return getToken(SimpleQLangParser.LTH, 0); }
		public TerminalNode GTH() { return getToken(SimpleQLangParser.GTH, 0); }
		public TerminalNode NOT_EQ() { return getToken(SimpleQLangParser.NOT_EQ, 0); }
		public TerminalNode LET() { return getToken(SimpleQLangParser.LET, 0); }
		public TerminalNode GET() { return getToken(SimpleQLangParser.GET, 0); }
		public RelationalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterRelationalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitRelationalOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitRelationalOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalOpContext relationalOp() throws RecognitionException {
		RelationalOpContext _localctx = new RelationalOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_relationalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LTH) | (1L << GTH) | (1L << NOT_EQ) | (1L << LET) | (1L << GET))) != 0)) ) {
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

	public static class NotOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SimpleQLangParser.NOT, 0); }
		public NotOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterNotOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitNotOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitNotOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotOpContext notOp() throws RecognitionException {
		NotOpContext _localctx = new NotOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_notOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(NOT);
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

	public static class IsOpContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(SimpleQLangParser.IS, 0); }
		public IsOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterIsOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitIsOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitIsOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsOpContext isOp() throws RecognitionException {
		IsOpContext _localctx = new IsOpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_isOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(IS);
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

	public static class BetweenOpContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(SimpleQLangParser.BETWEEN, 0); }
		public BetweenOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterBetweenOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitBetweenOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitBetweenOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenOpContext betweenOp() throws RecognitionException {
		BetweenOpContext _localctx = new BetweenOpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_betweenOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(BETWEEN);
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

	public static class InOpContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(SimpleQLangParser.IN, 0); }
		public InOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterInOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitInOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitInOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InOpContext inOp() throws RecognitionException {
		InOpContext _localctx = new InOpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_inOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(IN);
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

	public static class SignContext extends ParserRuleContext {
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleQLangListener ) ((SimpleQLangListener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleQLangVisitor ) return ((SimpleQLangVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u00bd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\3\3\3\3\4\3\4\3\4\3\4\5\4"+
		"B\n\4\3\5\3\5\3\5\3\5\3\6\3\6\5\6J\n\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\5\7T\n\7\3\7\3\7\3\b\3\b\5\bZ\n\b\3\b\3\b\3\b\3\b\3\b\7\ba\n\b\f\b\16"+
		"\bd\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tm\n\t\f\t\16\tp\13\t\3\t\3\t\5"+
		"\tt\n\t\3\n\3\n\5\nx\n\n\3\n\3\n\5\n|\n\n\3\n\3\n\5\n\u0080\n\n\3\n\3"+
		"\n\5\n\u0084\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0091"+
		"\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\5\23\u00a0\n\23\3\23\3\23\3\23\5\23\u00a5\n\23\3\23\3\23\3\23\3\23\5"+
		"\23\u00ab\n\23\3\23\3\23\5\23\u00af\n\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\2\2\32\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\2\7\3\2\n\13\3\2\35\36\4\2\22\22\35\35\3\2\23"+
		"\30\3\2\b\t\u00be\2\62\3\2\2\2\4;\3\2\2\2\6A\3\2\2\2\bC\3\2\2\2\nG\3\2"+
		"\2\2\fP\3\2\2\2\16W\3\2\2\2\20s\3\2\2\2\22\u0083\3\2\2\2\24\u0085\3\2"+
		"\2\2\26\u0087\3\2\2\2\30\u0090\3\2\2\2\32\u0092\3\2\2\2\34\u0094\3\2\2"+
		"\2\36\u0096\3\2\2\2 \u0098\3\2\2\2\"\u009a\3\2\2\2$\u00ae\3\2\2\2&\u00b0"+
		"\3\2\2\2(\u00b2\3\2\2\2*\u00b4\3\2\2\2,\u00b6\3\2\2\2.\u00b8\3\2\2\2\60"+
		"\u00ba\3\2\2\2\628\5\6\4\2\63\64\5\4\3\2\64\65\5\6\4\2\65\67\3\2\2\2\66"+
		"\63\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\3\3\2\2\2:8\3\2\2\2;<\t"+
		"\2\2\2<\5\3\2\2\2=B\5\b\5\2>B\5\n\6\2?B\5\f\7\2@B\5\16\b\2A=\3\2\2\2A"+
		">\3\2\2\2A?\3\2\2\2A@\3\2\2\2B\7\3\2\2\2CD\5\24\13\2DE\5&\24\2EF\5\26"+
		"\f\2F\t\3\2\2\2GI\5$\23\2HJ\5(\25\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\5"+
		",\27\2LM\5\24\13\2MN\5 \21\2NO\5\26\f\2O\13\3\2\2\2PQ\5$\23\2QS\5*\26"+
		"\2RT\5(\25\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\5\"\22\2V\r\3\2\2\2WY\5$"+
		"\23\2XZ\5(\25\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\5.\30\2\\]\7\3\2\2]b"+
		"\5\20\t\2^_\7\4\2\2_a\5\20\t\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2"+
		"ce\3\2\2\2db\3\2\2\2ef\7\5\2\2f\17\3\2\2\2gt\5\22\n\2hi\7\3\2\2in\5\22"+
		"\n\2jk\7\4\2\2km\5\22\n\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3"+
		"\2\2\2pn\3\2\2\2qr\7\5\2\2rt\3\2\2\2sg\3\2\2\2sh\3\2\2\2st\3\2\2\2t\21"+
		"\3\2\2\2u\u0084\7\34\2\2vx\5\60\31\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2y\u0084"+
		"\7\22\2\2z|\5\60\31\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\u0084\t\3\2\2~\u0080"+
		"\5\60\31\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\7\6\2\2\u0082\u0084\t\4\2\2\u0083u\3\2\2\2\u0083w\3\2\2\2\u0083{\3\2"+
		"\2\2\u0083\177\3\2\2\2\u0084\23\3\2\2\2\u0085\u0086\5\30\r\2\u0086\25"+
		"\3\2\2\2\u0087\u0088\5\30\r\2\u0088\27\3\2\2\2\u0089\u0091\7\32\2\2\u008a"+
		"\u0091\7\31\2\2\u008b\u008c\7\7\2\2\u008c\u008d\7\31\2\2\u008d\u0091\7"+
		"\7\2\2\u008e\u0091\5\22\n\2\u008f\u0091\5$\23\2\u0090\u0089\3\2\2\2\u0090"+
		"\u008a\3\2\2\2\u0090\u008b\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2"+
		"\2\2\u0091\31\3\2\2\2\u0092\u0093\7\31\2\2\u0093\33\3\2\2\2\u0094\u0095"+
		"\7\31\2\2\u0095\35\3\2\2\2\u0096\u0097\7\31\2\2\u0097\37\3\2\2\2\u0098"+
		"\u0099\7\n\2\2\u0099!\3\2\2\2\u009a\u009b\7\r\2\2\u009b#\3\2\2\2\u009c"+
		"\u009d\5\32\16\2\u009d\u009e\7\33\2\2\u009e\u00a0\3\2\2\2\u009f\u009c"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\5\34\17\2"+
		"\u00a2\u00a3\7\33\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009f\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00af\5\36\20\2\u00a7\u00a8\5\34\17"+
		"\2\u00a8\u00a9\7\33\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a7\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af\5\36\20\2\u00ad\u00af\7"+
		"\32\2\2\u00ae\u00a4\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af"+
		"%\3\2\2\2\u00b0\u00b1\t\5\2\2\u00b1\'\3\2\2\2\u00b2\u00b3\7\21\2\2\u00b3"+
		")\3\2\2\2\u00b4\u00b5\7\f\2\2\u00b5+\3\2\2\2\u00b6\u00b7\7\17\2\2\u00b7"+
		"-\3\2\2\2\u00b8\u00b9\7\20\2\2\u00b9/\3\2\2\2\u00ba\u00bb\t\6\2\2\u00bb"+
		"\61\3\2\2\2\238AISYbnsw{\177\u0083\u0090\u009f\u00a4\u00aa\u00ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}