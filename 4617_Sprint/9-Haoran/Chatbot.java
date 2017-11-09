import java.util.*;
import java.time.*;
import java.time.format.*;

public abstract interface Chatbot {
  public static final List<String> subjects = Arrays.asList("Your mom ", "Xander ", "Siri ", "Google ", "Qualogy ", "Aeron ", "Alfonso ", "Sheik ", "Elena ", "Apple ", "Koala ", "The Dutch ", "Octopus ", "She ", "He ");
  public static final List<String> verbs = Arrays.asList("eats ", "has ", "is ", "plays ", "goes to ", "studies ", "is doing ", "jumps through ", "waves at ", "is writing on the");
  public static final List<String> objects = Arrays.asList("pineapples.", "dogs.", "candies.", "whiteboards.", "shoes.", "coffee.");
  public static final DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
  public static final Random randIndex = new Random();

  public abstract void outputTime();

  public default void response() {
    System.out.println(subjects.get(randIndex.nextInt(subjects.size()))
                        .concat(" ").concat(verbs.get(randIndex.nextInt(verbs.size())))
                        .concat(" ").concat(objects.get(randIndex.nextInt(objects.size()))));
  }
}
