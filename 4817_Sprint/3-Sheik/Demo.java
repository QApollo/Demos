import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo {

    private final static Scanner SCANNER = new Scanner(System.in);

    private String[][] field = new String[3][3];
    private String[][] options = new String[3][3];
    private boolean gameOver = false;
    private boolean playerTurn = true;


    public static void main (String[] args) {
        new Demo().startGame();
    }

    private void startGame() {
        int slope = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = "_";
                options[i][j] = Integer.toString(j + slope);
            }
            slope += 3;
        }

        while (!gameOver) {
            turnHandler();
        }
    }

    private void displayInfo() {
        showInstructions();
        showField();
        showOptions();
    }

    private void showInstructions() {
        System.out.println("Insert a number from 1 to 9, to place an x in the corresponding box.");
        System.out.println("Waiting for input...");
    }

    private void showField() {
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.deepToString(field[i]));
        }
        
        System.out.println();
    }

    private void showOptions() {
        System.out.println();
        
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.deepToString(options[i]));
        }
                
        System.out.println();
    }
    
    private void turnHandler() {
        int input = 0;

        while (playerTurn) {
            displayInfo();
            input = waitForInput();
            validateInput(input);
            checkWin("x");
        }

        while (!playerTurn) {
            input = computerTurn();
            checkInput(input, getCurrentState());
            checkWin("o");
        }
    }

    private int waitForInput() {
        int input = 0;

        try {
            input = SCANNER.nextInt();
        } catch (Exception e) {
            errorMessage("NaN - Invalid input");
        }

        return input;
    }

    private int computerTurn() {
        return new Random().nextInt(10);
    }

    private void validateInput(int input) {
        if (input < 1 || input > 9) {
            errorMessage("Number Overflow - Invalid input");
        }

        checkInput(input, getCurrentState());
    }

    private String[] getCurrentState() {
        int slope = 0;
        String[] currentOptions = new String[9];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                currentOptions[j + slope] = options[i][j];
            }
            slope += 3;
        }

        return currentOptions;
    }

    private void checkInput(int input, String[] currentOptions) {
        if (!Arrays.asList(currentOptions).contains(Integer.toString(input))) {
            if (playerTurn) {
                System.out.println("Already chosen");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    try {
                        if (Integer.parseInt(options[i][j]) == input) {
                            enterInput(i, j);
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }
    }

    private void enterInput(int i, int j) {
        if (playerTurn) {
            field[i][j] = "x";
        } else {
            field[i][j] = "o";
        }
        
        options[i][j] = "-";

        changeTurn();
    }

    private void changeTurn(){
        playerTurn = !playerTurn;
    }

    private void checkWin(String symbol) {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[0][0] == symbol && field[0][1] == symbol && field[0][2] == symbol ||
                    field[1][0] == symbol && field[1][1] == symbol && field[1][2] == symbol ||
                    field[2][0] == symbol && field[2][1] == symbol && field[2][2] == symbol ||
                    field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol ||
                    field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol ||
                    field[0][2] == symbol && field[1][2] == symbol && field[2][2] == symbol ||
                    field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol ||
                    field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
                    showField();
                    System.out.println("Game over: " + symbol + " wins");
                    gameOver = true;
                    System.exit(0);
                }
            }
        }
    }

    private void errorMessage(String message) {
        System.out.println(message);
    }
}