public class Fox extends Neighbour {
    @Override
    void checkEatNeighbour(Neighbour neighbour) {
        if (neighbour instanceof Chicken) {
            System.out.println(this + Constants.EATS + neighbour);
            eatNeighbour = true;
        }
    }

    @Override
    public String toString() {
        return Constants.FOX_UPPERCASE;
    }

}
