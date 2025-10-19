package calculator;

import calculator.config.ApplicationConfig;
import calculator.exception.GlobalExceptionHandler;
import calculator.presentation.CalculatorController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // JVM 레벨 전역 예외 핸들러 실행
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        ApplicationConfig applicationConfig = new ApplicationConfig();
        CalculatorController calculatorController = applicationConfig.calculatorController();

        // TODO: 메인 로직 스타터 호출
    }
}
