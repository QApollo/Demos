import java.util.Scanner;

class Player {
    private static final Scanner SCANNER = new Scanner(System.in);
    boolean waitForInput = true;

    String input() {
        String input = "";
        while(waitForInput) {
            input = checkInput(SCANNER.next());
        }
        return input;
    }

    private String checkInput(String input) {
        waitForInput = false;
        switch (input) {
            case "chicken":
                input = "chicken";
                break;
            case "corn":
                input = "corn";
                break;
            case "fox":
                input = "fox";
                break;
            default:
                waitForInput = true;
        }
        return input;
    }
}
