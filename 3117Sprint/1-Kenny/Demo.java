import java.util.*;
import java.time.*;

public  class Demo {  
    String[] countries = {
        "Amsterdam",
        "Berlin",
        "Hongkong",
        "Tokyo"
    };

    LocalTime localTime;

    Scanner sc = new Scanner(System.in);

    // Main
    public static void main(String args[]) {
        Demo demo = new Demo();
    }

    // Constructor
    public Demo() {
        greeting();
        showLocalTime();
        showOptions();
        checkInput();
    }

    private void greeting() {
        System.out.println("Hi there, Choose one of the countries");
    }

    private void showLocalTime() {
         localTime = LocalTime.now();
        //Would be nice: Reformat date from 'HH;mm;ss;sss' to 'HH:mm'
        System.out.println("The current time is: " + localTime);
    }

    private void showOptions() {
        System.out.println("Where do you want to travel?");
        for (int i = 0; i < countries.length; i++) {
            System.out.println(i + ") " + countries[i]);
        }
    }

    private void checkInput() {
        boolean correctInput = false;
        String destination = "";
        
        do {
            String input = sc.next();

            // It should be something like (If input matches with index)
            if (input.toLowerCase().matches("0|1|2|3")) {
                destination += input;
                correctInput = true;
            } else {
                System.out.println("Please enter a valid command.");
                showOptions();
            }
        } while (!correctInput);
        int countryNumber = Integer.parseInt(destination);
        System.out.println("You choose " + countries[countryNumber]); 
        showDestinationTime(countryNumber);
    }  

    private void showDestinationTime(int cNumber) {

        // Would be nice: Format it to EU settings
        // System.out.println(datetime.ofLocalizedDateTime("dd:MM:yyyy - HH:mm"));

        // Would be nice: make a Multidimensional array with GTM data. It would mean that I only need one line of code to display all different times.
        switch (cNumber) {
            case (2) :
                System.out.println("Time in chosen country: "+ localTime.plusHours(6));
            break;
            case (3) :
                System.out.println("Time in chosen country: "+ localTime.plusHours(7));
            break;
            default:
                System.out.println("Time in chosen country: "+ localTime);
            break;
        }

    }   
}