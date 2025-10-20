package calculator.application;

import calculator.domain.parser.StringParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService(new StringParser());

    // 입력값이 null이면 IllegalArgumentException 발생
    @Test
    void nullInputThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.calculate(null));
    }

    // 빈 문자열 입력 시 0.0 반환 확인
    @Test
    void emptyReturnsZero() {
        assertEquals(0.0, service.calculate(""), 0.0001);
    }

    // 기본 구분자(쉼표, 콜론) 사용 시 합계 계산 확인
    @Test
    void defaultDelimitersSum() {
        assertEquals(6.0, service.calculate("1,2:3"), 0.0001);
    }

    // 커스텀 구분자(헤더의 '\\n' 시퀀스) 사용 시 합계 계산 확인
    @Test
    void customDelimiterSum() {
        assertEquals(3.0, service.calculate("//;\\n1;2"), 0.0001);
    }

    // 음수 포함 시 예외 발생
    @Test
    void negativeNumberThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.calculate("-1,2,3"));
    }
}
