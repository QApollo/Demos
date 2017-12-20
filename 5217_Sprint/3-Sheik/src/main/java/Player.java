import java.util.List;

public class Player {
    private boolean startingSide = true;

    Integer checkInput(String input, List thisSide, List otherSide) {
        switch (input.toLowerCase()) {
            case "chicken":
                input = "Chicken";
                break;
            case "corn":
                input = "Corn";
                break;
            case "fox":
                input = "Fox";
                break;
            case "player":
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
        System.out.print(input + " not here.\n\n");
        return null;
    }

    boolean getStartingSide() {
        return startingSide;
    }

    @Override
    public String toString() {
        return "Player";
    }
}
