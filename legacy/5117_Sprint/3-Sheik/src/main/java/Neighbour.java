import java.util.List;

public interface Neighbour {
    default Object checkNeighbour(List<? super Object> list) {
        Object returnObject = null;
            int index = list.indexOf(this);
            int indexPrev = index - 1;
            int indexNext = index + 1;

            if (indexNext < list.size()) {
                Object tempHolder = list.get(indexNext);
                if(!tempHolder.toString().equals("~")) {
                    returnObject = tempHolder;
                }
            }

            if (indexPrev >= 0) {
                returnObject = list.get(indexPrev);
            }

        return returnObject;
    }
}
