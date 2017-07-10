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
@AllArgsConstructor
public class ForeignKey {

    private final String keyName;
    private final TableName tableName;
    private final Set<String> columnNames;

    private final PrimaryKey referencedKey;

//    public static ForeignKey on(String keyName, TableName tableName, Set<String> columnNames
//            , String refKeyName, TableName refTableName, Set<String> refColumnNames) {
//
//        PrimaryKey refPk = PrimaryKey.on(refKeyName, refTableName, refColumnNames);
//        return on(keyName, tableName, columnNames, refPk);
//    }

    public static ForeignKey of(String keyName, TableName tableName, Collection<String> columnNames, PrimaryKey referencedKey) {
        return new ForeignKey(keyName, tableName, new HashSet<>(columnNames), referencedKey);
    }

    public boolean isHierarchicalReference() {
        return tableName.equals(referencedKey.getTableName());
    }
}
