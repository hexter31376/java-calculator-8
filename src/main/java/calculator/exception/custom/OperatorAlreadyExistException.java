package calculator.exception.custom;

public class OperatorAlreadyExistException extends IllegalArgumentException {
    public OperatorAlreadyExistException(String message, Throwable cause) {
        super("연산자가 이미 존재합니다 : " + message, cause);
    }
}
