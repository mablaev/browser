package com.luxoft.dao;

import com.luxoft.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import static java.util.Collections.unmodifiableSet;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * Created by mablaev on 2/4/17.
 */

public class NewTableExtractor {
    private static final Logger logger = LoggerFactory.getLogger(NewTableExtractor.class);

    private JdbcTemplate template;
    private String schema;

    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Map<String, Table> extraAllTables() {
        Map<String, Table> metaData = findAllTables().stream().collect(toMap(Table::getName, identity()));

        loadPrimaryKeys(metaData);
        loadForeignKeys(metaData);

        return metaData;
    }

    private void loadForeignKeys(Map<String, Table> metaData) {
        logger.info("Loading all foreign keys...");

        String sql = "SELECT a.owner child_owner" +
                ", a.table_name child_table" +
                ", a.column_name child_column" +
                ", a.constraint_name child_constraint" +
                ", a.position child_column_position\n" +
                ", b.owner parent_owner" +
                ", b.table_name parent_table" +
                ", b.column_name parent_column" +
                ", b.constraint_name parent_constraint" +
                ", b.POSITION parent_column_position\n" +
                " FROM all_cons_columns a\n" +
                " JOIN all_constraints c ON a.owner = c.owner AND a.constraint_name = c.constraint_name\n" +
                " JOIN all_cons_columns b ON c.owner = b.owner AND c.r_constraint_name = b.constraint_name\n" +
                " WHERE c.constraint_type = 'R' AND a.position = b.position\n" +
                " AND a.owner = ?\n" +
                " ORDER BY a.owner, a.table_name, a.constraint_name, a.position";

        Map<String, String> prevRow = new TreeMap<>(String::compareToIgnoreCase);
        Set<String> fkColumns = new LinkedHashSet<>();
        Set<String> refPkColumns = new LinkedHashSet<>();

        template.query(sql, new Object[]{schema}, rs -> {

            String currentTabName = rs.getString("child_table");
            String currentFkName = rs.getString("child_constraint");

            if (!prevRow.isEmpty() && (!currentTabName.equalsIgnoreCase(prevRow.get("child_table"))
                    || !currentFkName.equalsIgnoreCase(prevRow.get("child_constraint")))) {

                extractForeignKey(metaData, prevRow, fkColumns, refPkColumns);

                fkColumns.clear();
                refPkColumns.clear();
            }

            extractRow(rs, prevRow);

            refPkColumns.add(rs.getString("parent_column"));
            fkColumns.add(rs.getString("child_column"));
        });

        if (!prevRow.isEmpty()) {
            extractForeignKey(metaData, prevRow, fkColumns, refPkColumns);
        }
    }

    private static void extractForeignKey(Map<String, Table> metaData, Map<String, String> row, Set<String> fkColumns, Set<String> refPkColumns) {

        ForeignKey childFk = createFk(row, copyOf(refPkColumns), copyOf(fkColumns));
        Table childTable = metaData.get(row.get("child_table"));
        childTable.addForeignKey(childFk);

//        ForeignKey parentFk = createExportedFk(row, copyOf(fkColumns), childFk.getReferencedKey());
//        Table parentTable = metaData.get(row.get("parent_table"));
//        parentTable.addExportedKey(parentFk);
    }

//    private static ForeignKey createExportedFk(Map<String, String> row, Set<String> fkColumns, PrimaryKey refPk) {
//        TableName childTableName = TableName.of(row.get("child_owner"), row.get("child_table"));
//
//        return ForeignKey.of(row.get("child_constraint"), childTableName, fkColumns, refPk);
//    }

    private static ForeignKey createFk(Map<String, String> row, Set<String> refPkColumns, Set<String> fkColumns) {
        TableName refTabName = TableName.of(row.get("parent_owner"), row.get("parent_table"));
        PrimaryKey refPk = PrimaryKey.of(row.get("parent_constraint"), refTabName, refPkColumns);

        TableName fkTableName = TableName.of(row.get("child_owner"), row.get("child_table"));
        return ForeignKey.of(row.get("child_constraint"), fkTableName, fkColumns, refPk);
    }

    private static <T> Set<T> copyOf(Collection<T> set) {
        return unmodifiableSet(new LinkedHashSet<>(set));
    }

    private static void extractRow(ResultSet rs, Map<String, String> row) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            row.put(meta.getColumnName(i), rs.getString(i));
        }
    }

    private Set<Table> findAllTables() {
        logger.info("Loading all table and column names from {}...", schema);

        String sql = "SELECT * FROM all_tab_columns" +
                " WHERE OWNER = ?\n" +
                " ORDER BY table_name, column_id";

        Set<Table> result = new HashSet<>();
        Map<String, String> prevRow = new TreeMap<>(String::compareToIgnoreCase);
        Set<Column> columns = new LinkedHashSet<>();

        template.query(sql, new Object[]{schema}, rs -> {
            String currentTabName = rs.getString("TABLE_NAME");

            if (!prevRow.isEmpty() && !currentTabName.equalsIgnoreCase(prevRow.get("TABLE_NAME"))) {
                Table table = extractTable(prevRow, copyOf(columns));
                result.add(table);

                columns.clear();
            }

            extractRow(rs, prevRow);

            columns.add(Column.of(rs.getString("COLUMN_NAME"), rs.getInt("COLUMN_ID"), rs.getString("DATA_TYPE")));
        });

        if (!prevRow.isEmpty()) {
            Table table = extractTable(prevRow, copyOf(columns));
            result.add(table);
        }

        return result;
    }

    private static Table extractTable(Map<String, String> row, Set<Column> columns) {
        Table table = new Table();
        table.setTableName(TableName.of(row.get("OWNER"), row.get("TABLE_NAME")));
        table.setColumns(columns);
        return table;
    }

    private void loadPrimaryKeys(Map<String, Table> allTables) {
        logger.info("Loading all primary keys...");

        String sql = "SELECT cols.table_name, cols.column_name, cons.constraint_name," +
                " cols.position, cons.status, cons.owner\n" +
                " FROM all_constraints cons, all_cons_columns cols\n" +
                " WHERE cons.constraint_type = 'P'\n" +
                " AND cons.constraint_name = cols.constraint_name\n" +
                " AND cons.owner = cols.owner\n" +
                " AND cons.owner = ?\n" +
                " AND cols.table_name NOT LIKE '%$%'\n" +
                " ORDER BY cols.table_name, cols.position";

        Map<String, String> prevRow = new TreeMap<>(String::compareToIgnoreCase);
        Set<String> pkColumns = new LinkedHashSet<>();

        template.query(sql, new Object[]{schema}, rs -> {
            String curTabName = rs.getString("table_name");
            String curPkName = rs.getString("constraint_name");

            if (!prevRow.isEmpty() && (!curTabName.equalsIgnoreCase(prevRow.get("table_name"))
                    || !curPkName.equalsIgnoreCase(prevRow.get("constraint_name")))) {

                extractPk(allTables, prevRow, copyOf(pkColumns));

                pkColumns.clear();
            }

            extractRow(rs, prevRow);
            pkColumns.add(rs.getString("column_name"));
        });

        if (!prevRow.isEmpty()) {
            extractPk(allTables, prevRow, pkColumns);
        }
    }

    private static void extractPk(Map<String, Table> allTables, Map<String, String> row, Set<String> pkColumns) {
        TableName pkTabName = TableName.of(row.get("owner"), row.get("table_name"));
        PrimaryKey pk = PrimaryKey.of(row.get("constraint_name"), pkTabName, pkColumns);

        Table table = allTables.get(row.get("table_name"));
        table.setPrimaryKey(pk);
    }
}
