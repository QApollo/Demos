/*
Since my demo for chapter 2 has grown beyond the scope it should have.
This file will contain the parts relevant to chapter 2 of OCA
*/

//properties of the the zakmon class
String[] speciesArray;
private String species;

public int health = 100;
private int attackStat = 100;
private int defenseStat = 100;
public boolean isDefending;

//this is the constructor used for setting the the stats of our zakmon in this little game
public Zakmon(String species, String[] speciesArray) {
    this.species = species;
    this.speciesArray = speciesArray;
    if(this.speciesArray[0] == this.species){ //Tulpasaur
        setStats(1.05, 0.9, 1.1);
    } else if(this.speciesArray[1] == this.species) { //Aangebrander
        setStats(0.9, 1.1, 1.0);
    } else if(this.speciesArray[2] == this.species) { //Spuitle
        setStats(1.0, 1.0, 1.0);
    }
}

//The set stats function which takes a double as param and passes that to the individual stat setters
private void setStats(double healthModifier, double attackStatModifier, double defenseStatModifier) {
  setHealthStat(healthModifier);
  setAttackStat(attackStatModifier);
  setDefenseStat(defenseStatModifier);
}

//these functions set the individual stats according to the modifiers passed from the setStats function above
//here I use compound assignment operators set the stats to their new value and cast them back to an int
private void setHealthStat(double healthModifier) {
  this.health *= healthModifier;
}

private void setAttackStat(double attackStatModifier) {
  this.attackStat *= attackStatModifier;
}

private void setDefenseStat(double defenseStatModifier) {
  this.defenseStat *= defenseStatModifier;
}

public void takeDamage(int damage) {
  this.health -= damage;
}

//in this function I want to calcute some damage. some order of operation is shown here and type casting the calculation back to an int
public int attack(int enemyDefenseStat) {
  Random r = new Random();
  int damage = (int)(this.attackStat - enemyDefenseStat * 0.65) + r.nextInt(9) + 0;

  return damage;
}

/*this is a function from the GameManager class
this function named the battleManager handles the battling logic in a while loop
I also count the turns to decide if a turn is odd or even by using the modulo operator
on an odd turn the player can use a move and on even turns the CPU does a move
*/
private void battleManager(Zakmon playerMon, Zakmon cpuMon) {
  int turn = 1; //turn counter even turns are CPU. odd turns are player

  //battle loop
  while(playerMon.getHealthStat() > 0 && cpuMon.getHealthStat() > 0) {
    battleStatus(playerMon, cpuMon);

    try {
      if(turn % 2 == 0) { //handles CPU moves
        cpuSelectMove(playerMon, cpuMon);
      } else { //handles player moves
        playerSelectMove(playerMon, cpuMon);
      }
    } catch(Exception e) {
      System.out.println("Your "+ playerMon.getSpecies() + "Does not understand this move and loses their turn");
      sc.nextLine();
    }
    turn++; //Increments turn amount
  }
  winOrLoseMessage(playerMon, cpuMon);
}

/* This function handles the cpu move it is fairly simple I grab a int from r.nextInt() it is 1,2 or 3
Depending on what the int value is the CPU opponent does a certain move
*/
private void cpuSelectMove(Zakmon playerMon, Zakmon cpuMon) {
  Random r = new Random();
  int move = r.nextInt(3) + 1;

  if(playerMon.isDefending == true) { //remove defend if player was defending
    playerMon.removeDefend();
  }

  if(move == 1) { //decides on a move and does it
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

/* Takes an input from the user and by the same logic as the function above does a move

*/
private void playerSelectMove(Zakmon playerMon, Zakmon cpuMon) {
  int input;
  playerMoveSelectMessage();

  if(cpuMon.isDefending == true) { //removes CPU defense if cpu was defending
    cpuMon.removeDefend();
  }

  input = sc.nextInt();
  if(input == 1) { //Player chooses a move and executes it
    int damage = playerMon.attack(cpuMon.getDefenseStat());
    cpuMon.takeDamage(damage);
    System.out.println(System.lineSeparator() + "You attacked and dealt " + damage + " Damage");
  } else if(input == 2) {
    playerMon.defend();
    System.out.println(System.lineSeparator() + "You defended");
  } else if(input == 3) {
    System.out.println("You can't run this is an arena battle!");
  } else {
    System.out.println("Invalid move, Your zakMon dozes around and loses a turn");
  }

  /*Handles selecting the user his/her zakmon*/
  private String selectZakmon() {
    boolean valid = false;
    int input = 0;
    while(!valid) {
      try {
        input = sc.nextInt();

        /* chose to take an value from an array instead of hard coding the zakmon in a if or switch case
          would make it easier to add other zakmon by just adding them to the array and in the zakmon class add anothercase in the switch case
        */
        if(input <= speciesArray.length && input > 0) { // the input has to be smaller or equal to the length of the array and it the value has to be bigger then 0
          valid = true;
        } else {
          System.out.println("Invalid zakmon chosen choose: 1) 2) or 3)");
        }
      } catch(Exception e) {
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
  
}
