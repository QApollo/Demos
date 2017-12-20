public class Chicken extends Neighbour {

    @Override
    public void checkEatNeighbour(Neighbour neighbour) {
        if (neighbour instanceof Corn) {
            System.out.println(this + " eats " + neighbour);
            eatNeighbour = true;
        }
    }

    @Override
    public String toString() {
        return "Chicken";
    }
}
