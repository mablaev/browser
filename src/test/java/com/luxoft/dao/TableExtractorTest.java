package com.luxoft.dao;

import com.luxoft.domain.ForeignKey;
import com.luxoft.domain.Table;
import com.luxoft.domain.TableName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mablaev on 1/29/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableExtractorTest {

    private TableExtractor tableExtractor = new TableExtractor();

    @Autowired
    public void setDataSource(DataSource dataSource) {
        tableExtractor.setDataSource(dataSource);
    }

    @Test
    public void extractTable() throws SQLException {
        TableName processDef = TableName.of("METAINFO", "PROCESS_DEF");
        TableName dataAttrProc = TableName.of("METAINFO", "DATA_ATTRIBUTE_PROCESS");

        Set<Table> tables = tableExtractor.extractTables(processDef, dataAttrProc);
        tables.stream().forEach(System.out::println);

        assertThat(tables.size(), is(2));

        Map<TableName, Table> tableMap = tables.stream()
                .collect(toMap(Table::getTableName, Function.identity()));

        Map<Integer, Set<Table>> tiers = breakIntoTiers(tables);
        System.out.println(tiers);
    }

    public static Map<Integer, Set<Table>> breakIntoTiers(Collection<Table> allTables) {
        Map<Integer, Set<Table>> tiers = new TreeMap<>();

        // list on tables that not yet processed
        Set<Table> pendingTables = new HashSet<>(allTables);

        Predicate<ForeignKey> isReferenceToProcessedTable = input -> {
            TableName refTabName = input.getReferencedKey().getTableName();

            Optional<TableName> tableName = pendingTables.stream()
                    .map(Table::getTableName)
                    .filter(refTabName::equals)
                    .findFirst();

            return !tableName.isPresent();
        };

        // either table references to tables that are already processed or to itself
        Predicate<ForeignKey> tierForeignKeyFilter = isReferenceToProcessedTable.or(ForeignKey::isHierarchicalReference);

        Predicate<Table> tierTableFilter = input -> input.getForeignKeys().stream().allMatch(tierForeignKeyFilter);

        int tierIndex = 0;
        while (!pendingTables.isEmpty()) {

            Set<Table> tierTables = pendingTables.stream()
                    .filter(tierTableFilter)
                    .collect(Collectors.toSet());

            pendingTables.removeAll(tierTables);
            tiers.put(tierIndex, tierTables);
            tierIndex++;
        }
        return tiers;
    }

    @Test
    public void extractAllTables() throws SQLException {
        Set<Table> allTables = tableExtractor.extractAllTablesFrom("METAINFO");

        Map<Integer, Set<Table>> tiers = breakIntoTiers(allTables);
        System.out.println(tiers);
        tiers.forEach((k, v) -> System.out.println("Tier " + k + " Table " + v));
    }
}
