package calculator.domain.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    // 토큰 배열로 Numbers 생성 후 합계 계산 확인 (정수/소수 혼합)
    @Test
    void fromAndSum() {
        String[] tokens = {"1", "2", "3.5"};
        Numbers numbers = Numbers.from(tokens);
        assertEquals(6.5, numbers.sum(), 0.0001);
    }

    // 빈 토큰 배열을 넘기면 예외 발생
    @Test
    void emptyTokensThrows() {
        assertThrows(IllegalArgumentException.class, () -> Numbers.from(new String[]{}));
    }

    // 숫자 형식이 잘못된 토큰이 있으면 예외 발생
    @Test
    void invalidNumberFormatThrows() {
        String[] tokens = {"1", "a"};
        assertThrows(IllegalArgumentException.class, () -> Numbers.from(tokens));
    }

    // 음수 값이 포함되어 있으면 예외 발생
    @Test
    void negativeNumbersThrow() {
        String[] tokens = {"1", "-2"};
        assertThrows(IllegalArgumentException.class, () -> Numbers.from(tokens));
    }
}
