package calculator.util;

public class StringStateCursor {
    Integer cursor = 0;
    final Integer length;

    public StringStateCursor(String string) {
        this.length = string.length();
    }

    public Integer getCursor() {
        return cursor;
    }

    public boolean setCursor(Integer cursor) {
        if (cursor == null) {
            return false;
        }
        if (cursor > this.length) {
            return false;
        }
        this.cursor = cursor;
        return true;
    }
}
