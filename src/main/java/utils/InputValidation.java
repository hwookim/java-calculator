package utils;

import static utils.Constant.operatorFunction;

import java.util.Arrays;
import java.util.Objects;

public class InputValidation {

    public static boolean checkNullOroSpace(String input) {
        if (Objects.isNull(input) || input.equals(" ")) {
            throw new IllegalArgumentException("공백을 입력하셨습니다.");
        }
        return false;
    }

    public static double checkIsNumber(String stringNumber) {
        try {
            return Double.parseDouble(stringNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 피연산자를 입력하셨습니다.");
        }
    }

    public static char checkIsOperator(String stringOperator) {
        char operator = stringOperator.charAt(0);

        if (!operatorFunction.containsKey(operator)
            || stringOperator.length() != 1) {
            throw new IllegalArgumentException("잘못된 연산자를 입력하셨습니다.");
        }
        return operator;
    }

    public static String[] trimSpace(String[] formulas) {
        return Arrays.stream(formulas)
            .filter(formula -> !formula.isEmpty())
            .toArray(String[]::new);
    }

}
