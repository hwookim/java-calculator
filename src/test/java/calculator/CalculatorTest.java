package calculator;

import domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("계산식 분할 테스트")
    @Test
    void splitFormula() {
        String formula = "3 + 2 / 1";
        double[] numbers = {3, 2, 1};
        char[] operators = {'+', '/'};

        calculator.splitFormula(formula);

        double[] targetNumbers = calculator.getNumbers().stream().mapToDouble(Double::doubleValue).toArray();
        Assertions.assertThat(numbers).isEqualTo(targetNumbers);

        char[] targetOperators = new char[calculator.getOperators().size()];
        for (int i = 0; i < calculator.getOperators().size(); i++) {
            targetOperators[i] = calculator.getOperators().get(i);
        }
        Assertions.assertThat(operators).isEqualTo(targetOperators);
    }

    @DisplayName("컬랙션 분할 후 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3,6", "3 * 6 + 3,21", "3 * 3 / 3,3", "3 + 2 - 5,0"})
    public void calculate(String formula, double expect) {
        calculator.splitFormula(formula);

        double result = calculator.calculate();
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @DisplayName("0으로 나눌 때 오류")
    @Test
    void calculate_Fail_When_DivideZero() {
        calculator.splitFormula("2 / 0");
        Assertions.assertThatThrownBy(() -> calculator.calculate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로는 나눌 수 없습니다.");
    }
}
