package com.luxoft.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by MAblaiev on 26.01.2017.
 */
@Component
public class QueryDaoImpl implements QueryDao {

    private JdbcTemplate template;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Object[]> getQueryPlan(String sql) {

		template.execute("EXPLAIN PLAN FOR " + sql);

		List<String> planRows = template.queryForList("SELECT plan_table_output FROM table(dbms_xplan.display())",
				String.class);
        
        List<Object[]> result = planRows.stream()
				.map(row -> row.split("\\|")).filter(row -> row.length == 7)
				.map(row -> Arrays.copyOfRange(row, 1, row.length))
				.collect(Collectors.toList());

        return result;
    }

    @Override
    public List<Object[]> getData(String sql, int start, int length) {
        String pagingQuery = "SELECT * \n"
                + "  FROM (SELECT pg.*, rownum rn\n"
                + "  FROM ("
                + sql
                + ") pg \n"
                + " WHERE rownum < ?)\n"
                + " WHERE rn >= ?";

        return template.query(pagingQuery, new Object[]{start + length + 1, start + 1},
                (rs, idx) -> {
                    Object[] result = new Object[rs.getMetaData().getColumnCount()];
                    for (int i = 1; i <= result.length; i++) {
                        result[i - 1] = rs.getString(i);
                    }
                    return result;
                }
        );
    }

    @Override
    public long getCount(String sql) {
        String countSql = "SELECT COUNT(*) FROM (" + sql + ")";
        return template.queryForObject(countSql, Long.class);
    }

}
