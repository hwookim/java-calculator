package calculator;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final Map<String, BiFunction<Double, Double, Double>> function = new HashMap<>();

    static {
        Stream.of(Operator.values())
                .forEach(operator -> function.put(operator.getOperator(), operator.getFunction()));
    }

    private List<Double> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public Calculator(String input) {
        distinguish(split(input));
    }

    public List<String> split(String input) {
        return Arrays.stream(input.trim()
                .split(SPACE))
                .filter(x -> !x.equals(BLANK))
                .collect(Collectors.toList());
    }

    public void distinguish(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            validate(input.get(i), i);
        }
    }

    private void validate(String target, int index) {
        if (index % 2 == 0) {
            validateNumber(target);
        }
        validateOperator(target);
    }

    private void validateNumber(String number) {
        try {
            numbers.add(Double.parseDouble(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOperator(String target) {
        if (!function.containsKey(target)) {
            throw new IllegalArgumentException();
        }
        operators.add(target);
    }
}
