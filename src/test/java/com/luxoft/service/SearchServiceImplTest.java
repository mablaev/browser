package com.luxoft.service;

import com.luxoft.domain.Table;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ma29379 on 2/2/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceImplTest {

    @Autowired
    private QueryService searchService;

    @Test
    public void simpleInput() throws Exception {
        String searchInput = "dca_group.is_mandatory = 'N'";
        Table metaInfo = searchService.getSearchViewStructure(searchInput);
    }
}