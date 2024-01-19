public class VignereChiffreText extends KeyLaengeAnpassChiffreText {
    private char[][] vignereQuadrat = new char[26][26];
    public VignereChiffreText(String key) {
        super(key);
        buildVignereQuadrat();
    }
    private void buildVignereQuadrat() {
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            for (int j = 0; j < 26; j++) {
                vignereQuadrat[i][j] = (char) ('A' + (i + j) % 26);
            }
        }
    }
    @Override
    public void doEncrypt() {
        StringBuilder crypttext = new StringBuilder();
        for (int i = 0; i < klartext.length(); i++) {
            char klartextChar = klartext.charAt(i);
            char keyChar = angepassterSchluessel.charAt(i);
            int klartextCharIndex = klartextChar - 'A';
            int keyCharIndex = keyChar - 'A';
            crypttext.append(vignereQuadrat[klartextCharIndex][keyCharIndex]);
        }
        this.crypttext = crypttext.toString();
    }
    @Override
    public void doDecrypt() {
        StringBuilder klartext = new StringBuilder();
        for (int i = 0; i < crypttext.length(); i++) {
            char crypttextChar = Character.toUpperCase(crypttext.charAt(i));
            char keyChar = Character.toUpperCase(angepassterSchluessel.charAt(i));
            int keyCharIndex = keyChar - 'A';
            int crypttextCharIndex = crypttextChar - 'A';
            int decryptedCharIndex = (crypttextCharIndex - keyCharIndex + 26) % 26;
            klartext.append((char) ('A' + decryptedCharIndex));
        }
        this.klartext = klartext.toString();
    }
}
