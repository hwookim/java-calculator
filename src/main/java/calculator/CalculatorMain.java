package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorMain {
    public static void main(String[] args) {
        String input = InputView.inputExpression();
        Calculator calculator = new Calculator(input);
        OutputView.printResult(calculator);
    }
}
