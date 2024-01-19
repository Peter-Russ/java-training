public abstract class KeyLaengeAnpassChiffreText extends ChiffreText {
    protected String angepassterSchluessel;
    public KeyLaengeAnpassChiffreText(String key) {
        super(key);
        buildAngepassterSchluessel();
    }

    @Override
    public void setKlarText(String klartext) {
        super.setKlarText(klartext);
        buildAngepassterSchluessel();
    }

    protected void buildAngepassterSchluessel() {
        StringBuilder angepassterSchluessel = new StringBuilder();
        int keyLaenge = key.length();
        int klartextLaenge = klartext.length();
        int i = 0;
        while (i < klartextLaenge) {
            angepassterSchluessel.append(key.charAt(i % keyLaenge));
            i++;
        }
        this.angepassterSchluessel = angepassterSchluessel.toString();
    }
}
