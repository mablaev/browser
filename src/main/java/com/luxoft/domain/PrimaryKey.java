package com.luxoft.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mablaev on 1/29/17.
 */
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class PrimaryKey {
    private final String keyName;
    private final TableName tableName;
    private final Set<String> columnNames;

    public static PrimaryKey of(String keyName, TableName tableName, Collection<String> columns) {
        return of(keyName, tableName, new HashSet<String>(columns));
    }
}
