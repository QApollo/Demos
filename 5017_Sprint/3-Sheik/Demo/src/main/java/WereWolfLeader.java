public class WereWolfLeader extends Leader{

    public WereWolfLeader() {
        this.name = "WereWolfLeader";
        this.hitpoints = 25;
        this.attack = 10;
        this.defence = 5;
    }

    @Override
    public void abilities() {
        System.out.println("Ability: Howl");
    }
}
