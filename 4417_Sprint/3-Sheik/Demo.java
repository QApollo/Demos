public class Demo {

    public static void main(String[] args) {
        new Demo();
    }

    public Demo() {
        Human human = createHuman();

        introduction(human);
        goOnDate(human);
        goToWork(human);
    }

    public Human createHuman() {
        Romanticus human = new Romanticus("Roman", "Male", 20);
        // Worker human = new Worker("Wilma", "Female", 30);

        return human;
    }

    public void introduction(Human human) {
        System.out.println("Hi, I am a "
                            + human.getGender() +
                            " named "
                            + human.getName() +
                            " and I'm "
                            + human.getAge() +
                            " years old.");
    }

    public void goOnDate(Human human) {
        ((HasARelationship)human).goOnDate();
    }

    public void goToWork(Human human) {
        // ((HasAJob)human).goToWork();
    }

}