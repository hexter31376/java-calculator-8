package calculator.infrastructure;

import calculator.domain.token.operator.OperatorToken;

import java.util.HashMap;
import java.util.Map;

public class Operators {
    private final Map<String, OperatorToken> operatorTokens = new HashMap<>();

    public Operators() {}

    public boolean isOperatorExist(OperatorToken token) {
        return operatorTokens.containsKey(token.getValue());
    }

    public OperatorToken getByTokenName(String tokenName) {
        return operatorTokens.get(tokenName);
    }

    public void put(OperatorToken token) {
        operatorTokens.put(token.getValue(), token);
    }
}
