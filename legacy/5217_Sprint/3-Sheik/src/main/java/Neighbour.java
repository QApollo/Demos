import java.util.List;

abstract class Neighbour {
    boolean eatNeighbour = false;

    public boolean checkNeighbour(List<? extends Neighbour> field) {
        int index = field.indexOf(this);
        int indexPrev = index - Constants.ONE;
        int indexNext = index + Constants.ONE;

        if (indexPrev >= Constants.ZERO) {
            checkEatNeighbour(field.get(indexPrev));
        }

        if (indexNext < field.size()) {
            if (eatNeighbour) {
                return eatNeighbour;
            } else {
                checkEatNeighbour(field.get(indexNext));
            }
        }

        return eatNeighbour;
    }

    abstract void checkEatNeighbour(Neighbour neighbour);
}
