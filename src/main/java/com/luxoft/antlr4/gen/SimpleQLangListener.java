// Generated from C:/Users/ma29379/workspace/svn/browser/src/main/resources\SimpleQLang.g4 by ANTLR 4.6
package com.luxoft.antlr4.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleQLangParser}.
 */
public interface SimpleQLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleQLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleQLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOp(SimpleQLangParser.LogicalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#logicalOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOp(SimpleQLangParser.LogicalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(SimpleQLangParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(SimpleQLangParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#leftRightExpr}.
	 * @param ctx the parse tree
	 */
	void enterLeftRightExpr(SimpleQLangParser.LeftRightExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#leftRightExpr}.
	 * @param ctx the parse tree
	 */
	void exitLeftRightExpr(SimpleQLangParser.LeftRightExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#betweenExpr}.
	 * @param ctx the parse tree
	 */
	void enterBetweenExpr(SimpleQLangParser.BetweenExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#betweenExpr}.
	 * @param ctx the parse tree
	 */
	void exitBetweenExpr(SimpleQLangParser.BetweenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#isExpr}.
	 * @param ctx the parse tree
	 */
	void enterIsExpr(SimpleQLangParser.IsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#isExpr}.
	 * @param ctx the parse tree
	 */
	void exitIsExpr(SimpleQLangParser.IsExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#inExpr}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(SimpleQLangParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#inExpr}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(SimpleQLangParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#inElements}.
	 * @param ctx the parse tree
	 */
	void enterInElements(SimpleQLangParser.InElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#inElements}.
	 * @param ctx the parse tree
	 */
	void exitInElements(SimpleQLangParser.InElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SimpleQLangParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SimpleQLangParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#leftElement}.
	 * @param ctx the parse tree
	 */
	void enterLeftElement(SimpleQLangParser.LeftElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#leftElement}.
	 * @param ctx the parse tree
	 */
	void exitLeftElement(SimpleQLangParser.LeftElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#rightElement}.
	 * @param ctx the parse tree
	 */
	void enterRightElement(SimpleQLangParser.RightElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#rightElement}.
	 * @param ctx the parse tree
	 */
	void exitRightElement(SimpleQLangParser.RightElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(SimpleQLangParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(SimpleQLangParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void enterSchemaName(SimpleQLangParser.SchemaNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#schemaName}.
	 * @param ctx the parse tree
	 */
	void exitSchemaName(SimpleQLangParser.SchemaNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SimpleQLangParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SimpleQLangParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(SimpleQLangParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(SimpleQLangParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#betweenAnd}.
	 * @param ctx the parse tree
	 */
	void enterBetweenAnd(SimpleQLangParser.BetweenAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#betweenAnd}.
	 * @param ctx the parse tree
	 */
	void exitBetweenAnd(SimpleQLangParser.BetweenAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#nullVal}.
	 * @param ctx the parse tree
	 */
	void enterNullVal(SimpleQLangParser.NullValContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#nullVal}.
	 * @param ctx the parse tree
	 */
	void exitNullVal(SimpleQLangParser.NullValContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(SimpleQLangParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(SimpleQLangParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOp(SimpleQLangParser.RelationalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOp(SimpleQLangParser.RelationalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#notOp}.
	 * @param ctx the parse tree
	 */
	void enterNotOp(SimpleQLangParser.NotOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#notOp}.
	 * @param ctx the parse tree
	 */
	void exitNotOp(SimpleQLangParser.NotOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#isOp}.
	 * @param ctx the parse tree
	 */
	void enterIsOp(SimpleQLangParser.IsOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#isOp}.
	 * @param ctx the parse tree
	 */
	void exitIsOp(SimpleQLangParser.IsOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#betweenOp}.
	 * @param ctx the parse tree
	 */
	void enterBetweenOp(SimpleQLangParser.BetweenOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#betweenOp}.
	 * @param ctx the parse tree
	 */
	void exitBetweenOp(SimpleQLangParser.BetweenOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#inOp}.
	 * @param ctx the parse tree
	 */
	void enterInOp(SimpleQLangParser.InOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#inOp}.
	 * @param ctx the parse tree
	 */
	void exitInOp(SimpleQLangParser.InOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleQLangParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(SimpleQLangParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleQLangParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(SimpleQLangParser.SignContext ctx);
}