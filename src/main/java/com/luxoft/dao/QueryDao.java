package com.luxoft.dao;

import java.util.List;

/**
 * Created by MAblaiev on 26.01.2017.
 */
public interface QueryDao {
    List<Object[]> getQueryPlan(String query);

    List<Object[]> getData(String query, int start, int length);

    long getCount(String query);
}
