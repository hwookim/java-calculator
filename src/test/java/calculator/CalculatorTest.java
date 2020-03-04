package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("숫자, 연산자 구분 오류 테스트")
    @MethodSource("generateInput")
    void distinguishTest(String input) {
        assertThatThrownBy(() -> new Calculator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateInput() {
        return Stream.of(
                Arguments.of("a + 2 * 3"),
                Arguments.of("1 a 2 * 3"),
                Arguments.of("1 1 + 2 * 3"),
                Arguments.of("1 + + 2 * 3"),
                Arguments.of("+ 1 + 2 * 3"),
                Arguments.of("1 + 2 * 3 +")
        );
    }
}
