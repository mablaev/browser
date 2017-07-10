package com.luxoft.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by mablaev on 1/29/17.
 */
@Getter
@EqualsAndHashCode
public class TableName {
    private final String schema;
    private final String name;

    private TableName(String schema, String tableName) {
        this.schema = schema;
        if (tableName == null || tableName.isEmpty()) {
            throw new IllegalArgumentException("Table name could not be null.");
        }
        this.name = tableName;
    }

    public static TableName of(String schema, String tableName) {
        return new TableName(schema, tableName);
    }

    public String quoted(String alias) {
        StringBuilder builder = new StringBuilder();
        if (schema != null && !schema.isEmpty()) {
            builder.append("\"").append(schema).append("\".");
        }
        builder.append("\"").append(name).append("\"");
        if (alias != null && !alias.isEmpty()) {
            builder.append(" ").append(alias);
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return quoted(null);
    }

}
