public class Model {

    public enum ELEMENT {
        ROCK,
        PAPER,
        SCISSORS
    }

    public enum RESULT {
        WIN,
        LOSE,
        DRAW
    }

    public static RESULT compare(ELEMENT player, ELEMENT computer) {
        if (player == computer) {
            return RESULT.DRAW;
        }

        switch (player) {
            case ROCK:
                return computer == ELEMENT.SCISSORS ? RESULT.WIN : RESULT.LOSE;
            case PAPER:
                return computer == ELEMENT.ROCK ? RESULT.WIN : RESULT.LOSE;
            case SCISSORS:
                return computer == ELEMENT.PAPER ? RESULT.WIN : RESULT.LOSE;
        }

        return RESULT.DRAW;
    }

    public static ELEMENT randomElement() {
        int random = (int) (Math.random() * 3);

        switch (random) {
            case 0:
                return ELEMENT.ROCK;
            case 1:
                return ELEMENT.PAPER;
            case 2:
                return ELEMENT.SCISSORS;
        }

        return ELEMENT.ROCK;
    }

    public static String elementToString(ELEMENT element) {
        switch (element) {
            case ROCK:
                return "Rock";
            case PAPER:
                return "Paper";
            case SCISSORS:
                return "Scissors";
        }

        return "Rock";
    }

    public static String resultToString(RESULT result) {
        switch (result) {
            case WIN:
                return "Win";
            case LOSE:
                return "Lose";
            case DRAW:
                return "Draw";
        }

        return "Draw";
    }
}
