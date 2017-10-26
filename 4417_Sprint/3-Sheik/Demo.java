public class Demo {

    public static void main(String[] args) {
        new Demo();
    }

    public Demo() {
        Human human = createHuman();

        introduction(human);
        askForDate(human);
        askToWork(human);
    }

    public Human createHuman() {
        Human human = new Human("Henk", "Male", 20);

        return human;
    }

    public void introduction(Human human) {
        System.out.println("Hi, I am a "
                            +human.getGender()+
                            " named "
                            +human.getName()+
                            " and I'm "
                            +human.getAge()+
                            " years old.");
    }

    public void askForDate(Human human) {
        IsABoyfriend boyfriend = human;
        boyfriend.goOnDate();
    }

    public void askToWork(Human human) {
        IsAnEmployee employee = human;
        employee.goToWork();
    }

}