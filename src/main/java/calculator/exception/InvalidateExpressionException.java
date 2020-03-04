package calculator.exception;

public class InvalidateExpressionException extends IllegalArgumentException {
    public InvalidateExpressionException() {
        super("/ 뒤에는 0이 올 수 없습니다.");
    }
}