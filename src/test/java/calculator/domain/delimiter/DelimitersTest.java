package calculator.domain.delimiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimitersTest {

    // 기본 구분자들로 생성된 정규식 확인 (쉼표와 콜론)
    @Test
    void defaultBuildRegex() {
        String expected = java.util.regex.Pattern.quote(",") + "|" + java.util.regex.Pattern.quote(":");
        assertEquals(expected, Delimiters.setDefault().buildRegex());
    }

    // 커스텀 구분자를 추가했을 때 정규식에 포함되는지 확인
    @Test
    void customBuildRegex() {
        String expected = java.util.regex.Pattern.quote(",") + "|" + java.util.regex.Pattern.quote(":") + "|" + java.util.regex.Pattern.quote(";");
        assertEquals(expected, Delimiters.of(";").buildRegex());
    }
}
