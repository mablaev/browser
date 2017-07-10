package com.luxoft.parser;

import com.luxoft.antlr4.gen.SimpleQLangBaseVisitor;
import com.luxoft.antlr4.gen.SimpleQLangParser.NameContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.SchemaNameContext;
import com.luxoft.antlr4.gen.SimpleQLangParser.TableNameContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by mablaev on 1/29/17.
 */
@Getter
@RequiredArgsConstructor(staticName = "of")
public class ColumnNameVisitor extends SimpleQLangBaseVisitor<String> {

    private String schema;
    private String tabName;
    private String columnName;

    @Override
    public String visitSchemaName(SchemaNameContext ctx) {
        schema = ctx.getText();
        return super.visitSchemaName(ctx);
    }

    @Override
    public String visitTableName(TableNameContext ctx) {
        tabName = ctx.getText();
        return super.visitTableName(ctx);
    }

    @Override
    public String visitName(NameContext ctx) {
        columnName = ctx.getText();
        return super.visitName(ctx);
    }
}
