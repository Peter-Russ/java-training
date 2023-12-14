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
            for (int j = 0; j < 5 ; j++) {
                inhaltQuadrat += quardrat5x5[i][j];
            }
        }
    }
}
