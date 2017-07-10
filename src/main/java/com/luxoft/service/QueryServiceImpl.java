package com.luxoft.service;

import com.luxoft.dao.QueryDao;
import com.luxoft.domain.Table;
import com.luxoft.domain.dto.DataRequest;
import com.luxoft.domain.dto.DataResponse;
import com.luxoft.domain.dto.QueryPlan;
import com.luxoft.meta.Metadata;
import com.luxoft.parser.Antlr4SimpleQueryParser;
import com.luxoft.parser.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MAblaiev on 26.01.2017.
 */
@Service
public class QueryServiceImpl implements QueryService {

    public final static String SCHEMA = "METAINFO";

    private QueryDao queryDao;

    private Metadata metadata = new Metadata();

    @Autowired
    public void setQueryDao(QueryDao queryDao) {
        this.queryDao = queryDao;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.metadata.setDataSource(dataSource);
    }

    @PostConstruct
    public void init() throws SQLException {
        metadata.setSchema(SCHEMA);
        metadata.load();
    }

    @Override
    public Table getSearchViewStructure(String searchInput) {
        Antlr4SimpleQueryParser queryParser = new Antlr4SimpleQueryParser();
        queryParser.setMetadata(metadata);

        Query queryModel = queryParser.parse(searchInput);

        //TODO: change it here to TableView
        return queryModel.getFromTable();
    }

    @Override
    public QueryPlan getQueryPlan(String searchInput) {
        Antlr4SimpleQueryParser queryParser = new Antlr4SimpleQueryParser();
        queryParser.setMetadata(metadata);

        Query queryModel = queryParser.parse(searchInput);
        String sql = queryModel.on(metadata).buildSql();

        List<Object[]> planData = queryDao.getQueryPlan(sql);

        QueryPlan plan = new QueryPlan();
        plan.setSql(sql);
        //the first row is always the query plan header
        plan.setColumns(planData.get(0));
        plan.setData(planData.subList(1, planData.size()));
        return plan;
    }

    @Override
    public DataResponse<Object[]> getData(DataRequest request) {

        Antlr4SimpleQueryParser queryParser = new Antlr4SimpleQueryParser();
        queryParser.setMetadata(metadata);

        Query query = queryParser.parse(request.getSearchInput());
        String sql = query.on(metadata).buildSql();

        long total = queryDao.getCount(sql);
        List<Object[]> data = queryDao.getData(sql, request.getStart(), request.getLength());

        DataResponse<Object[]> response = new DataResponse<>();
        response.setTotal(total);
        response.setRecordsFiltered(total);
        response.setRows(data);

        return response;
    }
}
