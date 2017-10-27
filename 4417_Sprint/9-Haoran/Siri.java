/*
Demo for OCA chapter 2 & 3
We upgraded the Siri from chapter 1 to be able to answer certain question
*/
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Siri {
  public static String subjects[] = {"Your mom ", "Xander ", "Siri ", "Google ", "Qualogy ", "Aeron ", "Alfonso ", "Sheik ", "Elena ", "Apple ", "Koala ", "The Dutch ", "Octopus ", "She ", "He "};
  public static String verbs[] = {"eats ", "has ", "is ", "plays ", "goes to ", "studies ", "is doing ", "jumps through ", "waves at ", "is writing on the"};
  public static String objects[] = {"pineapples.", "dogs.", "candies.", "whiteboards.", "shoes.", "coffee."};
  public static DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

  public static void main(String[] args) {

    Random randIndex = new Random();

    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine().trim().toLowerCase();
    String output;

      while(!input.equals("exit")) {
        output = "";
        //System.out.println(input);
        input = sc.nextLine().trim().toLowerCase();

        // Time and Date
        if (input.contains("what time")) {
          LocalTime time = LocalTime.now();
          System.out.print("It's " + mediumF.format(time));

        } else if (input.contains("what day")) {
          LocalDate date = LocalDate.now();
          System.out.print("Today is " + date);

        } else if (input.startsWith("are")||input.startsWith("is")||input.startsWith("am")) {
          if (input.contains("is")) {
            System.out.print("No, ");
          } else {
            System.out.print("Yes, ");
          }
        } else {
          output = subjects[randIndex.nextInt(subjects.length)].concat(verbs[randIndex.nextInt(verbs.length)]).concat(objects[randIndex.nextInt(objects.length)]);
        }

        System.out.println(output);
    }
  }

}
