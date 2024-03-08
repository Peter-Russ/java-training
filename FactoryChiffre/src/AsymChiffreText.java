public class AsymChiffreText {
    private char[][] asymTabelle = new char[28][28];
    private String key;

    public AsymChiffreText(String key) {
        this.key = key;
        buildAsymTabelle();
    }

    private void buildAsymTabelle() {
        String tabelle = TextEinleser.textEinlesen();

        String[] zeilen = tabelle.split("\n");
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {
                asymTabelle[i][j] = zeilen[i].charAt(j);
            }
        }
    }

    public String crypt(String in) {
        StringBuilder result = new StringBuilder();
        in = in.toUpperCase();
        for (int i = 0; i < in.length(); i++) {
            char textChar = in.charAt(i);
            char keyChar = key.charAt(i % key.length());
            int row = getCharIndex(keyChar);
            int col = getCharIndex(textChar);
            if(row == -1 || col == -1) {
                result.append(textChar);
            } else {
                result.append(asymTabelle[row][col]);
            }
        }
        return result.toString();
    }


    private int getCharIndex(char c) {
        c = Character.toUpperCase(c);
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        } else if (c == '-') {
            return 26;
        } else if (c == '.') {
            return 27;
        }
        return -1;
    }



    public void doEncrypt(String input) {
        System.out.println("Verschlüsselter Text: " + crypt(input));
    }

    public void doDecrypt(String input) {
        System.out.println("Entschlüsselter Text: " + crypt(input));
    }
}

