package classes;

public abstract class Character {

    public String name;

    public Character() {
        name = "Character";
    }

    public abstract void attackOptions();
    public abstract void defenseOptions();

    protected void attack() {
        System.out.println("Punch");
    }

    protected void defense() {
        System.out.println("Block");
    }

}
