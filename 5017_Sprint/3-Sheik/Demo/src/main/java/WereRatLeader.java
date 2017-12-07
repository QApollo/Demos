public class WereRatLeader extends Leader{

    public WereRatLeader() {
        this.name = "WereRatLeader";
        this.hitpoints = 15;
        this.attack = 5;
        this.defence = 5;
    }

    @Override
    public void abilities() {
        System.out.println("Ability: Poison");
    }
}
