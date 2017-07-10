package com.luxoft.parser;

import com.luxoft.antlr4.gen.SimpleQLangBaseVisitor;
import com.luxoft.antlr4.gen.SimpleQLangParser.*;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.tree.TerminalNode;

import static com.luxoft.parser.ExpressionVisitor.SPACE_SEPARATOR;

/**
 * Created by ma29379 on 2/10/2017.
 */
@AllArgsConstructor(staticName = "on")
public class BetweenVisitor extends SimpleQLangBaseVisitor<QueryAggregator> {

    private final QueryAggregator aggregator;

    @Override
    public QueryAggregator visitColumnName(ColumnNameContext ctx) {
        ColumnNameVisitor columnVisitor = ColumnNameVisitor.of();
        ctx.accept(columnVisitor);

        aggregator.acceptColumn(
                columnVisitor.getSchema(),
                columnVisitor.getTabName(),
                columnVisitor.getColumnName()
        );

        return aggregator;
    }

    @Override
    public QueryAggregator visitNotOp(NotOpContext ctx) {
        aggregator.append("NOT");
        return super.visitNotOp(ctx);
    }

    @Override
    public QueryAggregator visitBetweenOp(BetweenOpContext ctx) {
        aggregator.append("BETWEEN");
        return super.visitBetweenOp(ctx);
    }

    @Override
    public QueryAggregator visitConstant(ConstantContext ctx) {
        aggregator.append(ctx.getText());
        return super.visitConstant(ctx);
    }

    @Override
    public QueryAggregator visitBetweenAnd(BetweenAndContext ctx) {
        aggregator.append("AND");
        return super.visitBetweenAnd(ctx);
    }

    @Override
    public QueryAggregator visitTerminal(TerminalNode node) {
        aggregator.append(SPACE_SEPARATOR);
        return super.visitTerminal(node);
    }
}
