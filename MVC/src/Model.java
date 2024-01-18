import java.util.Random;

public class Model {
    private int PointsUser;
    private int PointsComp;
    private int[][] rules = {
            { 0, -1,  1,  1, -1},  // ROCK
            { 1,  0, -1, -1,  1},  // PAPER
            { -1, 1,  0,  1, -1},  // SCISSORS
            { -1, 1, -1,  0,  1},  // LIZARD
            { 1, -1, 1, -1,  0}   // SPOCK
    };
    public ViewChange updateModel(Action action) {
        ELEMENTS userSet = action.getNewSet();
        ELEMENTS compSet = generateCompMove();

        int result = rules[userSet.pos][compSet.pos];

        switch (result) {
            case 1:  // Benutzer gewinnt
                PointsUser++;
                return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.USER_WINS);
            case -1: // Computer gewinnt
                PointsComp++;
                return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.COMP_WINS);
            default: // Unentschieden
                return new ViewChange(PointsUser, PointsComp, userSet, compSet, STATUS.NOONE_WINS);
        }
    }
    public ELEMENTS generateCompMove() {
        Random random = new Random();
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                return ELEMENTS.ROCK;
            case 1:
                return ELEMENTS.PAPER;
            case 2:
                return ELEMENTS.SCISSORS;
            case 3:
                return ELEMENTS.LIZARD;
            case 4:
                return ELEMENTS.SPOCK;
        }
        return null;
    }

}