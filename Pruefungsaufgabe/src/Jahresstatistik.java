import java.util.ArrayList;

public class Jahresstatistik {

    int minVerbrauchAvg = 0;
    int maxVerbrauchAvg = 0;
    ArrayList<Monatsverbrauch> monatsverbrauchList = new ArrayList<Monatsverbrauch>();

    Jahresstatistik(int minVerbrauchAvg,int maxVerbrauchAvg,ArrayList<Monatsverbrauch> monatsverbrauchList) {
        this.minVerbrauchAvg = minVerbrauchAvg;
        this.maxVerbrauchAvg = maxVerbrauchAvg;
        this.monatsverbrauchList = monatsverbrauchList;
    }
}
