package com.luxoft.parser.suggest;

import org.antlr.v4.runtime.Token;

import java.util.List;

/**
 * Created by ma29379 on 2/16/2017.
 */
public interface EditorContext {
    List<Token> precedingTokens();
}
