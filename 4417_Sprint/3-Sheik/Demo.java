public class Demo {

    public static void main(String[] args) {
        new Demo();
    }

    public Demo() {
        exeRomanticus();
        exeWorker();
    }

    public void exeRomanticus() {
        Romanticus romanticus = new Romanticus("Roman", "Male", 20);

        introduction(romanticus);
        goOnDate(romanticus);

        // goToWork(romanticus);
    }

    public void exeWorker() {
        Worker worker = new Worker("Wilma", "Female", 30);

        introduction(worker);
        goToWork(worker);

        // goOnDate(worker);
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

    public void goOnDate(Human human) {
        IsInARelationship romanticus = (IsInARelationship)human;
        romanticus.goOnDate();
    }

    public void goToWork(Human human) {
        IsAnEmployee worker = (IsAnEmployee)human;
        worker.goToWork();
    }

}