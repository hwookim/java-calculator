package calculator.exception;

public class InvalidateOperatorException extends IllegalArgumentException {
    public InvalidateOperatorException() {
        super("잘못된 연산자가 들어갔습니다.");
    }
}

