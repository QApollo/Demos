import debug.Debug;

import java.util.Arrays;
import java.util.Scanner;

public class Exceptions {

    private static final Scanner SCANNER = new Scanner(System.in);
    private final int CODELENGTH = 4;
    private final String[] CODE = {"A", "1", "B", "2"};

    public static void main(String[] args) {
        Exceptions exceptions = new Exceptions();
    }

    public Exceptions() {
        displayMessage();
        String input = getInput();
        checkCode(input);
    }

    private void displayMessage() {
        System.out.println("Enter the code");
    }

    private String getInput() {
        return SCANNER.next();
    }

    private void checkCode(String input) {
        String[] inputCode = new String[0];
        inputCode = input.split("");
        checkLength(inputCode);
    }

    private void checkLength(String[] inputCode) {
        for (int i = 0; i < inputCode.length; i++) {
            try {
                validateInput(inputCode[i], CODE[i], i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(i + ":");
                e.printStackTrace();
            }
        }
    }

    private void validateInput(String inputCode, String code, int digit) {
        try {
            Integer.parseInt(inputCode);
            Integer.parseInt(code);

            if (inputCode.equals(code)) {
                System.out.println(digit + ": Digit correct");
            } else {
                System.out.println(digit + ": Digit incorrect");
            }
        } catch (NumberFormatException e) {
            if (inputCode.equals(code)) {
                System.out.println(digit + ": Letter correct");
            } else {
                System.out.println(digit + ": Letter incorrect");
            }
        }
    }
}
