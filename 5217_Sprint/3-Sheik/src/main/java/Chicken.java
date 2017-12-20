public class Chicken extends Neighbour {

    @Override
    public void checkEatNeighbour(Neighbour neighbour) {
        if (neighbour instanceof Corn) {
            System.out.println(this + Constants.EATS + neighbour);
            eatNeighbour = true;
        }
    }

    @Override
    public String toString() {
        return Constants.CHICKEN_UPPERCASE;
    }
}
