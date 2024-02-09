abstract class ChiffreText {
    protected String klartext;
    protected String crypttext;
    protected String key;
    public abstract void doEncrypt();
    public abstract void doDecrypt();
    public void setKlartext(String klartext) {
        this.klartext = klartext;
    }
    public String getCrypttext() {
        return crypttext;
    }
    public void setCrypttext(String crypttext) {
        this.crypttext = crypttext;
    }
    public String getKlartext() {
        return klartext;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

}
