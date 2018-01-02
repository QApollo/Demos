import java.util.Scanner;

interface Calculation {
    public double calculate(double a, double b);
}

public class Demo {

    public final Scanner SCANNER = new Scanner(System.in);
    public String[] parts;

    public Calculation addition = (x, y) -> x + y;
    public Calculation subtraction = (x, y) -> x - y;
    public Calculation multiplication = (x, y) -> x * y;
    public Calculation division = (x, y) -> (x == 0 | y == 0) ? 0 : x / y;

    protected void doSomething() {

    }

    public static void main(String[] args) {
        new Demo().startCalculator();
    }

    public void startCalculator() {
        displayInstruction();
        waitForInput();
        checkInput();
    }

    public void displayInstruction() {
        System.out.print("\n" 
            + "Instructions - Input two numbers with one of the following in between: +, -, *, /." + 
            "\n");
    }

    public void waitForInput() {
        parts = SCANNER.nextLine().split(" ");
    }

    public void checkInput() {
        
        if (parts.length == 3) {
            calculateInput();
        } else {
            errorMessage("Invalid input");
        }
    }

    public void calculateInput() {
        double a = Double.parseDouble(parts[0]);
        double b = Double.parseDouble(parts[2]);
        double result = 0;
        
        switch(parts[1]) {
            case "+":
                result = addition.calculate(a, b);
                break;
            case "-":
                result = subtraction.calculate(a, b);
                break;
            case "*":
                result = multiplication.calculate(a, b);
                break;
            case "/":
                result = division.calculate(a, b);
                break;
        }

        System.out.println(result);
        startCalculator();
    }

    public void errorMessage(String message) {
        System.out.println(message);
        startCalculator();
    }

}