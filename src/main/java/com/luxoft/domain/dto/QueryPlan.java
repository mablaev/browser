package com.luxoft.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"data"} )
public class QueryPlan {
	private String sql;
	private Object[] columns;
	private List<Object[]> data;
}
