import java.util.Random;

public class Model {
    private int PointsUser;
    private int PointsComp;
    public ViewChange updateModel(Action action) {
        ELEMENTS userSet = action.getNewSet();
        ELEMENTS compSet = generateCompMove();

        if (userSet == compSet) {
            return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.NOONE_WINS);
        }
        switch (userSet) {
            case ROCK:
                if (compSet == ELEMENTS.SCISSORS) {
                    PointsUser++;
                    return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.USER_WINS);
                }
            case PAPER:
                if (compSet == ELEMENTS.ROCK) {
                    PointsUser++;
                    return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.USER_WINS);
                }
            case SCISSORS: // case SCISSORS
                if (compSet == ELEMENTS.PAPER) {
                    PointsUser++;
                    return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.USER_WINS);
                }
        }
        PointsComp++;
        return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.COMP_WINS);
    }
    public ELEMENTS generateCompMove() {
        Random random = new Random();
        int rand = random.nextInt(3);
        switch (rand) {
            case 0:
                return ELEMENTS.ROCK;
            case 1:
                return ELEMENTS.PAPER;
            default: // case 2
                return ELEMENTS.SCISSORS;
        }
    }

}