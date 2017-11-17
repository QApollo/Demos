import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Demo {

  private void siriMode(String input, Siri siri){

    if (input.contains("sassy") && "normal".equals(siri.getChatbotMode())) {
      siri.setChatbotMode("sassy");
      System.out.println("SassySiri model on.");
    } else if ("sassy".equals(siri.getChatbotMode()) && input.contains("normal")) {
      siri.setChatbotMode("normal");
      System.out.println("Normal model on.");
    } else {
      throw new IllegalArgumentException("Siri model does not exist.");
    }
  }

  private void response(String input, Siri siri) {
    switch (siri.getChatbotMode()) {
      case "sassy":
        Siri sassySiri = new SassySiri();
        if (input.contains("what time")) {
          sassySiri.outputTime();
        } else {
          sassySiri.response();
        }
        break;

      default:
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

    while (!input.equals("exit")) {
      input = sc.nextLine().trim().toLowerCase();

      try {
        if (input.contains("siri mode")) {
          demo.siriMode(input, siri);
        }
      } catch (IllegalArgumentException e) {
        System.out.println(e);
      }
      demo.response(input, siri);
    }
  }
}
