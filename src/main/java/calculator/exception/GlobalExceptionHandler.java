package calculator.exception;

import calculator.exception.custom.OperatorAlreadyExistException;
import calculator.exception.custom.RequsetNullException;

import java.io.IOException;

// 스레드의 익셉션을 받아들여 처리하는 글로벌 익셉션 핸들러
public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof OperatorAlreadyExistException) {
            System.err.println("[연산자가 이미 존재합니다.] " + e.getMessage());
        } else if (e instanceof RequsetNullException) {
            System.err.println("[리퀘스트는 널일 수 없습니다.] " + e.getMessage());
        } else {
            e.printStackTrace(System.err);
        }
    }
}
