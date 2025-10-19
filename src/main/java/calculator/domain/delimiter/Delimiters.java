package calculator.domain.delimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiters {

    private static final List<Delimiter> DEFAULT_DELIMITERS = List.of(
            Delimiter.of(","),
            Delimiter.of(":")
    );

    private final List<Delimiter> delimiterValues;

    private Delimiters(List<Delimiter> delimiterValues) {
        this.delimiterValues = List.copyOf(delimiterValues);
    }

    public static Delimiters of(String customDelimiterValue) {
        List<Delimiter> delimiterList = new ArrayList<>(DEFAULT_DELIMITERS);
        delimiterList.add(Delimiter.of(customDelimiterValue));
        return new Delimiters(delimiterList);
    }

    public String regixBuild() {
        String delimiterRegix = delimiterValues.stream()
                .map(Delimiter::getValue)
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        return delimiterRegix;
    }
}
