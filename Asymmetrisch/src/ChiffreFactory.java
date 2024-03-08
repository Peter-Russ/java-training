public class ChiffreFactory {
    public static final int CEASAR = 0;
    public static final int SUBST = 1;
    public static final int PLAYFAIR = 2;

    public static final int POLYBIOS = 3;
    private static String[] chiffreList = {"Ceasar", "Substitution", "Playfair", "Polybios"};

    public static String[] getChiffreList() {
        return chiffreList;
    }

    public static ChiffreText getChiffre(int chiffreTyp, String key) {
        switch(chiffreTyp) {
            case CEASAR:
                return new CaeserChiffreText(key);
            case SUBST:
                return new SubstChiffreText(key);
            case PLAYFAIR:
                return new PlayfairChiffreText(key);
            case POLYBIOS:
                return new PolybiosChiffreText(key);
            default:
                return new CaeserChiffreText(key);
        }
    }
}
