import src.main.resources.Debug;

import java.util.ArrayList;
import java.util.List;
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
        List<String> code = new ArrayList<>();

        Debug.log(input);
    }
}
