package calculator.domain.delimiter;

public class Delimiter {
    private final String delimiterValue;

    private Delimiter(String delimiterValue) {
        if (delimiterValue == null || delimiterValue.isBlank()) {
            throw new IllegalArgumentException("구분자 항목이 비어있습니다.");
        }
        if (delimiterValue.contains(".")) {
            throw new IllegalArgumentException(".이 포함된 항목은 구분자로 사용할 수 없습니다.");
        }
        if (delimiterValue.contains("//")) {
            throw new IllegalArgumentException("//은 구분자 시작 항목으로만 사용할 수 있습니다.");
        }

        this.delimiterValue = delimiterValue;
    }

    public static Delimiter of(String delimiterValue) {
        return new Delimiter(delimiterValue);
    }

    public String getValue() {
        return delimiterValue;
    }
}
