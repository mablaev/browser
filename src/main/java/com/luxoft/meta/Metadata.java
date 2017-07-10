package com.luxoft.meta;

import com.luxoft.dao.NewTableExtractor;
import com.luxoft.domain.Table;
import com.luxoft.domain.TableName;
import com.luxoft.utils.ConversionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by ma29379 on 2/3/2017.
 */
public class Metadata implements Iterable<Table> {
    private static final Logger logger = LoggerFactory.getLogger(Metadata.class);

    private DataSource dataSource;

    private String schema;

    private final Map<String, Table> tables = new TreeMap<>(String::compareToIgnoreCase);

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Table getTable(TableName tableName) {
        return getTable(tableName.getName());
    }

    public Table getTable(String name) {
        //try to find using all possible name conversions
        Optional<Table> table = ConversionUtils.tryToMatch(name, tables::get);
        return table.orElse(null);
    }

    public Table requireTable(TableName tableName) {
        return requireTable(tableName.getName());
    }

    public Table requireTable(String name) {
        return Objects.requireNonNull(getTable(name), "Table '" + name + "' was not found in metadata.");
    }

    @Override
    public Iterator<Table> iterator() {
        return tables.values().iterator();
    }

    public void load() throws SQLException {
        logger.info("Loading metadata for {} started...", schema);
        NewTableExtractor tableExtractor = new NewTableExtractor();
        tableExtractor.setDataSource(dataSource);
        tableExtractor.setSchema(schema);

        Map<String, Table> allTables = tableExtractor.extraAllTables();
        this.tables.putAll(allTables);
        logger.info("Loading metadata finished.");
    }


//    private static Map<Integer, Set<Table>> breakIntoTiers(Collection<Table> allTables) {
//        Map<Integer, Set<Table>> tiers = new TreeMap<>();
//
//        // list on tables that not yet processed
//        Set<Table> pendingTables = new HashSet<>(allTables);
//
//        Predicate<ForeignKey> isReferenceToProcessedTable = inputFk -> {
//            TableName refTabName = inputFk.getReferencedKey().getTableName();
//
//            Optional<TableName> tableName = pendingTables.stream()
//                    .map(Table::getTableName)
//                    .filter(refTabName::equals)
//                    .findFirst();
//
//            return !tableName.isPresent();
//        };
//
//        // either table references to tables that are already processed or to itself
//        Predicate<ForeignKey> tierForeignKeyFilter = isReferenceToProcessedTable.or(ForeignKey::isHierarchicalReference);
//
//        Predicate<Table> tierTableFilter = inputTable -> inputTable.getForeignKeys().stream().allMatch(tierForeignKeyFilter);
//
//        for (int tierIndex = 0; !pendingTables.isEmpty(); tierIndex++) {
//            Set<Table> tierTables = pendingTables.stream()
//                    .filter(tierTableFilter)
//                    .collect(Collectors.toSet());
//
//            pendingTables.removeAll(tierTables);
//
//            tiers.put(tierIndex, tierTables);
//        }
//        return tiers;
//    }

}
