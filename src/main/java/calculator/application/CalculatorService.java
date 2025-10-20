package calculator.application;

import calculator.domain.delimiter.Delimiters;
import calculator.domain.number.Numbers;
import calculator.domain.parsor.StringParser;
import calculator.domain.parsor.dto.DelimiterFilteredResult;

public class CalculatorService {

    private final StringParser stringParser;

    public CalculatorService(StringParser stringParser) {
        this.stringParser = stringParser;
    }

    public Double calculate(String input) {

        if (input == null) {
            throw new IllegalArgumentException("입력값이 null 입니다.");
        }
        if (input.isEmpty()) {
            return 0.0;
        }

        // 1. 파싱
        DelimiterFilteredResult delimiterFilteredResult = stringParser.parse(input);
        // 2. 정규식 추출
        String regex = delimiterFilteredResult.regex();
        // 3. 숫자 추출
        String[] numberTokens = delimiterFilteredResult.delimiterNumberText().split(regex);
        // 4. 숫자 도메인 생성
        Numbers numbers = Numbers.from(numberTokens);

        // 5. 연산 후 리턴
        return numbers.sum();
    }
}
