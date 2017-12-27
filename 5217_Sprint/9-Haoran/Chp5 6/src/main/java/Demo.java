import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        Locale us = Locale.US;
        Locale uk = Locale.UK;
        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("MM dd yyyy, HH:mm").withLocale(us);
        DateTimeFormatter ukFormatter = DateTimeFormatter.ofPattern("dd MM yyyy, HH:mm").withLocale(uk);

        ZonedDateTime dateTime;
        System.out.println("Input US format: MM dd yyyy, HH:mm");

        while (!input.equals("exit")) {
            input = scanner.nextLine().trim().toLowerCase();
            try{
                LocalDateTime localDateTime = LocalDateTime.parse(input, usFormatter);
                dateTime = ZonedDateTime.of(localDateTime, ZoneId.of("US/Eastern"));
                System.out.println(dateTime.format(ukFormatter));
            } catch (DateTimeParseException | IndexOutOfBoundsException e){
                dateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
                System.out.println("CET time:" + dateTime.format(ukFormatter));
            }
        }
    }
}
