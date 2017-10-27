// public class Human implements IsABoyfriend, HasAJob {
public class Human {

    private String name;
    private String gender;
    private int age;

    public Human(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    // public void goOnDate() {
    //     System.out.println("Going on a romantic date.");
    // }

    // public void goToWork() {
    //     System.out.println("Working hard.");
    // }

}

