package com.luxoft.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by MAblaiev on 26.01.2017.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class Column {
    private final String name;
    private final int seq;
    private final String type;

    public String quoted(String alias) {
        return alias == null || alias.isEmpty() ? "\"" + name + "\"" : alias + ".\"" + name + "\"";
    }

    public String quoted() {
        return quoted(null);
    }
}
