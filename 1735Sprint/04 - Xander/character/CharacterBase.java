package character;

public abstract class CharacterBase {
  protected int health;
  protected int stamina;

  protected int level;
  protected int exp;
  protected int expToLevel;

  protected String name;

  public abstract int getHealth();

  public abstract int getStamina();

  public abstract int getLevel();

  public abstract int getExp();

  public abstract int getExpToLevel();

  public abstract String getName();

  public abstract void attack();

  public abstract void executeAllMoves();

}
