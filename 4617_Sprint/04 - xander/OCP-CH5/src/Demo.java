import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Demo {


  public static void main(String args[]) {
    Demo d = new Demo();

    Scanner sc = new Scanner(System.in);
    String input = "";

    d.printOptionsMenu();

    input = sc.next();

    while(!input.equals("exit")) {
      d.pickLanguage(input);
      d.printWelcomeByLocale(Locale.getDefault());
      d.printTimeByChosenLanguage();
      d.printOptionsMenu();
      input = sc.next();
    }

    d.printThankYouMessage();

  }

  private Demo() {

  }

  private void pickLanguage(String input) {
    input = input.toLowerCase();

    switch (input) {
      case "en":
        Locale.setDefault(new Locale("en"));
        break;
      case "de":
        Locale.setDefault(new Locale("de"));
        break;
      case "nl":
        Locale.setDefault(new Locale("nl"));
        break;
      case "zh":
        Locale.setDefault(new Locale("zh"));
        break;
      default:
        System.out.println("We couldn't find what you are looking for, commence in english");
    }

  }

  private void printOptionsMenu() {
    System.out.println("\n" + "Select a language: " + "\n" +
        "for english : en" + "\n" +
        "for dutch : nl" + "\n" +
        "for german : de" + "\n" +
        "for chinese : zh" + "\n");
  }

  private void printWelcomeByLocale(Locale locale) {
    ResourceBundle rb = ResourceBundle.getBundle("resources.TimeInfo", locale);
    System.out.println(rb.getString("welcome"));
  }

  private void printCurrentTimeMessage() {
    ResourceBundle rb = ResourceBundle.getBundle("resources.TimeInfo", Locale.getDefault());
    System.out.println(rb.getString("time"));
  }

  private void printThankYouMessage() {
    ResourceBundle rb = ResourceBundle.getBundle("resources.TimeInfo", Locale.getDefault());
    System.out.println(rb.getString("goodbye"));
  }

  private void printTimeByChosenLanguage() {
    ZoneId zone = null;
    DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm");
    switch (Locale.getDefault().toString()) {
      case "en":
        zone = ZoneId.of("Europe/London");
        break;
      case "nl":
        zone = ZoneId.of("Europe/Amsterdam");
        break;
      case "de":
        zone = ZoneId.of("Europe/Berlin");
        break;
      case "zh":
        zone = ZoneId.of("Asia/Shanghai");
        break;
    }

    if(zone != null) {
      ZonedDateTime time = ZonedDateTime.now(zone);
      printCurrentTimeMessage();
      System.out.println(time.format(f));
    } else {
      printCurrentTimeMessage();
      System.out.println(LocalTime.now().format(f));
    }
  }

}
