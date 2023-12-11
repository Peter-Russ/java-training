public class CaeserChiffreText extends ChiffreText {
    private String key;
    private int offset;
    public CaeserChiffreText(String key) {
        this.key = key;
        calcOffset();
    }
    private void calcOffset() {
        char firstChar = key.charAt(0);
        if (Character.isUpperCase(firstChar)) {
            this.offset = firstChar - 'A';
        } else if (Character.isLowerCase(firstChar)) {
            this.offset = firstChar - 'a';
        }
    }
    private String schieben(String text, int offset) {

        StringBuilder offsetText = new StringBuilder(text);

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int c = ch - 'A';
                c = (c + offset + 26) % 26;
                offsetText.setCharAt(i, (char) (c + 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                int c = ch - 'a';
                c = (c + offset + 26) % 26;
                offsetText.setCharAt(i, (char) (c + 'a'));
            } else {
                offsetText.setCharAt(i, ch);
            }
        }
        return offsetText.toString();
    }
    public void doDecrypt() {
        this.crypttext = this.schieben(this.klartext, -this.offset);
    }
    public void doEncrypt() {
        this.crypttext = this.schieben(this.klartext, this.offset);
    }

}
