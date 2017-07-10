package com.luxoft.parser;

import com.luxoft.antlr4.gen.SimpleQLangBaseVisitor;
import com.luxoft.antlr4.gen.SimpleQLangParser.*;
import com.luxoft.meta.Metadata;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by ma29379 on 2/8/2017.
 */
public class ExpressionVisitor extends SimpleQLangBaseVisitor<Query> {

    public static final String SPACE_SEPARATOR = " ";

    private final QueryAggregator aggregator;

    public ExpressionVisitor(Metadata metadata) {
        this.aggregator = QueryAggregator.on(metadata);
    }

    @Override
    public Query visitSimpleExpression(SimpleExpressionContext ctx) {
        super.visitSimpleExpression(ctx);
        return aggregator.getQuery();
    }

    @Override
    public Query visitLeftRightExpr(LeftRightExprContext ctx) {
        ctx.accept(LeftRightVisitor.on(aggregator));
        return aggregator.getQuery();
    }

    @Override
    public Query visitInExpr(InExprContext ctx) {
        ctx.accept(InVisitor.on(aggregator));
        aggregator.append(SPACE_SEPARATOR);
        return aggregator.getQuery();
    }

    @Override
    public Query visitBetweenExpr(BetweenExprContext ctx) {
        ctx.accept(BetweenVisitor.on(aggregator));
        return aggregator.getQuery();
    }

    @Override
    public Query visitIsExpr(IsExprContext ctx) {
        ctx.accept(IsVisitor.on(aggregator));
        return aggregator.getQuery();
    }

    @Override
    public Query visitLogicalOp(LogicalOpContext ctx) {
        aggregator.bindNextPredicateWith(LogicalOp.of(ctx.getText()));
        return super.visitLogicalOp(ctx);
    }

    @Override
    public Query visitTerminal(TerminalNode node) {
        aggregator.append(SPACE_SEPARATOR);
        return aggregator.getQuery();
    }

    @Override
    public Query visitErrorNode(ErrorNode node) {
        System.out.println("Error node " + node.getText());
        return super.visitErrorNode(node);
    }
}
