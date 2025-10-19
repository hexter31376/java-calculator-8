package calculator.domain.token.number;

import calculator.domain.token.MeanToken;
import calculator.domain.token.enums.TokenType;

public class NumberToken implements MeanToken {
    private Double value;

    @Override
    public TokenType getTokenType() {
        return TokenType.NUMBER;
    }

    public Double getValue() {
        return value;
    }
}
