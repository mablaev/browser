package com.luxoft.utils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

/**
 * Created by ma29379 on 2/10/2017.
 */
public final class ConversionUtils {

    private static final List<Function<String, String>> CONVERTERS = asList(
            Function.identity(),
            ConversionUtils::camelcaseToUnderscore,
            ConversionUtils::underscoreToCamelcase
    );

    private ConversionUtils() {
        //no code
    }

    public static String underscoreToCamelcase(String input){
        Pattern p = Pattern.compile("_(.)");
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static String camelcaseToUnderscore(String input){
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return input.replaceAll(regex, replacement).toUpperCase();
    }

    public static <T> Optional<T> tryToMatch(String name, Function<String, T> nameToEntityMapper){
        //try to find using all possible name conversions
        return CONVERTERS.stream()
                .map(converter -> converter.apply(name))
                .map(nameToEntityMapper)
                .filter(Objects::nonNull)
                .findFirst();
    }
}
