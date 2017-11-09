import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Demo {

    public final Scanner SCANNER = new Scanner(System.in);
    public String[] parts;

    /* ToDo:
    *   calculate time between now and date
    *   display date in a specific format
    */
    public static void main(String[] args) {
        new Demo().startDemo();
    }

    public void startDemo() {
        displayInstruction();
        waitForInput();
        checkInput();
    }

    public void displayInstruction() {
        System.out.print("\n" 
            + "Please input a date in the following format yyyy mm dd" + 
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
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        LocalDate now = LocalDate.now();
        LocalDate birth = LocalDate.of(year, month, day);

        Period p = Period.between(birth, now);

        System.out.println( "Years: " + p.getYears() + " " +
                            "Months: " + p.getMonths() + " " +
                            "Days: " + p.getDays());
        
        startDemo();
    }

    public void errorMessage(String message) {
        System.out.println(message);
        startDemo();
    }
}