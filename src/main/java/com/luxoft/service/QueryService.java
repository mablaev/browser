package com.luxoft.service;

import com.luxoft.domain.Table;
import com.luxoft.domain.dto.DataRequest;
import com.luxoft.domain.dto.DataResponse;
import com.luxoft.domain.dto.QueryPlan;

/**
 * Created by MAblaiev on 26.01.2017.
 */
public interface QueryService {

    Table getSearchViewStructure(String searchInput);

	QueryPlan getQueryPlan(String searchInput);

    DataResponse<Object[]> getData(DataRequest request);
}
