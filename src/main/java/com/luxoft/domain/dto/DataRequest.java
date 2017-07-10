package com.luxoft.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by MAblaiev on 26.01.2017.
 */
@Getter
@Setter
@ToString
public class DataRequest {
    private int start;
    private int length;
    private int orderColumn;
    private String searchInput;
}

