import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[][] verbrauch = new int[6000][12];
        Random random = new Random();

        // Befüllung
        for (int i = 1001; i < verbrauch.length; i++) {
            verbrauch[i][0] = i;

            for (int j = 0; j < verbrauch[i].length; j++) {
                int randomNum = random.nextInt(1000);
                verbrauch[i][j] = randomNum;
            }
        }

        int limit = 900;
        Jahresstatistik jahresstatistik = statistik(limit, verbrauch);
    }
    public static Jahresstatistik statistik(int limit, int[][] verbrauch) {

        int totalMinValues = 0;
        int minValuesAverage = 0;
        int totalMaxValues = 0;
        int maxValuesAverage = 0;
        ArrayList<Monatsverbrauch> monatsverbrauchList = new ArrayList<Monatsverbrauch>();

        for (int i = 0; i < verbrauch.length; i++) {
            int minVerbrauch = verbrauch[i][0];
            int maxVerbrauch = verbrauch[i][0];

            for (int j = 0; j < verbrauch[i].length; j++) {
                if (minVerbrauch < verbrauch[i][j]) {
                    minVerbrauch = verbrauch[i][j];
                }
                if (maxVerbrauch > verbrauch[i][j]) {
                    maxVerbrauch = verbrauch[i][j];
                }
                if (verbrauch[i][j] > limit) {
                    int currentVerbrauch = verbrauch[i][j];
                    int verbraucherNr = i;
                    int monatsNr = j + 1;
                    Monatsverbrauch monatsverbrauch = new Monatsverbrauch(currentVerbrauch, verbraucherNr, monatsNr);
                    monatsverbrauchList.add(monatsverbrauch);
                    System.out.println("Verbraucher: " + verbraucherNr + " Monat: " + monatsNr + " Verbrauch: " + currentVerbrauch);
                }
            }
            totalMinValues += minVerbrauch;
            totalMaxValues += maxVerbrauch;
        }
        minValuesAverage = (int) totalMinValues / verbrauch.length;
        System.out.println("Durchschnittlicher minimaler Verbrauch: " + minValuesAverage);
        maxValuesAverage = (int) totalMaxValues / verbrauch.length;
        System.out.println("Durchschnittlicher maximaler Verbrauch: " + maxValuesAverage);

        Jahresstatistik jahresstatistik = new Jahresstatistik(minValuesAverage, maxValuesAverage, monatsverbrauchList);
        return jahresstatistik;
    }
}
