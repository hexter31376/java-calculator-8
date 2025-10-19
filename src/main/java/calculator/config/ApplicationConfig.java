package calculator.config;

import calculator.application.*;
import calculator.application.service.CalculatorTokenizer;
import calculator.application.service.OperationalCollectionCalculator;
import calculator.domain.token.operator.OperatorToken;
import calculator.infrastructure.Operators;
import calculator.presentation.CalculatorController;
import calculator.util.StringStateCursor;
import calculator.view.Input;
import calculator.view.Output;

import java.util.HashMap;
import java.util.Map;


/** IOC 생명주기 관리
 * Controller를 최종적으로 return;
 */
public class ApplicationConfig {
    // repository
    private final Operators operators = new Operators();

    // services
    private final CalculatorTokenizer calculatorTokenizer = new CalculatorTokenizer(operators);
    private final OperationalCollectionCalculator operationalCollectionCalculator = new OperationalCollectionCalculator();

    private final CalculatorService calculatorService = new CalculatorService(calculatorTokenizer, operationalCollectionCalculator);

    // controllers
    private final Input input = new Input();
    private final Output output = new Output();
    private final CalculatorController calculatorController = new CalculatorController(calculatorService, input, output);

    // returns
    public CalculatorController calculatorController() {
        return calculatorController;
    }
}