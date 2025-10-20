package calculator.domain.parser;

import calculator.domain.delimiter.Delimiters;
import calculator.domain.parser.dto.DelimiterFilteredResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)" + Pattern.quote("\\n" ) + "(.*)");


    public DelimiterFilteredResult parse(String rawText) {
        if (rawText.startsWith("//")) {
            String customDelimiter = getCustomDelimiter(rawText);
            String regex = Delimiters.of(customDelimiter).buildRegex();
            // 순수 연산부 얻기
            String delimiterNumberText = getDelimiterNumberText(rawText);

            return new DelimiterFilteredResult(regex, delimiterNumberText);
        } else {
            String defaultRegex = Delimiters.setDefault().buildRegex();
            return new DelimiterFilteredResult(defaultRegex, rawText);
        }
    }

    private String getCustomDelimiter (String rawText) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(rawText);
        if (!matcher.find()) {
            throw new IllegalArgumentException("구분자 형식이 잘못되었습니다.");
        }
        return matcher.group(1);
    }

    private String getDelimiterNumberText (String rawText) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(rawText);
        if (!matcher.find()) {
            throw new IllegalArgumentException("구분자 형식이 잘못되었습니다.");
        }
        return matcher.group(2);
    }
}
