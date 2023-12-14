public class SubstChiffreText extends ChiffreText {
    private char[] replacement = new char[26];
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public SubstChiffreText(String key) {
        this.key = key;
        build_replacement();
    }
    public void doDecrypt() {
        String replacementStr = new String(replacement);

        for(int i = 0; i < this.crypttext.length(); i++) {
            int index = replacementStr.indexOf(this.crypttext.charAt(i));
            this.klartext += alphabet.charAt(index);
        }
    }
    public void doEncrypt() {
        String replacementStr = new String(replacement);

        for(int i = 0; i < this.klartext.length(); i++) {
            int index = alphabet.indexOf(this.klartext.charAt(i));
            this.crypttext += replacementStr.charAt(index);
        }
    }

    private void build_replacement() {
        StringBuilder strBuilder = new StringBuilder(26);

        for (char c: this.key.toCharArray()) {
            if (!strBuilder.toString().contains(String.valueOf(c))) {
                strBuilder.append(c);
            }
        }
        for (char c: alphabet.toCharArray()) {
            if(!strBuilder.toString().contains(String.valueOf(c))) {
                strBuilder.append(c);
            }
        }
        for (int i = 0; i < strBuilder.length(); i++) {
            replacement[i] = strBuilder.charAt(i);
        }
    }
}
