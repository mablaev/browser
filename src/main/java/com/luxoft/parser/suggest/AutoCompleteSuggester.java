package com.luxoft.parser.suggest;

import java.util.Set;

/**
 * Created by ma29379 on 2/16/2017.
 */
public interface AutoCompleteSuggester {
    Set<TokenType> suggestions();
}
