package calculator.domain.parser;

import calculator.domain.parser.dto.DelimiterFilteredResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    // 기본 구분자(쉼표, 콜론) 사용 시 regex와 본문 텍스트 반환 확인
    @Test
    void parseDefaultDelimiters() {
        StringParser parser = new StringParser();
        DelimiterFilteredResult res = parser.parse("1,2:3");
        String expectedRegex = java.util.regex.Pattern.quote(",") + "|" + java.util.regex.Pattern.quote(":");
        assertEquals(expectedRegex, res.regex());
        assertEquals("1,2:3", res.delimiterNumberText());
    }

    // 커스텀 구분자 형식(헤더에서 '\\n' 문자 시퀀스 사용) 파싱 확인
    @Test
    void parseCustomDelimiter() {
        StringParser parser = new StringParser();
        String raw = "//;\\n1;2,3";
        DelimiterFilteredResult res = parser.parse(raw);
        String expectedRegex = java.util.regex.Pattern.quote(",") + "|" + java.util.regex.Pattern.quote(":") + "|" + java.util.regex.Pattern.quote(";");
        assertEquals(expectedRegex, res.regex());
        assertEquals("1;2,3", res.delimiterNumberText());
    }

    // 실제 개행 문자(\"\n\")를 사용한 경우 커스텀 패턴과 매칭되지 않아 예외 발생
    @Test
    void invalidCustomFormatThrows() {
        StringParser parser = new StringParser();
        String rawInvalid = "//;\n1"; // 실제 개행 문자 포함
        assertThrows(IllegalArgumentException.class, () -> parser.parse(rawInvalid));
    }
}
