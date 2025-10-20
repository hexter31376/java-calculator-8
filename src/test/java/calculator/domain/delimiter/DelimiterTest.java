package calculator.domain.delimiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {

    // 유효한 구분자 생성 및 값 확인
    @Test
    void validDelimiter() {
        Delimiter d = Delimiter.of(";");
        assertEquals(";", d.getValue());
    }

    // null 또는 공백 구분자일 때 IllegalArgumentException 발생
    @Test
    void nullOrBlankThrows() {
        assertThrows(IllegalArgumentException.class, () -> Delimiter.of(null));
        assertThrows(IllegalArgumentException.class, () -> Delimiter.of(""));
        assertThrows(IllegalArgumentException.class, () -> Delimiter.of("   "));
    }

    // 구분자에 '.'이 포함되어 있으면 예외 발생
    @Test
    void containsDotThrows() {
        assertThrows(IllegalArgumentException.class, () -> Delimiter.of("."));
        assertThrows(IllegalArgumentException.class, () -> Delimiter.of("a.b"));
    }

    // '//'이 포함된 값은 구분자로 사용할 수 없어 예외 발생
    @Test
    void containsDoubleSlashThrows() {
        assertThrows(IllegalArgumentException.class, () -> Delimiter.of("//"));
        assertThrows(IllegalArgumentException.class, () -> Delimiter.of("x//y"));
    }
}
