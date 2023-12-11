import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = random.nextInt(101);
        
        int[][] werte = new int[15][15];

        for (int i = 0; i < 15; i++) {
            werte[i][i] = 10001 + i;

            for (int j = 0; j < 15; j++) {
                werte[i][j] = random.nextInt(10000);
            }
        }
    }
}