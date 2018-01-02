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
        System.out.print(Constants.INSTRUCTIONS);
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

        if (thisSide.size() == Constants.ZERO & otherSide.size() == Constants.THREE) {
            displayField(thisSide, player, river, otherSide);
            System.out.print(Constants.YOU_WIN);
            gameOver = true;
        }
        return gameOver;
    }
}