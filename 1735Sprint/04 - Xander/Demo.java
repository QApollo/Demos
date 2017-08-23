import character.*;
import java.util.*;

public class Demo {
  final static String BREAK = "\n";
  List<CharacterBase> charList = new ArrayList<CharacterBase>();

  public static void main(String[] args) {
    Demo dm = new Demo();
    dm.executeAllMethods();

  }

  public Demo() {
    Crusader velstadt = new Crusader("Velstadt");
    Necromancer elana = new Necromancer("Elana");
    DragonKnight jan = new DragonKnight("Jan");

    charList.addAll(Arrays.asList(new Crusader("Velstadt"), new Necromancer("Elana"), new DragonKnight("Jan")));
  }

  private void executeAllMethods() {
    for (CharacterBase character : this.charList ) {
      System.out.println(BREAK);
      character.executeAllMoves();
    }
  }
}
