import java.util.*;

public class Demo {
    private Player PLAYER = new Player();
    private Map<String, Object> map = new LinkedHashMap<>();
    private List<? super Object> list;
    private boolean gameOver = false;
    private boolean firstSort = true;


    public static void main(String[] args) {
        new Demo().startGame();
    }

    private void startGame() {
        display(instructions());
        create();
        display(field());
        playerInput();
    }

    private void display(Object result) {
        System.out.print("\n\n" + result);
    }

    private String instructions() {
        return "A farmer lives on a small plot of land next to a river. One day, he travels across " +
               "the river in a small boat and purchases a fox, a chicken, and a bag of corn from a feed and " +
               "supply store. When the farmer returns to his boat to cross the river again and go home, he " +
               "realizes he has a dilemma.\n" +
               "\n" +
               "The farmer can only take one item in his small boat at a time, otherwise he risks capsizing. " +
               "He cannot leave the fox alone with the chicken, because the fox will eat the chicken. He " +
               "cannot leave the chicken alone with the corn, because the chicken with eat the corn.\n" +
               "\n" +
               "How does the farmer successfully get all three items across the river?";
    }

    private void create() {
        Chicken chicken = new Chicken();
        map.put("chicken", chicken);

        Corn corn = new Corn();
        map.put("corn", corn);

        Fox fox = new Fox();
        map.put("fox", fox);

        River river = new River();
        map.put("river", river);
    }

    private String field() {
        String result = "";
        list = new ArrayList<>(map.values());
        sort(list);
        for (Object element : list) {
            result += element + "\n";
        }
        return result;
    }

    private void sort(List list) {
        if (firstSort) {
            Collections.sort(list, Comparator.comparing(Object::toString));
            firstSort = false;
        }
    }

    private void playerInput() {
        Scanner sc = new Scanner(System.in);

        while(!gameOver) {
            String input = PLAYER.input();
//            String input = sc.next();
            crossover(input);
        }
    }

    private void crossover(String input) {
        Boat<? super Object> boat = new Boat<>();
        boat.loadBoat(map.get(input));

            map.remove(input);
            map.put(input, boat.unloadBoat());

        display(field());
        checkGameOver();
    }

    private void checkGameOver() {
        for (Object obj : list) {
            if(!(obj instanceof River)) {
                Neighbour neighbour = (Neighbour) obj;
                if((obj instanceof Chicken && neighbour.checkNeighbour(list) instanceof Corn) ||
                    (obj instanceof Fox && neighbour.checkNeighbour(list) instanceof Chicken) ) {
                    gameOver = true;
                }
            }
        }
    }
}