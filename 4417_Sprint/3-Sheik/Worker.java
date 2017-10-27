public class Worker extends Human implements HasAJob {
    public Worker(String name, String gender, int age) {
        super(name, gender, age);
    }

    public void goToWork() {
        System.out.println("Working hard.");
    }
}