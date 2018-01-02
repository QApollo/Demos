import zakmon.*;
import java.util.*;

public class GameManager {
  String speciesArray[] = {"Tulpasaur","Aangebrander","Spuitle"};
  Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    GameManager gm = new GameManager();

    gm.greeting();
    gm.selectZakmonText();
    Zakmon playerMon = new Zakmon(gm.selectZakmon());
    Zakmon cpuMon = new Zakmon(gm.cpuSelectZakmon());

    gm.battleManager(playerMon, cpuMon);
  }

  //handles the battle loop
  private void battleManager(Zakmon playerMon, Zakmon cpuMon) {
    int turn = 1; //turn counter even turns are CPU. odd turns are player

    //battle loop
    while (playerMon.getHealthStat() > 0 && cpuMon.getHealthStat() > 0) {
      battleStatus(playerMon, cpuMon);

      try {
        if (turn % 2 == 0) { //handles CPU moves
          cpuSelectMove(playerMon, cpuMon);
        } else { //handles player moves
          playerSelectMove(playerMon, cpuMon);
        }
      } catch (Exception e) {
        System.out.println("Your "+ playerMon.getSpecies() + " does not understand this move and loses their turn");
        sc.nextLine();
      }
      turn++; //Increments turn amount
    }
    winOrLoseMessage(playerMon, cpuMon);
  }

  private void cpuSelectMove(Zakmon playerMon, Zakmon cpuMon) {
    Random r = new Random();
    int move = r.nextInt(3) + 1;

    if (playerMon.isDefending()) { //remove defend if player was defending
      playerMon.removeDefend();
    }

    if (move == 1) { //decides on a move and does it
      int damage = cpuMon.attack(playerMon.getDefenseStat());
      playerMon.takeDamage(damage);
      System.out.println(System.lineSeparator() + "The enemy attacked and dealt " + damage + " damage" + System.lineSeparator());
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

    if (cpuMon.isDefending()) { //removes CPU defense if cpu was defending
      cpuMon.removeDefend();
    }

    input = sc.nextInt();
    if (input == 1) { //Player chooses a move and executes it
      int damage = playerMon.attack(cpuMon.getDefenseStat());
      cpuMon.takeDamage(damage);
      System.out.println(System.lineSeparator() + "You attacked and dealt " + damage + " Damage");
    } else if (input == 2) {
      playerMon.defend();
      System.out.println(System.lineSeparator() + "You defended");
    } else if (input == 3) {
      System.out.println("You can't run this is an arena battle!");
    } else {
      System.out.println("Invalid move, Your zakMon dozes around and loses a turn");
    }
  }

  private void winOrLoseMessage(Zakmon playerMon, Zakmon cpuMon) {
    if (cpuMon.getHealthStat() <= 0) {
      System.out.println("You won the battle!" + System.lineSeparator() + "You've earned 100 zakCoin$");
    } else {
      System.out.println("You lost the battle!" + System.lineSeparator() + "Doesn't seem like you have what you need to become a zakMon master");
    }
  }

  /*-----------------selecting---------------------*/
  //handle selecting zakmon
  private String selectZakmon() {
    boolean valid = false;
    int input = 0;
    while (!valid) {
      try {
        input = sc.nextInt();

        /* chose to take an value from an array instead of hard coding the zakmon in a if or switch case
          would make it easier to add other zakmon by just adding them to the array and in the zakmon class add anothercase in the switch case
        */
        if (input <= speciesArray.length && input > 0) {
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
    /* since arrays are zero indexed and the user can input 1 to 3 which in an array would be 0 to 2
       I take the input decrement it by one to get the correct index from the user choice
       Example user inputs 2 which is Aangebrander. Aangebrander is the second zakmon in the array at index[1] input 2 - 1 = 1
    */
    selectedZakmonMessage(input-1);
    return speciesArray[input-1];
  }

  //select cpu zakmon
  private String cpuSelectZakmon() {
    Random r = new Random();
    int index = r.nextInt(3) +0;
    System.out.println("Your opponent selected "+ speciesArray[index] + System.lineSeparator());
    return speciesArray[index];
  }

  /*-------------------Messages------------------*/
  //print out the greeting
  private void greeting() {
    System.out.println("Greetings, welcome to the zakmon Arena."
    +System.lineSeparator()+
    "You the newcomer will fight against our lowest ranked opponent."
    +System.lineSeparator()+
    "Enjoy!"
    +System.lineSeparator());
  }

  //print menu for selecting zakmon
  private void selectZakmonText() {
    System.out.println("Select your zakmon!"
    +System.lineSeparator()+
    "1) Tulpasaur"
    +System.lineSeparator()+
    "2) Aangebrander"
    +System.lineSeparator()+
    "3) Spuitle");
  }

  //print message after selecting zakmon
  private void selectedZakmonMessage(int input) {
    System.out.println(System.lineSeparator() + "You selected " + speciesArray[input] + "!" + System.lineSeparator());
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

}
