import java.util.Scanner;

public class Demo {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        new Demo().playerInput();
    }

    private void playerInput() {
        System.out.println("Please choose what encounter you want to create: 1 WereRat, 2 WereWolf, 3 WereBear");
        createEncounter(SCANNER.next());
    }

    private void createEncounter(String input) {
        LycanthropeFactory factory = null;

        switch (input) {
            case "1":
                factory = WereRatFactory.getInstance();
                break;
            case "2":
                factory = WereWolfFactory.getInstance();
                break;
            case "3":
                factory = WereBearFactory.getInstance();
                break;
        }

        factory.createFollower().getStatistics();
        factory.createLeader().getStatistics();
        factory.createLeader().abilities();
    }
}