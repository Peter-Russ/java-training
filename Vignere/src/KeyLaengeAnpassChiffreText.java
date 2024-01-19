public abstract class KeyLaengeAnpassChiffreText extends ChiffreText {
    protected String angepassterSchluessel;
    public KeyLaengeAnpassChiffreText(String key) {
        super(key);
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
        if (keyLaenge == klartextLaenge) {
            this.angepassterSchluessel = key;
            return;
        }
        if (keyLaenge > klartextLaenge) {
            for (int i = 0; i < klartextLaenge; i++) {
                angepassterSchluessel.append(key.charAt(i));
            }
        }
        for (int i = 0; i < klartextLaenge; i++) {
            angepassterSchluessel.append(key.charAt(i % keyLaenge));
        }
        this.angepassterSchluessel = angepassterSchluessel.toString();
        System.out.println("angepassterSchluessel: " + angepassterSchluessel);
    }
}
