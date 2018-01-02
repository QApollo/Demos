import java.util.*;
import java.time.*;
import java.time.format.*;

public class Demo {

  private void siriMode(String input, Siri siri) {

    if (input.contains("sassy") && "normal".equals(siri.getChatbotMode())) {
      siri.setChatbotMode("sassy");
      System.out.println("SassySiri model on.");
    } else if ("sassy".equals(siri.getChatbotMode()) && input.contains("normal") ) {
      siri.setChatbotMode("normal");
      System.out.println("Normal model on.");
    }
  }

  private void response(String input, Siri siri){
    switch (siri.getChatbotMode()) {
      case "sassy":
      Siri sassySiri = new SassySiri();
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

  public static void main(String[] args) {
    Demo demo = new Demo();

    Scanner sc = new Scanner(System.in);
    String input = "";

    Siri siri = new Siri();
    System.out.println("Normal model on.");
    SassySiri sassySiri = new SassySiri();

    while(!input.equals("exit")) {

    input = sc.nextLine().trim().toLowerCase();

    demo.siriMode(input, siri);
    demo.response(input, siri);
    }
  }
}
