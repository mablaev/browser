package com.luxoft.parser;

import com.luxoft.domain.*;
import com.luxoft.meta.Metadata;
import com.luxoft.parser.suggest.Antlr4QueryAutocompleteParser;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by ma29379 on 2/2/2017.
 */
public class QueryTest {

    private static final String SCHEMA = "TEST_SCHEMA";

    private Metadata metaData;
    private Antlr4SimpleQueryParser queryParser;

    @Before
    public void setUp() throws SQLException {
        metaData = spy(Metadata.class);
        metaData.setSchema(SCHEMA);

        TestData testData = new TestData();

        when(metaData.getTable("table0")).thenReturn(testData.table0);
        when(metaData.getTable("TABLE0")).thenReturn(testData.table0);
        when(metaData.getTable("table1")).thenReturn(testData.table1);
        when(metaData.getTable("TABLE1")).thenReturn(testData.table1);

        Iterator<Table> mockIterator = mock(Iterator.class);
        when(metaData.iterator()).thenReturn(mockIterator);
        when(mockIterator.hasNext()).thenReturn(true, true, false);
        when(mockIterator.next()).thenReturn(testData.table0).thenReturn(testData.table1);

        queryParser = new Antlr4SimpleQueryParser();
        queryParser.setMetadata(metaData);
    }


    @Test
    public void buildSimpleEq() {
        String inputQuery = "table0.tab0_col0 = 'N'";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" = 'N'"));
    }

    @Test
    public void buildSimpleLte() {
        String inputQuery = "table0.tab0_col0 <= 1.2";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" <= 1.2"));
    }

    @Test
    public void buildSimpleLt() {
        String inputQuery = "table0.tab0_col0 < 123456789";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" < 123456789"));
    }

    @Test
    public void buildSimpleGte() {
        String inputQuery = "table0.tab0_col0>=3.99";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" >= 3.99"));
    }

    @Test
    public void buildSimpleGt() {
        String inputQuery = "table0.tab0_col0 > 3.99";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" > 3.99"));
    }

    @Test
    public void buildSimpleIsNull() {
        String inputQuery = "table0.tab0_col0 is null";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" IS NULL"));
    }

    @Test
    public void buildSimpleIsNotNull() {
        String inputQuery = "table0.tab0_col0 is NoT null";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" IS NOT NULL"));
    }

    @Test
    public void buildSimpleIn() {
        String inputQuery = "table0.tab0_col0 in ('A', 'B', 'C')";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" IN ('A','B','C')"));
    }

    @Test
    public void buildSimpleNotIn() {
        String inputQuery = "table0.tab0_col0 not in ('A', 'B', 'C')";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" NOT IN ('A','B','C')"));
    }

    @Test
    public void buildNotInOrGte() {
        String inputQuery = "table0.tab0_col0 not in ('A', 'B', 'C') or table0.tab0_col1 >= 1234";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\nWHERE t0.\"TAB0_COL0\" NOT IN ('A','B','C') " +
                "OR t0.\"TAB0_COL1\" >= 1234"));
    }

    @Test
    public void simpleBetween() {
        String inputQuery = "table0.tab0_col0 between 1 and 10";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\n" +
                "WHERE t0.\"TAB0_COL0\" BETWEEN 1 AND 10"));
    }

    @Test
    public void simpleNotBetween() {
        String inputQuery = "table0.tab0_col0 not between 1 and 10";
        Query simpleQuery = queryParser.parse(inputQuery);

        String outcome = simpleQuery.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\n" +
                "WHERE t0.\"TAB0_COL0\" NOT BETWEEN 1 AND 10"));
    }

    @Test
    public void simpleShortNotBetween() {
        String inputQuery = "table0.tab0_col0 not bw 1 && 10";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\n" +
                "WHERE t0.\"TAB0_COL0\" NOT BETWEEN 1 AND 10"));
    }

    @Test
    public void betweenAndGt() {
        String inputQuery = "table0.tab0_col0 between 1 and 10 and table1.tab1_col1 > 3";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\n" +
                "LEFT JOIN \"TEST_SCHEMA\".\"TABLE1\" t1 ON t0.\"TAB0_COL_ID\" = t1.\"TAB1_TAB0_COL_ID\"\n" +
                "WHERE t0.\"TAB0_COL0\" BETWEEN 1 AND 10 " +
                "AND t1.\"TAB1_COL1\" > 3"));
    }

    @Test
    public void notBetweenAndLte() {
        String inputQuery = "table0.tab0_col0 not between 1 and 12345 and table1.tab1_col1 <= 321";
        Query queryModel = queryParser.parse(inputQuery);

        String outcome = queryModel.on(metaData).buildSql();

        assertThat(outcome, is("SELECT * FROM \"TEST_SCHEMA\".\"TABLE0\" t0\n" +
                "LEFT JOIN \"TEST_SCHEMA\".\"TABLE1\" t1 ON t0.\"TAB0_COL_ID\" = t1.\"TAB1_TAB0_COL_ID\"\n" +
                "WHERE t0.\"TAB0_COL0\" NOT BETWEEN 1 AND 12345 " +
                "AND t1.\"TAB1_COL1\" <= 321"));
    }

    @Test
    public void badQuery(){
        Antlr4QueryAutocompleteParser parser = new Antlr4QueryAutocompleteParser();
        parser.setMetadata(metaData);
        String input = "table0.tab0_col1= ";
        Query queryModel = parser.parse(input);
        System.out.println(queryModel);
    }

    private class TestData {

        private Table table0;
        private Table table1;

        public TestData() {

            TableName tableName0 = TableName.of("TEST_SCHEMA", "TABLE0");
            TableName tableName1 = TableName.of("TEST_SCHEMA", "TABLE1");

            List<String> tab0ColumnNames = asList("TAB0_COL_ID", "TAB0_COL0", "TAB0_COL1");
            List<String> tab1ColumnNames = asList("TAB1_COL_ID", "TAB1_TAB0_COL_ID", "TAB1_COL1", "TAB1_COL2");

            PrimaryKey tab0Pk = PrimaryKey.of("TAB0_PK", tableName0, asList("TAB0_COL_ID"));
            PrimaryKey tab1Pk = PrimaryKey.of("TAB1_PK", tableName1, asList("TAB1_COL_ID"));

            {
                Set<ForeignKey> expFks = new HashSet<>();
                expFks.add(ForeignKey.of("TAB1_FK1", tableName1, asList("TAB1_TAB0_COL_ID"), tab0Pk));

                Set<Column> tab0Columns = tab0ColumnNames.stream()
                        .map(cn -> Column.of(cn, 0, ""))
                        .collect(Collectors.toSet());

                this.table0 = Table.of(tableName0, tab0Columns, tab0Pk, emptySet());
            }

            {
                Set<ForeignKey> impFks = new HashSet<>();
                impFks.add(ForeignKey.of("TAB1_FK1", tableName1, asList("TAB1_TAB0_COL_ID"), tab0Pk));

                Set<Column> tab1Columns = tab1ColumnNames.stream()
                        .map(cn -> Column.of(cn, 0, ""))
                        .collect(Collectors.toSet());

                this.table1 = Table.of(tableName1, tab1Columns, tab1Pk, impFks);
            }

        }
    }
}