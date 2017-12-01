import java.util.Scanner;

public class Demo{
    static double results = 0;
    public static double calculate(double a, double b, String operator) {
        switch(operator){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Please do not divided by zero.");
                return a / b;
            default:
                throw new IllegalArgumentException("Operator is not illegal.");
        }
    }

    public static void main(String[] args) {
        double num1 = 0;
        double num2 = 0;
        String operator = "";

        Scanner sc = new Scanner(System.in);
        String inputStr = "";
        while(!inputStr.equals("exit")) {
            inputStr = sc.nextLine().trim().toLowerCase();
            String[] input  = inputStr.split(" ");

            try{
                switch(input.length){
                    case 0:
                        break;
                    case 1:
                        results = Double.parseDouble(input[0]);
                        break;
                    case 2:
                        operator = input[0];
                        num1 = Double.parseDouble(input[1]);
                        results = calculate(results, num1, operator);
                        break;
                    case 3:
                        num1 = Double.parseDouble(input[0]);
                        num2 = Double.parseDouble(input[2]);
                        operator = input[1];
                        results = calculate(num1, num2, operator);
                        break;
                    default:
                        throw new IllegalArgumentException("Operator is illegal.");
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Input illegal.");
            }

            System.out.println("The result is: " + results);
        }
    }
}
