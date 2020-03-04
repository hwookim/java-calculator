package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorUtilsTest {
    @Test
    @DisplayName("공백 기준으로 문자열 분리")
    void splitTest() {
        String input = " 1 + 2 *     3 ";

        List<String> result = CalculatorUtils.split(input);
        List<String> expect = Arrays.asList("1","+","2","*","3");

        assertThat(result).isEqualTo(expect);
    }
}