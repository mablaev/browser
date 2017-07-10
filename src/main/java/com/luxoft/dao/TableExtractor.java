package com.luxoft.dao;

import com.luxoft.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by mablaev on 1/29/17.
 */
public class TableExtractor {
    private static final Logger logger = LoggerFactory.getLogger(TableExtractor.class);

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Set<Table> extractAllTablesFrom(String schema) throws SQLException {
        logger.info("Extracting metadata for all tables in schema {} started", schema);
        try {
            try (Connection conn = dataSource.getConnection()) {
                Set<TableName> allTableNames = extractAllTableNames(conn, schema);
                return allTableNames.stream()
                        .map(tabName -> extractTable(conn, tabName))
                        .collect(Collectors.toSet());
            }
        } finally {
            logger.info("Extracting on all tables for schema {} is finished.", schema);
        }
    }

    private Set<TableName> extractAllTableNames(Connection conn, String schema) throws SQLException {
        logger.info("Scanning schema {} started", schema);

        String sql = "SELECT owner, table_name FROM all_tables WHERE owner = ?";
        Set<TableName> tableNames = new LinkedHashSet<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schema);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tableNames.add(TableName.of(schema, rs.getString("table_name")));
                }
            }
            return tableNames;
        } finally {
            logger.info("Scanning schema {} finished. Found {} tables.", schema, tableNames.size());
        }
    }

    public Set<Table> extractTables(TableName... tableNames) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            return Stream.of(tableNames)
                    .map(tabName -> extractTable(conn, tabName))
                    .collect(Collectors.toSet());
        }
    }

    private Table extractTable(Connection conn, TableName tableName) {
        logger.info("Extracting metadata for {}...", tableName);
        try {
            Set<Column> columns = getColumns(conn, tableName);
            PrimaryKey primaryKey = getPrimaryKey(conn, tableName);

            Set<ForeignKey> exportedKeys = new LinkedHashSet<>();//getExportedKeys(conn, tableName);
            Set<ForeignKey> importedKeys = getImportedKeys(conn, tableName);

            return Table.of(tableName, columns, primaryKey, importedKeys);
        } catch (SQLException e) {
            throw new IllegalStateException("Error was thrown during retrieving metadata from DB", e);
        }
    }

    private static Set<ForeignKey> getImportedKeys(Connection connection, TableName tableName) throws SQLException {
        Set<ForeignKey> fkKeys = new LinkedHashSet<>();

        try (ResultSet rs = connection.getMetaData().getImportedKeys(null, tableName.getSchema(), tableName.getName())) {
            Set<String> pkColumns = new LinkedHashSet<>();
            Set<String> fkColumns = new LinkedHashSet<>();
            Map<String, String> prevRow = new HashMap<>();

            while (rs.next()) {
                String curFkName = rs.getString("FK_NAME");

                if (!prevRow.isEmpty() && !curFkName.equals(prevRow.get("FK_NAME"))) {
                    fkKeys.add(newFkFrom(fkColumns, pkColumns, prevRow));

                    pkColumns = new LinkedHashSet<>();
                    fkColumns = new LinkedHashSet<>();
                }
                prevRow = extractRow(rs);

                fkColumns.add(rs.getString("FKCOLUMN_NAME"));
                pkColumns.add(rs.getString("PKCOLUMN_NAME"));
            }

            if (!fkColumns.isEmpty() && !pkColumns.isEmpty()) {
                fkKeys.add(newFkFrom(fkColumns, pkColumns, prevRow));
            }

        }
        return fkKeys;
    }


    private static ForeignKey newFkFrom(Set<String> fkColumns, Set<String> pkColumns, Map<String, String> prevRow) {
        TableName refTableName = TableName.of(prevRow.get("PKTABLE_SCHEM"), prevRow.get("PKTABLE_NAME"));
        PrimaryKey refPk = PrimaryKey.of(prevRow.get("PK_NAME"), refTableName, pkColumns);

        TableName curFkTableName = TableName.of(prevRow.get("FKTABLE_SCHEM"), prevRow.get("FKTABLE_NAME"));
        return ForeignKey.of(prevRow.get("FK_NAME"), curFkTableName, fkColumns, refPk);
    }

    private static Set<ForeignKey> getExportedKeys(Connection conn, TableName tableName) throws SQLException {

        Set<String> pkColumns = new LinkedHashSet<>();
        Set<String> fkColumns = new LinkedHashSet<>();
        Set<ForeignKey> fkKeys = new LinkedHashSet<>();

        Map<String, String> prevRow = new HashMap<>();

        try (ResultSet rs = conn.getMetaData().getExportedKeys(null, tableName.getSchema(), tableName.getName())) {
            while (rs.next()) {
                String curFkName = rs.getString("FK_NAME");

                if (!prevRow.isEmpty() && !curFkName.equals(prevRow.get("FK_NAME"))) {
                    fkKeys.add(newFkFrom(fkColumns, pkColumns, prevRow));

                    pkColumns = new LinkedHashSet<>();
                    fkColumns = new LinkedHashSet<>();
                }
                prevRow = extractRow(rs);

                fkColumns.add(rs.getString("FKCOLUMN_NAME"));
                pkColumns.add(rs.getString("PKCOLUMN_NAME"));
            }
        }

        if (!fkColumns.isEmpty() && !pkColumns.isEmpty()) {
            fkKeys.add(newFkFrom(fkColumns, pkColumns, prevRow));
        }
        return fkKeys;
    }

    private static Map<String, String> extractRow(ResultSet rs) throws SQLException {
        Map<String, String> result = new TreeMap<>(String::compareToIgnoreCase);
        ResultSetMetaData meta = rs.getMetaData();
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            result.put(meta.getColumnName(i), rs.getString(i));
        }
        return result;
    }


    private Set<Column> getColumns(Connection conn, TableName tableName) throws SQLException {
        Set<Column> columns = new TreeSet<>(comparing(Column::getSeq));

        try (ResultSet rs = conn.getMetaData().getColumns(null, tableName.getSchema(), tableName.getName(), null)) {
            while (rs.next()) {
                String name = rs.getString("COLUMN_NAME");
                int seq = rs.getInt("ORDINAL_POSITION");
                int type = rs.getInt("DATA_TYPE");

                columns.add(Column.of(name, seq, Integer.toString(type)));
            }
            return columns;
        }
    }

    private PrimaryKey getPrimaryKey(Connection conn, TableName tableName) throws SQLException {
        Map<Integer, String> columns = new TreeMap<>();
        String keyName = null;
        try (ResultSet rs = conn.getMetaData().getPrimaryKeys(null, tableName.getSchema(), tableName.getName())) {
            while (rs.next()) {
                columns.put(rs.getInt("KEY_SEQ"), rs.getString("COLUMN_NAME"));
                if (keyName == null || keyName.isEmpty()) {
                    keyName = rs.getString("PK_NAME");
                }
            }
        }
        return PrimaryKey.of(keyName, tableName, new LinkedHashSet<>(columns.values()));
    }
}
