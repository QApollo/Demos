import character.CharacterBase;
import character.Crusader;
import character.Necromancer;
import character.DragonSlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Demo {
  final static String BREAK = "\n";
  private List<CharacterBase> charList = new ArrayList<CharacterBase>();

  public static void main(String[] args) {
    Demo dm = new Demo();
    dm.executeCharacterMoveSet();

  }

  public Demo() {
    charList.addAll(Arrays.asList(new Crusader("Gwyn"), new Necromancer("Nito"), new DragonSlayer("Ornstein")));
  }

  private void executeCharacterMoveSet() {
    for (CharacterBase character : this.charList ) {
      System.out.println(BREAK);
      character.executeAllMoves();
    }
  }

}
