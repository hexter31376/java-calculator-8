package calculator.domain.token.operator;

import calculator.domain.token.MeanToken;
import calculator.domain.token.enums.TokenType;

public class OperatorToken implements MeanToken {
    private String value;

    @Override
    public TokenType getTokenType() {
        return TokenType.OPERATOR;
    }

    public String getValue() {
        return value;
    }


}
