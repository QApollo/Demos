abstract class Follower {
    String name;
    int hitpoints;
    int attack;
    int defence;

    void getStatistics() {
        System.out.println("Name: " + this.name);
        System.out.println("HP: " + this.hitpoints);
        System.out.println("ATK: " + this.attack);
        System.out.println("DEF: " + this.defence);
    }
}
