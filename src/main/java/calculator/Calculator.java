package calculator;

import java.util.*;

public class Calculator {
    private List<Double> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private double result;

    public Calculator(String input) {
        List<String> expression = CalculatorUtils.split(input);
        distinguish(expression);
        calculate();
    }

    public void distinguish(List<String> input) {
        if (input.size() % 2 == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.size(); i++) {
            validate(input.get(i), i);
        }
    }

    private void validate(String target, int index) {
        if (index % 2 == 0) {
            double number = CalculatorUtils.validateNumber(target);
            numbers.add(number);
            return;
        }
        String operator = CalculatorUtils.validateOperator(target);
        operators.add(operator);
    }

    private void calculate() {
        int index = 0;

        result = numbers.get(index++);
        for (String operator : operators) {
            result = CalculatorUtils.function.get(operator).apply(result, numbers.get(index++));
        }
    }

    @Override
    public String toString() {
        return Double.toString(result);
    }
}