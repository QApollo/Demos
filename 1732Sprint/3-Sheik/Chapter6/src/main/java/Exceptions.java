import debug.Debug;

import java.util.Arrays;
import java.util.Scanner;

public class Exceptions {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Exceptions e = new Exceptions();
    }

    public Exceptions() {
        displayMessage();
        String input = getInput();
        checkInput(input);
    }

    private void displayMessage() {
        System.out.println("Enter the code");
    }

    private String getInput() {
        return SCANNER.next();
    }

    private void checkInput(String input) {
        String[] code = new String[0];

        code = input.split("");

        // Get length of the input
        Debug.log(code.length);

        // Get specific index
        Debug.log(code[0]);
    }
}
