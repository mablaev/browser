// Generated from C:/Users/ma29379/workspace/svn/browser/src/main/resources\SimpleQLang.g4 by ANTLR 4.6
package com.luxoft.antlr4.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleQLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleQLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleQLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#logicalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOp(SimpleQLangParser.LogicalOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(SimpleQLangParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#leftRightExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftRightExpr(SimpleQLangParser.LeftRightExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#betweenExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenExpr(SimpleQLangParser.BetweenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#isExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsExpr(SimpleQLangParser.IsExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#inExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(SimpleQLangParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#inElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInElements(SimpleQLangParser.InElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(SimpleQLangParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#leftElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftElement(SimpleQLangParser.LeftElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#rightElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightElement(SimpleQLangParser.RightElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(SimpleQLangParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#schemaName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaName(SimpleQLangParser.SchemaNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(SimpleQLangParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(SimpleQLangParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#betweenAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenAnd(SimpleQLangParser.BetweenAndContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#nullVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullVal(SimpleQLangParser.NullValContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(SimpleQLangParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#relationalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalOp(SimpleQLangParser.RelationalOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#notOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOp(SimpleQLangParser.NotOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#isOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOp(SimpleQLangParser.IsOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#betweenOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenOp(SimpleQLangParser.BetweenOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#inOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInOp(SimpleQLangParser.InOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleQLangParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(SimpleQLangParser.SignContext ctx);
}