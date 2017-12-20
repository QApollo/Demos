import java.util.List;

public abstract class Neighbour {
    boolean eatNeighbour = false;

    public boolean checkNeighbour(List<? extends Neighbour> field) {
        int index = field.indexOf(this);
        int indexPrev = index - 1;
        int indexNext = index + 1;

        if (indexPrev >= 0) {
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
