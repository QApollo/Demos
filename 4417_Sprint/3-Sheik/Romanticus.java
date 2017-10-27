public class Romanticus extends Human implements HasARelationship {
    public Romanticus(String name, String gender, int age) {
        super(name, gender, age);
    }

    public void goOnDate() {
        System.out.println("Going on a romantic date.");
    }
}