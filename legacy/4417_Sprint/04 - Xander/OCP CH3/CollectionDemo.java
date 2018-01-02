import java.util.*;

public class CollectionDemo {
    List<People> peopleArrayListExample = new ArrayList<>();
    Set<Integer> setExample = new HashSet<>();
    Queue<Integer> queueExample = new ArrayDeque<>();

    public static void main(String[] args) {
        CollectionDemo demo = new CollectionDemo();
        demo.setExamples();
        demo.queueExample();
        demo.comparableExample();
        demo.comparatorExample();
    }

    public CollectionDemo() {
        populateArrayList();
        populateSet();
        populateQueue();
    }

    private void comparableExample() {
        System.out.println("\n" + "Unsorted list");
        System.out.println(peopleArrayListExample);

        Collections.sort(peopleArrayListExample);

        System.out.println("\n" + "List sorted by natural order of name");
        System.out.println(peopleArrayListExample);
    }

    private void comparatorExample() {
        Comparator<People> byAgeAscending = (p1, p2) -> p1.getAge()-p2.getAge();
        Comparator<People> byAgeDescending = (p1, p2) -> p2.getAge()-p1.getAge();

        Collections.sort(peopleArrayListExample, byAgeAscending);

        System.out.println("\n" + "People list sorted by age ascending");
        System.out.println(peopleArrayListExample);

        Collections.sort(peopleArrayListExample, byAgeDescending);

        System.out.println("\n" + "People list sorted by age Descending");
        System.out.println(peopleArrayListExample);
    }

    private void setExamples() {

        System.out.println("Initial set values");
        for(Integer value : setExample) {
            System.out.print(value + " ");
        }

        System.out.println("\n" + "Result of attempting to add a duplicate value to the set: " + setExample.add(5));
        System.out.println("Values after add");
        for(Integer value : setExample) {
            System.out.print(value + " ");
        }
    }

    private void queueExample() {
        Iterator itr = queueExample.iterator();

        System.out.println("\n" + "Initial queue values" + "\n");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        queueExample.add(11);
        queueExample.offer(12);


        System.out.println("\n" + "Values after add/offer");
        itr = queueExample.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println("\n" + "Result of poll: " + queueExample.poll());
        System.out.println("\n" + "Next value in queue using peek" + queueExample.peek());

        queueExample.clear();        
        System.out.println("result of poll when no more values in the queue are left: " + queueExample.poll());
    }

    private void populateArrayList() {
        peopleArrayListExample.add(new People("Sheik", 28));
        peopleArrayListExample.add(new People("Haoran", 23));
        peopleArrayListExample.add(new People("Xander", 19));
        peopleArrayListExample.add(new People("Alfonso", 40));
        peopleArrayListExample.add(new People("Aeron", 25));
        peopleArrayListExample.add(new People("Elena", 24));
    }

    private void populateSet() {
        for(int i = 10; i >= 1; i-- ) {
            setExample.add(i);
        }
    }

    private void populateQueue() {
        for(int i = 1; i <= 10; i++) {
            queueExample.add(i);
        }
    }

}

class People implements Comparable<People> {
    String name;
    int age;


     People(String name, int age) {
        this.age = age;
        this.name = name;
     }

    public String toString() {
        return name;
    }

     public int compareTo(People p) {
        return name.compareTo(p.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
