package com.luxoft.parser;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by ma29379 on 2/8/2017.
 */
public enum LogicalOp {

    AND("AND", "&&"), OR("OR", "||");
    private final String sqlValue;
    private final Set<String> values = new HashSet<>();

    private LogicalOp(String sqlVal, String... values) {
        this.sqlValue = sqlVal;
        this.values.add(sqlVal);
        this.values.addAll(asList(values));
    }

    public static LogicalOp of(String val) {
        return Stream.of(values())
                .filter(o -> o.values.contains(val.toUpperCase()))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return sqlValue;
    }
}
