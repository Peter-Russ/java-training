public class ChiffreText {
    protected String key;
    protected String klartext;
    protected String crypttext = "";

    public void setKlartext(String klartext) {
        this.klartext = klartext.toLowerCase();
    }
    public String getKlartext() {
        return klartext;
    }
    public void setCrypttext(String crypttext) {
        this.crypttext = crypttext;
    }
    public String getCrypttext() {
        return crypttext;
    }
}
