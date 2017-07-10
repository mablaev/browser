package com.luxoft.parser.suggest;

import com.luxoft.antlr4.gen.SimpleQLangLexer;
import com.luxoft.antlr4.gen.SimpleQLangParser;
import com.luxoft.meta.Metadata;
import com.luxoft.parser.ExpressionVisitor;
import com.luxoft.parser.Query;
import com.luxoft.parser.QueryParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Created by ma29379 on 2/16/2017.
 */
public class Antlr4QueryAutocompleteParser implements QueryParser {

    private Metadata metadata;

    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }

    @Override
    public Query parse(String input) {
        CharStream charStream = new ANTLRInputStream(input);
        SimpleQLangLexer lexer = new SimpleQLangLexer(charStream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        TokenStream tokens = new CommonTokenStream(lexer);
        SimpleQLangParser parser = new SimpleQLangParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        ExpressionVisitor queryVisitor = new ExpressionVisitor(metadata);
        Query queryResult = queryVisitor.visit(parser.expression());

        return queryResult;
    }

    private static class ThrowingErrorListener extends BaseErrorListener {

        public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
                                String msg, RecognitionException e) throws ParseCancellationException {

            SimpleQLangParser recog = (SimpleQLangParser) recognizer;

            int size = ((SimpleQLangParser) recognizer).getTokenStream().size();

            if(size > 1) {
                Token lastToken = recog.getTokenStream().get(size - 2);
                String tokenType = recog.getVocabulary().getSymbolicName(lastToken.getType());
                System.out.println(tokenType);
            }

            System.out.println(msg);
//            throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
        }
    }}
