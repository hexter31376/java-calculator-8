package calculator.config;

import calculator.application.CalculatorService;
import calculator.domain.parsor.ParsorService;
import calculator.presentation.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    // service
    private final ParsorService parsorService =  new ParsorService();
    private final CalculatorService calculatorService = new CalculatorService(parsorService);

    // view
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    //presentation
    private final CalculatorController calculatorController = new CalculatorController(calculatorService, inputView, outputView);

    public void run(){
        calculatorController.start();
    }
}
