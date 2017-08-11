package zakmon;

import java.util.*;

public class Zakmon {

  private String species;
  private int health = 100;
  private int attackStat = 100;
  private int defenseStat = 100;
  private boolean isDefending;

  //constructor which calls the setStats function with modifiers based on the species
  public Zakmon(String species) {
      this.species = species;
      switch(this.species) {
        case "Tulpasaur":
          setStats(1.05, 0.9, 1.1);
          break;
        case "Aangebrander":
          setStats(0.9, 1.1, 1.0);
          break;
        case "Spuitle":
          setStats(1.0, 1.0, 1.0);
          break;
        case "Rupspie":
          setStats(0.5, 0.3, 0.3);
          break;
        case "Duifgey":
          setStats(1.0, 1.1, 0.8);
          break;
        case "Bellspruit":
          setStats(0.8, 1.2, 1.0);
          break;
        case "OehoeOhoe":
            setStats(0.9, 1.0, 1.1);
            break;
        case "Noctuil":
          setStats(1.0, 1.1, 0.8);
          break;
        case "Paraneon":
          setStats(0.8, 1.2, 0.9);
          break;
        default:
          setStats(1.0,1.0,1.0);
          break;
      }
    }

  //set all stats by calling the setter with the modifiers passed in the constructor
  private void setStats(double healthModifier, double attackStatModifier, double defenseStatModifier) {
    setHealthStat(healthModifier);
    setAttackStat(attackStatModifier);
    setDefenseStat(defenseStatModifier);
  }

  //set health stat
  private void setHealthStat(double healthModifier) {
    this.health *= healthModifier;
  }

  //set attack stat
  private void setAttackStat(double attackStatModifier) {
    this.attackStat *= attackStatModifier;
  }

  //set defense stat
  private void setDefenseStat(double defenseStatModifier) {
    this.defenseStat *= defenseStatModifier;
  }

  //return health stat
  public int getHealthStat() {
    return health;
  }

  //return attack stat
  public int getAttackStat() {
    return attackStat;
  }

  //return defense stat
  public int getDefenseStat() {
    return defenseStat;
  }

  //return species
  public String getSpecies() {
    return this.species;
  }

  public boolean isDefending() {
    return this.isDefending;
  }

  //applies damage parameter to objects health
  public void takeDamage(int damage) {
    this.health -= damage;
  }

  //handles damage. calculated with defense and attack stat and a random number for more variation
  public int attack(int enemyDefenseStat) {
    Random r = new Random();
    int damage = (int)(this.attackStat - enemyDefenseStat * 0.65) + r.nextInt(9) + 0;

    if (damage < 0) {
      damage = 0 + r.nextInt(5) + 1;
    }

    System.out.println(System.lineSeparator() + species + " attacked and dealt " + damage + " damage");
    return damage;
  }

  //Increase defense stat and set defending to true
  public void defend() {
    this.defenseStat += 10;
    this.isDefending = true;
    System.out.println(System.lineSeparator() + species +" defended");
  }

  //Reduces the defense stat and sets defending to false
  public void removeDefend() {
    this.defenseStat -= 10;
    this.isDefending = false;
  }
}
