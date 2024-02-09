public class ChiffreFactory extends ChiffreText {
    public static final int CEASAR = 0;
    public static final int SUBST = 1;
    public static final int PLAYFAIR = 2;
    public static final int POLYBIOS = 3;
    public static final int VIGNERE = 4;
    private static String[] chiffreList = {"Ceasar", "Substitution", "Playfair"};

    public static String[] getChiffreList() {

    }

    public static ChiffreText getChiffre(int chiffreTyp, String key) {

    }

}
