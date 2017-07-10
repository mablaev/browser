package com.luxoft.domain;

import com.luxoft.utils.ConversionUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * Created by MAblaiev on 26.01.2017.
 */
@ToString(of = {"tableName", "primaryKey", "foreignKeys"})
@EqualsAndHashCode
public final class Table {

    @Getter
    @Setter
    private TableName tableName;

    private Map<String, Column> columns;

    @Getter
    @Setter
    private PrimaryKey primaryKey;

    @Getter
    @Setter
    private Set<ForeignKey> foreignKeys = new LinkedHashSet<>();

//    @Getter
//    @Setter
//    private Set<ForeignKey> exportedKeys = new LinkedHashSet<>();

    public static Table of(TableName tableName, Set<Column> columns, PrimaryKey primaryKey, Set<ForeignKey> foreignKeys) {
        Table table = new Table();
        table.tableName = tableName;
        table.primaryKey = primaryKey;
        table.foreignKeys = foreignKeys;
//        table.exportedKeys = exportedKeys;
        table.setColumns(columns);
        return table;
    }

    public String getName() {
        return tableName.getName();
    }

    public boolean isDirectlyDependsFrom(Table table) {
        return foreignKeys.stream()
                .filter(fk -> table.getTableName().equals(fk.getReferencedKey().getTableName()))
                .findFirst()
                .isPresent();
    }

    public Set<String> getColumnNames(){
        return columns.keySet();
    }

    public Set<Column> getColumns(){
        return new LinkedHashSet<>(columns.values());
    }

    public final void setColumns(Collection<Column> columns){
        this.columns = columns.stream().collect(toMap(Column::getName, identity()));
    }

    public ForeignKey getDependantFk(Table table) {

        ForeignKey foreignKey = foreignKeys.stream()
                .filter(fk -> table.getTableName().equals(fk.getReferencedKey().getTableName()))
                .findFirst()
                .get();

        return foreignKey;
    }



    public void addForeignKey(ForeignKey fk) {
        this.foreignKeys.add(fk);
    }

//    public void addExportedKey(ForeignKey fk) {
//        this.exportedKeys.add(fk);
//    }

    public Column requireColumn(String columnName) {
        //try to find using all possible name conversions
        Optional<Column> column = ConversionUtils.tryToMatch(columnName, columns::get);
        return column.orElseThrow(() -> new NoSuchElementException("Column with name " + columnName + " was not found."));
    }

}
