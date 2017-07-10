package com.luxoft.parser;

import com.codepoetics.protonpack.StreamUtils;
import com.luxoft.domain.Column;
import com.luxoft.domain.ForeignKey;
import com.luxoft.domain.Table;
import com.luxoft.meta.Metadata;
import com.luxoft.meta.PathFinder;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by ma29379 on 2/1/2017.
 */
@Getter
@ToString(exclude = {"fromTable", "joinTables"})
public class Query {

    private final static String NEW_LINE = "\n";
    private final static String TABLE_ALIAS = "t";

    private Table fromTable;
    private Set<Table> joinTables = new LinkedHashSet<>();
    private StringBuilder whereCondition = new StringBuilder();
    private Map<String, String> tableAliases = new HashMap<>();

    public void addTable(Table table) {
        if (fromTable == null) {
            fromTable = table;
        } else if (!fromTable.equals(table)) {
            joinTables.add(table);
        }
        tableAliases.put(table.getName(), TABLE_ALIAS + joinTables.size());
    }

    public void appendToWhere(String value) {
        whereCondition.append(value);
    }

    public void appendToWhere(String tableName, Column column) {
        whereCondition.append(column.quoted(tableAliases.get(tableName))).append(" ");
    }

    public void acceptRelationalOp(RelationalOp relOp) {
        whereCondition.append(relOp);
    }

    public void addLogicalOperation(LogicalOp logicalOp) {
        whereCondition.append(logicalOp);
    }

    public SqlBuilder on(Metadata metadata) {
        return new SqlBuilder(metadata);
    }

    public class SqlBuilder {

        private final PathFinder pathFinder;

        public SqlBuilder(Metadata metadata) {
            this.pathFinder = new PathFinder(metadata);
        }

        public String buildSql() {

            StringBuilder sql = new StringBuilder("SELECT * FROM ")
                    .append(aliased(fromTable)).append(NEW_LINE)
                    .append(buildJoins(joinTables))
                    .append("WHERE ").append(whereCondition);

            return sql.toString().trim();
        }

        private String buildJoins(Set<Table> joinTables) {

            StringBuilder result = new StringBuilder();

            Set<Table> startPoints = new LinkedHashSet<>();
            startPoints.add(fromTable);

            for (Table currentJoinTable : joinTables) {

                startPoints.addAll(joinTables);
                startPoints.remove(currentJoinTable);

                List<Table> joinPath = pathFinder.findShortestJoinPath(startPoints, currentJoinTable);
                startPoints.addAll(joinPath);

                for (int i = 0; i < joinPath.size() - 1; i++) {

                    Table tab1 = joinPath.get(i);
                    Table tab2 = joinPath.get(i + 1);

                    result.append(buildAdjacentJoin(tab1, tab2));
                }
            }
            return result.toString();
        }

        private String buildAdjacentJoin(Table tab1, Table tab2) {
            StringBuilder builder = new StringBuilder("LEFT JOIN ");

            builder.append(aliased(tab2))
                    .append(" ON ")
                    .append(joinCondition(tab1, tab2))
                    .append(NEW_LINE);

            return builder.toString();
        }

        private String joinCondition(Table table1, Table table2) {

            if(!table1.isDirectlyDependsFrom(table2) && !table2.isDirectlyDependsFrom(table1)){
                throw new UnsupportedOperationException("Cannot join " + table1.getName() +
                        " and table " + table2.getName() +
                        " b/c there is no FK relationship between them.");
            }

            ForeignKey foreignKey = table1.isDirectlyDependsFrom(table2) ? table1.getDependantFk(table2) : table2.getDependantFk(table1);

            Stream<Column> tab1Cols = foreignKey.getReferencedKey().getColumnNames().stream()
                    .map(table1::requireColumn);

            Stream<Column> tab2Cols = foreignKey.getColumnNames().stream()
                    .map(table2::requireColumn);

            String tab1Alias = tableAliases.get(table1.getName());
            String tab2Alias = tableAliases.get(table2.getName());

            BiFunction<Column, Column, String> eqZipFunc = (col1, col2) -> col1.quoted(tab1Alias) + " = " + col2.quoted(tab2Alias);

            String joinCondition = StreamUtils
                    .zip(tab1Cols, tab2Cols, eqZipFunc)
                    .collect(joining(" AND "));

            return joinCondition;
        }

        private String aliased(Table table) {
            String alias = tableAliases.get(table.getName());
            return table.getTableName().quoted(alias);
        }

    }

}