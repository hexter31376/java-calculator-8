package calculator.presentation;

import calculator.application.CalculatorService;
import calculator.view.Input;
import calculator.view.Output;

public class CalculatorController{

    private final CalculatorService calculatorService;
    private final Input input;
    private final Output output;

    public CalculatorController(CalculatorService calculatorService, Input input, Output output){
        this.calculatorService = calculatorService;
        this.input = input;
        this.output = output;
    }

    public void run () {
        String userInput = input.readLine();
        output.print(calculatorService.run(userInput).result().toString());
    }
}
