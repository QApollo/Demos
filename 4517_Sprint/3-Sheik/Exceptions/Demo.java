import java.util.ArrayList;
import java.util.List;

public class Demo {
    
    public static void main(String[] args) {
        new Demo();
    }

    public Demo() {
        List<Human> humanList = createHumanList();

        for (Human human : humanList) {
            introduction(human);
            goOnDate(human);
            goToWork(human);
        }
    }

    public List<Human> createHumanList() {
        List<Human> humanList = new ArrayList<>();

        humanList.add(new Romanticus("Roman", "Male", 20));
        humanList.add(new Worker("Wilma", "Female", 30));

        return humanList;
    }

    public void introduction(Human human) {
        System.out.println();
        System.out.println( "Hi, I am a "
                            + human.getGender() +
                            " named "
                            + human.getName() +
                            " and I'm "
                            + human.getAge() +
                            " years old." );
    }

    public void goOnDate(Human human) {
        try {
            ((HasARelationship)human).goOnDate();
        } 
        catch(ClassCastException e) {
            System.out.println(human.getName() + " does not have a relationship.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void goToWork(Human human) {
        try {
            ((HasAJob)human).goToWork();
        } 
        catch(ClassCastException e) {
            System.out.println(human.getName() + " does not have a job.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}