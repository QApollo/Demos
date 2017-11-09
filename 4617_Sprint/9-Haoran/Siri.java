/*Chapter 5 Class design
1. Inheritance: one parent class and may implement multiple interfaces
2. Constructors and overriding rules: No-argument constructor needs an explicit call
3. Overloaded, overriden and hidden methos; Hidden variables
4. Abstract class and interfaces, default/static interface methods
5. Polymorphism
*/
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Siri implements Chatbot {

  public static String chatbotMode = "normal";

  public Siri() {
    System.out.println("Siri normal mode on.");
  }

  public void outputTime() {
    LocalTime time = LocalTime.now();
    System.out.println("It's " + Chatbot.mediumF.format(time));
  }
}
