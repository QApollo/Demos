import java.util.*;
import java.time.*;
import java.time.format.*;

public class Demo {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = "";

    Siri siri = new Siri();
    SassySiri sassySiri = new SassySiri();

    while(!input.equals("exit")) {

    input = sc.nextLine().trim().toLowerCase();

    if (input.contains("sassy")) {
      siri.chatbotMode = "sassy";
      System.out.println("SassySiri model on.");
    }

    switch (siri.chatbotMode) {
      case "sassy":
        if (input.contains("what time")) {
          sassySiri.outputTime();
        } else {
          sassySiri.response();
        }
        break;

      case "normal":
        if (input.contains("what time")) {
          siri.outputTime();
        } else {
          siri.response();
        }
        break;
    }

  }
  }
}
