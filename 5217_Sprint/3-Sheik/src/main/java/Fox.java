public class Fox extends Neighbour {
    @Override
    void checkEatNeighbour(Neighbour neighbour) {
        if (neighbour instanceof Chicken) {
            System.out.println(this + " eats " + neighbour);
            eatNeighbour = true;
        }
    }

    @Override
    public String toString() {
        return "Fox";
    }

}
