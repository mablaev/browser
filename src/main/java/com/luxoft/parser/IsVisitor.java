package com.luxoft.parser;

import com.luxoft.antlr4.gen.SimpleQLangBaseVisitor;
import com.luxoft.antlr4.gen.SimpleQLangParser.ColumnNameContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.IsOpContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.NotOpContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.NullValContext;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.tree.TerminalNode;

import static com.luxoft.parser.ExpressionVisitor.SPACE_SEPARATOR;

/**
 * Created by ma29379 on 2/10/2017.
 */

@AllArgsConstructor(staticName = "on")
public class IsVisitor extends SimpleQLangBaseVisitor<QueryAggregator> {

    private QueryAggregator aggregator;

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
    public QueryAggregator visitIsOp(IsOpContext ctx) {
        aggregator.append("IS");
        return super.visitIsOp(ctx);
    }


    @Override
    public QueryAggregator visitNotOp(NotOpContext ctx) {
        aggregator.append("NOT");
        return super.visitNotOp(ctx);
    }

    @Override
    public QueryAggregator visitNullVal(NullValContext ctx) {
        aggregator.append("NULL");
        return super.visitNullVal(ctx);
    }

    @Override
    public QueryAggregator visitTerminal(TerminalNode node) {
        aggregator.append(SPACE_SEPARATOR);
        return super.visitTerminal(node);
    }
}
