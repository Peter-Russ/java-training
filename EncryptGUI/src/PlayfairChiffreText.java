public class PlayfairChiffreText extends Q5x5_ChiffreText {
    public PlayfairChiffreText(String key) {
        super(key);
    }

    public void doEncrypt() {
        StringBuilder bKlartext = new StringBuilder(this.klartext);
        if (bKlartext.length() % 2 != 0) {
            bKlartext.append('x');
        }
        for (int i = 0; i < klartext.length(); i += 2) {
            char c1 = klartext.charAt(i);
            char c2 = klartext.charAt(i + 1);
            if(c1 == c2) {
                c2 = 'x';
                bKlartext.insert(i + 1, c2);
            }
            int[] pos1;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (quardrat5x5[row][col] == c1) {
                        pos1 = new int[] { row, col };
                    }
                }
            }
            int[] pos2;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (quardrat5x5[row][col] == c2) {
                        pos2 = new int[] { row, col };
                    }
                }
            }
        }
    }
}
