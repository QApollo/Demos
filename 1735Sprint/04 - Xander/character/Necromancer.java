package character;

import character.typeinterfaces.*;

public class Necromancer extends CharacterBase implements MagicInterface, UnholyInterface {

  public Necromancer(String name) {
    level = 0;
    exp = 0;
    expToLevel = 100;

    health = 90;
    stamina = 110;

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

  public void magicAttack() {
    System.out.println(name + " fires a bolt of pure magic");
  }

  public void hover() {
    System.out.println(name + " starts floating mid-air");
  }

  public void curse() {
    System.out.println(name + " starts muttering a curse");
  }

  public void summonSkeleton() {
    System.out.println(name + " is summoning skeletons");
  }

  public void executeAllMoves() {
    attack();
    magicAttack();
    hover();
    curse();
    summonSkeleton();
  }

}
