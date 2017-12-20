import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        new Demo().start();
    }

    private void start() {
        List<? super Neighbour> thisSide = new ArrayList<>();
        List<? super Neighbour> otherSide = new ArrayList<>();

        thisSide.add(new Chicken());
        thisSide.add(new Corn());
        thisSide.add(new Fox());

        Player player = new Player();
        River river = new River();

        displayInstructions();
        gameLoop(thisSide, player, river, otherSide);
    }

    private void displayInstructions() {
        System.out.print("A farmer lives on a small plot of land next to a river. \n" +
                "One day, he travels across the river in a small boat and \n" +
                "purchases a fox, a chicken, and a bag of corn from a feed \n" +
                "and supply store. When the farmer returns to his boat to \n" +
                "cross the river again and go home, he realizes he has a dilemma.\n" +
                "\n" +
                "The farmer can only take one item in his small boat at a time, \n" +
                "otherwise he risks capsizing. He cannot leave the fox alone with \n" +
                "the chicken, because the fox will eat the chicken. He cannot leave \n" +
                "the chicken alone with the corn, because the chicken with eat the corn.\n" +
                "\n" +
                "How does the farmer successfully get all three items across the river?\n");
    }

    private void displayField(List thisSide, Player player, River river, List otherSide) {
        displayList(thisSide);
        if (player.getStartingSide()) {
            System.out.println(player);
            System.out.println(river);
        } else {
            System.out.println(river);
            System.out.println(player);
        }
        displayList(otherSide);
    }

    private void displayList(List list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    private void gameLoop(List thisSide, Player player, River river, List otherSide) {
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        while(!gameOver) {
            displayField(thisSide, player, river, otherSide);
            Integer input = player.checkInput(sc.next(), thisSide, otherSide);

            if (input != null){
                if (!player.getStartingSide()) {
                    crossover(input, thisSide, otherSide);
                } else {
                    crossover(input, otherSide, thisSide);
                }
                gameOver = checkGameOver(thisSide, player, river, otherSide);
            }
        }
    }

    private void crossover(int input, List thisSide, List otherSide) {
        Boat<? super Object> boat = new Boat<>();
        boat.loadBoat(thisSide.get(input));

        thisSide.remove(input);
        otherSide.add(boat.unloadBoat());
    }

    private boolean checkGameOver(List<Neighbour> thisSide, Player player, River river, List<Neighbour> otherSide) {
        boolean gameOver = false;
        if (!player.getStartingSide()) {
            for (Neighbour neighbour : thisSide) {
                if (neighbour.checkNeighbour(thisSide)) {
                    gameOver = true;
                }
            }
        } else {
            for (Neighbour neighbour : otherSide) {
                if (neighbour.checkNeighbour(otherSide)) {
                    gameOver = true;
                }
            }
        }

        if (thisSide.size() == 0 & otherSide.size() == 3) {
            displayField(thisSide, player, river, otherSide);
            System.out.print("YOU WIN");
            gameOver = true;
        }
        return gameOver;
    }
}