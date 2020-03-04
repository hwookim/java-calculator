package calculator.domain;

import calculator.exception.InvalidateExpressionException;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Double::sum),
    SUBTRACTION("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    MULTIPLICATION("*", (firstOperand, secondOperand) -> firstOperand * secondOperand),
    DIVISION("/", (firstOperand, secondOperand) -> {
        if (secondOperand == 0) {
            throw new InvalidateExpressionException();
        }
        return firstOperand / secondOperand;
    });

    private String operator;
    private BiFunction<Double, Double, Double> function;

    Operator(String operator, BiFunction<Double, Double, Double> function) {
        this.operator = operator;
        this.function = function;
    }

    public String getOperator() {
        return operator;
    }

    public BiFunction<Double, Double, Double> getFunction() {
        return function;
    }

}
