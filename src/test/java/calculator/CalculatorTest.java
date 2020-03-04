package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("공백 기준으로 문자열 분리")
    void splitTest() {
        String input = " 1 + 2 *     3 ";

        Calculator calculator = new Calculator();
        List<String> result = calculator.split(input);
        List<String> expect = Arrays.asList("1","+","2","*","3");

        assertThat(result).isEqualTo(expect);
    }
}
