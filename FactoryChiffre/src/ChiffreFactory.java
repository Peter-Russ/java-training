public class ChiffreFactory {
    public static final int CEASAR = 0;
    public static final int SUBST = 1;
    public static final int PLAYFAIR = 2;
    private static String[] chiffreList = {"Ceasar", "Substitution", "Playfair"};

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
            default:
                return new CaeserChiffreText(key);
        }
    }
}
