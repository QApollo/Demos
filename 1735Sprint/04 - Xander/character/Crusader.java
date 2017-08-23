package character;

import character.typeinterfaces.*;

public class Crusader extends CharacterBase implements MeleeInterface, HolyInterface {

  public Crusader(String name) {
    level = 0;
    exp = 0;
    expToLevel = 100;

    health = 120;
    stamina = 80;

    this.name = name;
  }

  public int getHealth() {
    return health;
  }

  public int getStamina() {
    return stamina;
  }

  public int getLevel() {
    return level;
  }

  public int getExp() {
    return exp;
  }

  public int getExpToLevel() {
    return expToLevel;
  }

  public String getName() {
    return name;
  }

  //MOVES
  public void attack() {
    System.out.println(name + " slaps");
  }

  public void meleeAttack() {
    System.out.println(name + " Swings his sword");
  }

  public void block() {
      System.out.println(name + " Prepares to defend against an attack");
  }

  public void lightOfHealing() {
    System.out.println(name + " Casts light of healing on " + name);
    health += 10;
  }

  public void pray() {
    System.out.println(name + " Prays");
    stamina += 10;
  }

  public void executeAllMoves() {
    attack();
    meleeAttack();
    block();
    lightOfHealing();
    pray();
  }

}
