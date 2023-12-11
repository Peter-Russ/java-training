public class Main {
    public static void main(String[] args) {

        PlayfairChiffreText playfairChiffreText = new PlayfairChiffreText("extrawurst");
        playfairChiffreText.setKlartext("ichkommeammittwoch");
        playfairChiffreText.doEncrypt();
        System.out.println("Crypttext: " + playfairChiffreText.getCrypttext());
        // playfairChiffreText.doDecrypt();





        //String key = "wurstsalatbesteck";
        //SubstChiffreText caeserText = new SubstChiffreText(key);
        //caeserText.setKlartext("diesistmeinklartext");
        //caeserText.doEncrypt();
        //caeserText.doDecrypt();
        //System.out.println("Crypttext: " + caeserText.getCrypttext());

        //caeserText.setKlartext("magnet");
        //caeserText.doEncrypt();
        //System.out.println("Crypttext: " + caeserText.getCrypttext());
    }
}