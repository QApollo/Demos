import java.util.List;

public class Player {
    private boolean startingSide = true;

    Integer checkInput(String input, List thisSide, List otherSide) {
        switch (input.toLowerCase()) {
            case Constants.CHICKEN_LOWERCASE:
                input = Constants.CHICKEN_UPPERCASE;
                break;
            case Constants.CORN_LOWERCASE:
                input = Constants.CORN_UPPERCASE;
                break;
            case Constants.FOX_LOWERCASE:
                input = Constants.FOX_UPPERCASE;
                break;
            case Constants.PLAYER_LOWERCASE:
                startingSide = !startingSide;
                return null;
        }
        return checkSide(input, thisSide, otherSide);
    }

    private Integer checkSide(String input, List thisSide, List otherSide) {
        if (startingSide) {
            return checkList(input, thisSide);
        } else {
            return checkList(input, otherSide);
        }
    }

    private Integer checkList(String input, List list) {
        for (Object obj : list) {
            if (input.equals(obj.toString())) {
                startingSide = !startingSide;
                return list.indexOf(obj);
            }
        }
        System.out.print(input + Constants.NOT_HERE);
        return null;
    }

    boolean getStartingSide() {
        return startingSide;
    }

    @Override
    public String toString() {
        return Constants.PLAYER_UPPERCASE;
    }
}
