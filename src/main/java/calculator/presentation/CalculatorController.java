package calculator.presentation;

import calculator.application.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(CalculatorService calculatorService, InputView inputView, OutputView outputView) {
        this.calculatorService = calculatorService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        String input = inputView.readline();
        double number = calculatorService.calculate(input);
        if (number % 1 == 0) {
            outputView.print((int)number);
        } else  {
            outputView.print(number);
        }
    }
}
