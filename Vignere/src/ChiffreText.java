public abstract class ChiffreText {
    protected String key;
    protected String klartext;
    protected String crypttext;

    public ChiffreText(String key) {
        this.key = key;
    }
    public void setCrypttext(String crypttext) {
        this.crypttext = crypttext;
    }
    public String getCrypttext() {
        return crypttext;
    }
    public void setKlarText(String klartext) {
        if (klartext.contains("ä")) {
            klartext = klartext.replace("ä", "ae");
        }
        if (klartext.contains("ö")) {
            klartext = klartext.replace("ö", "oe");
        }
        if (klartext.contains("ü")) {
            klartext = klartext.replace("ü", "ue");
        }
        this.klartext = klartext.toLowerCase();
    }
    public String getKlartext() {
        return klartext;
    }

    public abstract void doDecrypt();

    public abstract void doEncrypt();
}
