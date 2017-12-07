public abstract class Follower {
    public String name;
    public int hitpoints;
    public int attack;
    public int defence;

    public void getStatistics() {
        System.out.println("Name: " + this.name);
        System.out.println("HP: " + this.hitpoints);
        System.out.println("ATK: " + this.attack);
        System.out.println("DEF: " + this.defence);
    }
}
