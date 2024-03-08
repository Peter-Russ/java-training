public class Q5x5_ChiffreText extends ChiffreText {
    protected char[][] quardrat5x5 = new char[5][5];
    private String inhaltQuadrat;

    public Q5x5_ChiffreText(String key) {
        this.key = key.toLowerCase().replace('j', 'i');
        buildQuadrat();
        buildInhaltQuadrat();
    }

    @Override
    public void setKlartext(String klartext) {
        this.klartext = klartext.toLowerCase().replace('j', 'i');
        super.setKlartext(klartext);
    }

    private void buildQuadrat() {
        String alphabetWithoutJ = "extrawurstbcdfghklmnopqstuvwxyz";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                quardrat5x5[i][j] = alphabetWithoutJ.charAt(i * 5 + j);
            }
        }
    }

    private void buildInhaltQuadrat() {
        inhaltQuadrat = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                inhaltQuadrat += quardrat5x5[i][j];
            }
        }
    }

    public void doEncrypt() {
        for (int i = 0; i < this.klartext.length(); i++) {
            char c = this.klartext.charAt(i);
            int index = inhaltQuadrat.indexOf(c);
            int row = index / 5;
            int col = index % 5;
            this.crypttext += Integer.toString(row + 1) + Integer.toString(col + 1);
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
