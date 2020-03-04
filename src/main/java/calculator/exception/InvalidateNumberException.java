package calculator.exception;

public class InvalidateNumberException extends IllegalArgumentException {
    public InvalidateNumberException() {
        super("잘못된 숫자가 들어갔습니다.");
    }
}

