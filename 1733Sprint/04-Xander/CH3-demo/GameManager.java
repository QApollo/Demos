import zakmon.*;
import java.util.*;
import java.time.*;

public class GameManager {
  private List<String> speciesList = new ArrayList<>();
  private Scanner sc = new Scanner(System.in);
  private LocalTime currentTime = LocalTime.now();

  public static void main(String[] args) {
    GameManager gm = new GameManager();
    gm.populateSpeciesList();
    gm.greeting();
    gm.selectZakmonText();

    Zakmon playerMon = new Zakmon(gm.selectZakmon());
    Zakmon cpuMon = new Zakmon(gm.cpuSelectZakmon());

    gm.battleManager(playerMon, cpuMon);
  }

  private void battleManager(Zakmon playerMon, Zakmon cpuMon) {
    int turn = 1;

    while (playerMon.getHealthStat() > 0 && cpuMon.getHealthStat() > 0) {
      battleStatus(playerMon, cpuMon);

      try {
        if (turn % 2 == 0) {
          cpuSelectMove(playerMon, cpuMon);
        } else {
          playerSelectMove(playerMon, cpuMon);
        }
      } catch (Exception e) {
        System.out.println("Your "+ playerMon.getSpecies() + " does not understand this move and loses their turn");
        sc.nextLine();
      }
      turn++;
    }
    winOrLoseMessage(playerMon, cpuMon);
  }

  private void cpuSelectMove(Zakmon playerMon, Zakmon cpuMon) {
    Random r = new Random();
    int move = r.nextInt(3) + 1;

    if (playerMon.isDefending()) {
      playerMon.removeDefend();
    }

    if (move == 1) {
      int damage = cpuMon.attack(playerMon.getDefenseStat());
      playerMon.takeDamage(damage);
      if (cpuMon.getSpecies().equals("Rupspie")) {
        System.out.println(System.lineSeparator() + "The enemy Rupsie crawls towards you inflicting psychological damage for " + damage + " damage" + System.lineSeparator());
      } else {
        System.out.println(System.lineSeparator() + "The enemy attacked and dealt " + damage + " damage" + System.lineSeparator());
      }
    } else if (move == 2) {
      cpuMon.defend();
      System.out.println(System.lineSeparator() + "The opponent defended" + System.lineSeparator());
    } else if (move == 3) {
      System.out.println("The enemy " + cpuMon.getSpecies() + " tries to run but it failed.");
    }
  }

  private void playerSelectMove(Zakmon playerMon, Zakmon cpuMon) {
    int input;
    playerMoveSelectMessage();

    if (cpuMon.isDefending()) {
      cpuMon.removeDefend();
    }

    input = sc.nextInt();
    switch (input) {
      case 1:
        int damage = playerMon.attack(cpuMon.getDefenseStat());
        cpuMon.takeDamage(damage);

        if (playerMon.getSpecies().equals("Rupspie")) {
          System.out.println(System.lineSeparator() + "Rupsie crawls towards it's opponent inflicting psychological damge for " + damage + " Damage");
        } else {
          System.out.println(System.lineSeparator() + "You attacked and dealt " + damage + " Damage");
        }
        break;
      case 2:
        playerMon.defend();
        System.out.println(System.lineSeparator() + "You defended");
        break;
      case 3:
        System.out.println("You can't run this is an arena battle!");
        break;
      default:
        System.out.println("Invalid move, Your zakMon dozes around and loses a turn");
        break;
    }
  }

  /*-----------------selecting---------------------*/
  private void populateSpeciesList() {
    LocalTime morningTime = LocalTime.of(12,00);
    LocalTime noonTime = LocalTime.of(18,00);
    LocalTime testTime = LocalTime.of(21,00);

    if (testTime.isBefore(morningTime)) {
      speciesList.add("Tulpasaur");
      speciesList.add("Aangebrander");
      speciesList.add("Spuitle");
    } else if (testTime.isBefore(noonTime)) {
      speciesList.add("Rupspie");
      speciesList.add("Duifgey");
      speciesList.add("Bellspruit");
    } else if (testTime.isAfter(noonTime)) {
      speciesList.add("OehoeOhoe");
      speciesList.add("Noctuil");
      speciesList.add("Paraneon");
    }
  }

  private String selectZakmon() {
    boolean valid = false;
    int input = 0;
    while (!valid) {
      try {
        input = sc.nextInt();
        if (input <= speciesList.size() && input > 0) {
          valid = true;
        } else {
          System.out.println("Invalid zakmon chosen choose: 1) 2) or 3)");
        }
      } catch (Exception e) {
        System.out.println("This isn't an ABC question. Please respect that."
        +System.lineSeparator()+
        "Choose: 1) 2) or 3)");
        sc.nextLine();
      }
    }

    selectedZakmonMessage(input-1);
    return speciesList.get(input-1);
  }

  private String cpuSelectZakmon() {
    Random r = new Random();
    int index = r.nextInt(3) +0;
    System.out.println("Your opponent selected "+ speciesList.get(index) + System.lineSeparator());
    return speciesList.get(index);
  }

  /*-------------------Messages------------------*/
  private void greeting() {
    System.out.println("Greetings, welcome to the zakmon Arena."
    +System.lineSeparator()+
    "You the newcomer will fight against our lowest ranked opponent."
    +System.lineSeparator()+
    "Enjoy!"
    +System.lineSeparator());
  }

  private void selectZakmonText() {
    System.out.println("Select your zakmon!"
    +System.lineSeparator()+
    "1) " + speciesList.get(0)
    +System.lineSeparator()+
    "2) " + speciesList.get(1)
    +System.lineSeparator()+
    "3) " + speciesList.get(2));
  }

  private void selectedZakmonMessage(int input) {
    System.out.println(System.lineSeparator() + "You selected " + speciesList.get(input) + "!" + System.lineSeparator());
  }

  private void playerMoveSelectMessage() {
    System.out.println("1)Attack"
    +System.lineSeparator()+
    "2)Defend"
    +System.lineSeparator()+
    "3)Run"
    +System.lineSeparator());
  }

  private void battleStatus(Zakmon playerMon, Zakmon cpuMon) {
    System.out.println(System.lineSeparator() + "Your health is:" + playerMon.getHealthStat());
    System.out.println("The enemies health is: " + cpuMon.getHealthStat() + System.lineSeparator());
  }

  private void winOrLoseMessage(Zakmon playerMon, Zakmon cpuMon) {
    if (cpuMon.getHealthStat() <= 0) {
      System.out.println("You won the battle!" + System.lineSeparator() + "You've earned 100 zakCoin$");
    } else {
      System.out.println("You lost the battle!" + System.lineSeparator() + "Doesn't seem like you have what you need to become a zakMon master");
    }
  }

}
