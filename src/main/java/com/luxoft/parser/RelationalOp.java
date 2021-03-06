package com.luxoft.parser;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by ma29379 on 2/8/2017.
 */
public enum RelationalOp {

    EQ("="), LTH("<"), GTH(">"), NOT_EQ("!=", "<>"), LET("<="), GET(">=");

    private final String sqlVal;
    private final Set<String> values = new HashSet<>();

    private RelationalOp(String sqlVal, String... values) {
        this.sqlVal = sqlVal;
        this.values.add(sqlVal);
        this.values.addAll(asList(values));
    }

    public static RelationalOp of(String val) {
        return Stream.of(values())
                .filter(o -> o.values.contains(val))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return sqlVal;
    }
}
