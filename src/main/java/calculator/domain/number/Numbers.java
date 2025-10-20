package calculator.domain.number;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<Double> numbers;

    private Numbers(List<Double> numbers) {
        negativeNumbersFilter(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public static Numbers from(String[] numberTokens) {
        if (numberTokens == null || numberTokens.length == 0) {
            throw new IllegalArgumentException("숫자가 존재하지 않습니다.");
        }

        List<Double> numbers = Arrays.stream(numberTokens)
                .map(token -> {
                    validateNumberFormat(token);
                    return Double.parseDouble(token);
                })
                .toList();

        return new Numbers(numbers);
    }

    public double sum() {
        double acc = 0.0;
        for (double v : numbers) acc += v;
        return acc;
    }

    private static void validateNumberFormat(String token) {
        try {
            Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + token);
        }
    }

    private void negativeNumbersFilter(List<Double> numbers) {
        for (Double number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("값에 음수는 허용되지 않습니다." + number);
            }
        }
    }
}
