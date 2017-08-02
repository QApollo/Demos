package classes;

public class Knight extends Character {

    public Knight() {
        name = "Knight";
    }

    public void attackOptions() {
        attack();
        meleeAttack();
    }

    public void defenseOptions() {
        defense();
        meleeDefense();
    }

    public void meleeAttack() {
        System.out.println("Sword strike");
    }

    public void meleeDefense() {
        System.out.println("Shield block");
    }
}
