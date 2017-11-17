/*Chapter 5 Class design
1. Inheritance: one parent class and may implement multiple interfaces
2. Constructors and overriding rules: No-argument constructor needs an explicit call
3. Overloaded, overriden and hidden methos; Hidden variables
4. Abstract class and interfaces, default/static interface methods
5. Polymorphism
*/
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Siri implements Chatbot {

  private String chatbotMode = "normal";

  public void setChatbotMode(String chatbotMode){
    this.chatbotMode = chatbotMode;
  }

  public String getChatbotMode(){
    return this.chatbotMode;
  }

  public void outputTime() {
    LocalTime time = LocalTime.now();
    System.out.println("It's " + Chatbot.mediumF.format(time));
  }
}
