package calculator.exception.custom;

public class RequsetNullException extends RuntimeException {
    public RequsetNullException(String message, Throwable cause) {
        super("리퀘스트는 널일 수 없습니다. : " + message, cause);
    }
}
