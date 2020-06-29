package view;

import java.util.Scanner;
import utils.InputValidation;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputFormula() {
        boolean isException = true;
        String input = null;
        while (isException) {
            input = scanner.nextLine().trim();
            isException = InputValidation.checkNullOroSpace(input);
        }
        return input;
    }
}
