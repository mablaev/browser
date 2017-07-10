package com.luxoft.parser;

import com.luxoft.antlr4.gen.SimpleQLangBaseVisitor;
import com.luxoft.antlr4.gen.SimpleQLangParser.ColumnNameContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.InElementsContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.InOpContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.NotOpContext;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Arrays;
import java.util.List;

import static com.luxoft.parser.ExpressionVisitor.SPACE_SEPARATOR;

/**
 * Created by ma29379 on 2/10/2017.
 */
@AllArgsConstructor(staticName = "on")
public class InVisitor extends SimpleQLangBaseVisitor<QueryAggregator> {

    private static final List<String> BREAKING_NODES = Arrays.asList("(", ",", ")");

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
    public QueryAggregator visitNotOp(NotOpContext ctx) {
        aggregator.append("NOT");
        return super.visitNotOp(ctx);
    }

    @Override
    public QueryAggregator visitInOp(InOpContext ctx) {
        aggregator.append("IN");
        return super.visitInOp(ctx);
    }

    @Override
    public QueryAggregator visitInElements(InElementsContext ctx) {
        aggregator.append(ctx.getText());
        return aggregator;
    }

    @Override
    public QueryAggregator visitTerminal(TerminalNode node) {
        if(BREAKING_NODES.contains(node.getText())) {
            aggregator.append(node.getText());
        }else {
            aggregator.append(SPACE_SEPARATOR);
        }
        return super.visitTerminal(node);
    }
}
