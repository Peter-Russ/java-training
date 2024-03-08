public class PolybiosChiffreText extends Q5x5_ChiffreText {
    public PolybiosChiffreText(String key) {
        super(key);
    }
    public void doEncrypt() {
        for (int i = 0; i < this.klartext.length(); i++) {
            char c = this.klartext.charAt(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {

                    if (this.quardrat5x5[j][k] == c) {
                        this.crypttext += Integer.toString(j + 1) + Integer.toString(k + 1);
                    }
                }
            }
        }
    }
    public void doDecrypt() {
        for (int i = 0; i < this.crypttext.length(); i += 2) {
            int j = Integer.parseInt(String.valueOf(this.crypttext.charAt(i))) - 1;
            int k = Integer.parseInt(String.valueOf(this.crypttext.charAt(i + 1))) - 1;
            this.klartext += this.quardrat5x5[j][k];
        }
    }
}
