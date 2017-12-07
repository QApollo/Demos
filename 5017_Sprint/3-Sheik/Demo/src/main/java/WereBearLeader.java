public class WereBearLeader extends Leader{

    public WereBearLeader() {
        this.name = "WereBearLeader";
        this.hitpoints = 50;
        this.attack = 20;
        this.defence = 10;
    }

    @Override
    public void abilities() {
        System.out.println("Ability: Crush");
    }
}
