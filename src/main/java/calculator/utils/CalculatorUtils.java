package calculator.utils;

import calculator.domain.Operator;
import calculator.exception.InvalidateNumberException;
import calculator.exception.InvalidateOperatorException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculatorUtils {
    private static final String SPACE = " ";
    private static final String BLANK = "";
    public static final Map<String, BiFunction<Double, Double, Double>> function = new HashMap<>();

    static {
        Stream.of(Operator.values())
                .forEach(operator -> function.put(operator.getOperator(), operator.getFunction()));
    }

    public static List<String> split(String input) {
        return Arrays.stream(input.trim()
                .split(SPACE))
                .filter(x -> !x.equals(BLANK))
                .collect(Collectors.toList());
    }

    public static double validateNumber(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new InvalidateNumberException();
        }
    }

    public static String validateOperator(String target) {
        if (!function.containsKey(target)) {
            throw new InvalidateOperatorException();
        }
        return target;
    }
}
