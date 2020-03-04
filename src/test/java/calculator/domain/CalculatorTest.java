package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("숫자, 연산자 구분 성공 테스트")
    void distinguishTest() {
        assertThatCode(() -> new Calculator("1 + 2 - 3 * 4 / 1"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("숫자, 연산자 구분 오류 테스트")
    @MethodSource("distinguishFailInput")
    void distinguishFailTest(String input) {
        assertThatThrownBy(() -> new Calculator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> distinguishFailInput() {
        return Stream.of(
                Arguments.of("a + 2 * 3"),
                Arguments.of("1 a 2 * 3"),
                Arguments.of("1 1 + 2 * 3"),
                Arguments.of("1 + + 2 * 3"),
                Arguments.of("+ 1 + 2 * 3"),
                Arguments.of("1 + 2 * 3 +")
        );
    }

    @ParameterizedTest
    @DisplayName("계산 테스트")
    @MethodSource("calculateInput")
    void calculateTest(String input, String expect) {
        assertThat(new Calculator(input).toString()).isEqualTo(expect);
    }

    static Stream<Arguments> calculateInput() {
        return Stream.of(
                Arguments.of("1 + 2 * 3", "9.0"),
                Arguments.of("1 + 2 * -3", "-9.0"),
                Arguments.of("1 + 2 / 3", "1.0"),
                Arguments.of("1 - 2 + 3", "2.0")
        );
    }

    @Test
    @DisplayName("/ 뒤에 0이 오는 실패 테스트")
    void calculateFailTest() {
        assertThatThrownBy(() -> new Calculator("1 / 0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}