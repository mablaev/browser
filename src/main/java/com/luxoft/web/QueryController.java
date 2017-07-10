package com.luxoft.web;

import com.luxoft.domain.Table;
import com.luxoft.domain.dto.DataRequest;
import com.luxoft.domain.dto.DataResponse;
import com.luxoft.domain.dto.QueryPlan;
import com.luxoft.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAblaiev on 26.01.2017.
 */
@Controller
public class QueryController {
    
    private QueryService queryService;

    @Autowired
    public void setQueryService(QueryService queryService) {
        this.queryService = queryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search() {
        return "search";
    }

    @ResponseBody
    @RequestMapping(value = "/result-structure", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public DataResponse<Object[]> queryStructure(@RequestParam("query") String searchInput) {

        Table table = queryService.getSearchViewStructure(searchInput);

        DataResponse<Object[]> result = new DataResponse<>();

        List<String> dtoColumns = new ArrayList<>(table.getColumnNames());

        result.setColumns(dtoColumns);

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/query-plan", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public QueryPlan queryPlan(@RequestParam("query") String searchInput) {
        QueryPlan plan = queryService.getQueryPlan(searchInput);
        return plan;
    }

    @ResponseBody
    @RequestMapping(value = "/query-data", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public DataResponse<Object[]> searchData(DataRequest request) {
        return queryService.getData(request);
    }
}
