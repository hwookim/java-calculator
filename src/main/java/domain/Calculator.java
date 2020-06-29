package domain;

import static utils.Constant.ADDITION;
import static utils.Constant.DIVISION;
import static utils.Constant.EVEN;
import static utils.Constant.MULTIPLICATION;
import static utils.Constant.SUBTRACTION;
import static utils.Constant.ZERO;
import static utils.Constant.operatorFunction;

import java.util.ArrayList;
import java.util.List;
import utils.InputValidation;
import view.InputView;
import view.OutputView;

public class Calculator {
    private final List<Double> numbers = new ArrayList<>();
    private final List<Character> operators = new ArrayList<>();

    public Calculator() {
        operatorFunction.put('+', ADDITION);
        operatorFunction.put('-', SUBTRACTION);
        operatorFunction.put('*', MULTIPLICATION);
        operatorFunction.put('/', DIVISION);
    }

    public List<Double> getNumbers() {
        return numbers;
    }

    public List<Character> getOperators() {
        return operators;
    }

    public void run() {
        splitFormula(InputView.inputFormula());
        OutputView.printResult(calculate());
    }

    public void splitFormula(String formula) {
        String[] formulas = InputValidation.trimSpace(formula.split(" ", ZERO));

        for (int i = ZERO; i < formulas.length; i++) {
            if (i % EVEN == ZERO) {
                numbers.add(InputValidation.checkIsNumber(formulas[i]));
                continue;
            }
            operators.add(InputValidation.checkIsOperator(formulas[i]));
        }
    }

    public double calculate() {
        int index = ZERO;

        double result = numbers.get(index++);
        for (char operator : operators) {
            result = operatorFunction.get(operator).apply(result, numbers.get(index++));
        }

        return result;
    }
}
