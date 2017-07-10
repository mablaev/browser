package com.luxoft.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by MAblaiev on 26.01.2017.
 */
@Getter
@Setter
@ToString
public class DataResponse<R> {
	@JsonProperty("draw")
	private int draw;

	@JsonProperty("recordsTotal")
	private long total;

	@JsonProperty("recordsFiltered")
	private long recordsFiltered;

	@JsonProperty
	private String error;

	@JsonProperty
	private List<String> columns;

	@JsonProperty("data")
	private List<R> rows = new ArrayList<>();
}
