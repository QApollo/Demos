package classes;

public class Paladin extends Knight {

    public Paladin() {
        name = "Paladin";
    }

    public void attackOptions() {
        super.attackOptions();
        magicAttack();
    }

    public void defenseOptions() {
        super.defenseOptions();
        magicDefense();
    }

    private void magicAttack() {
        System.out.println("Consecrate");
    }

    private void magicDefense() {
        System.out.println("Holy Light");
    }
}
