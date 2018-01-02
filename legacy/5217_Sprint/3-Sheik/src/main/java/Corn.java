public class Corn extends Neighbour {

    @Override
    void checkEatNeighbour(Neighbour neighbour) {}

    @Override
    public String toString() {
        return Constants.CORN_UPPERCASE;
    }
}
