package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private static final String SPACE = " ";
    private static final String BLANK = "";

    public List<String> split(String input) {
        return Arrays.stream(input.trim()
                .split(SPACE))
                .filter(x -> !x.equals(BLANK))
                .collect(Collectors.toList());
    }
}
