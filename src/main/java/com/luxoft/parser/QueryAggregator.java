package com.luxoft.parser;

import com.luxoft.domain.Column;
import com.luxoft.domain.Table;
import com.luxoft.meta.Metadata;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by ma29379 on 2/9/2017.
 */
@ToString(exclude = "metadata")
public class QueryAggregator {

    @Getter
    private final Query query = new Query();

    private final Metadata metadata;

    private QueryAggregator(Metadata metadata) {
        this.metadata = metadata;
    }

    public static QueryAggregator on(Metadata metadata) {
        return new QueryAggregator(metadata);
    }

    public QueryAggregator acceptColumn(String schema, String tabName, String columnName) {
        Table table = metadata.requireTable(tabName);
        query.addTable(table);

        Column column = table.requireColumn(columnName);
        query.appendToWhere(table.getName(), column);

        return this;
    }

    public QueryAggregator append(String value) {
        query.appendToWhere(value);
        return this;
    }

    public QueryAggregator acceptRelationalOp(RelationalOp relOp) {
        query.acceptRelationalOp(relOp);
        return this;
    }

    public QueryAggregator bindNextPredicateWith(LogicalOp logOp) {
        query.addLogicalOperation(logOp);
        return this;
    }


//    public QueryAggregator acceptColumn(TableName tabName, String colName) {
//        Table table = metadata.requireTable(tabName);
//        query.addTable(table);
//
//        Column column = table.requireColumn(colName);
//        query.appendToWhere(table.getName(), column);
//
//        return this;
//    }
}
