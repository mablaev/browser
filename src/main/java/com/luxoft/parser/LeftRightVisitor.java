package com.luxoft.parser;

import com.luxoft.antlr4.gen.SimpleQLangBaseVisitor;
import com.luxoft.antlr4.gen.SimpleQLangParser;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.tree.TerminalNode;

import static com.luxoft.parser.ExpressionVisitor.SPACE_SEPARATOR;

/**
 * Created by ma29379 on 2/10/2017.
 */
@AllArgsConstructor(staticName = "on")
public class LeftRightVisitor extends SimpleQLangBaseVisitor<QueryAggregator> {

    private final QueryAggregator aggregator;

    @Override
    public QueryAggregator visitColumnName(SimpleQLangParser.ColumnNameContext ctx) {
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
    public QueryAggregator visitRelationalOp(SimpleQLangParser.RelationalOpContext ctx) {
        aggregator.acceptRelationalOp(RelationalOp.of(ctx.getText()));
        return super.visitRelationalOp(ctx);
    }

    @Override
    public QueryAggregator visitConstant(SimpleQLangParser.ConstantContext ctx) {
        aggregator.append(ctx.getText());
        return aggregator;
    }

    @Override
    public QueryAggregator visitTerminal(TerminalNode node) {
        aggregator.append(SPACE_SEPARATOR);
        return super.visitTerminal(node);
    }
}
