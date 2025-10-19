package calculator.application.dto;

public record CalculatorRequest(
        String userinput
) {
    public boolean isEmpty() {
        return userinput == null || userinput.isEmpty();
    }
    public int length() {
        return userinput.length();
    }
}
