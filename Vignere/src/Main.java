public class Main {
    public static void main(String[] args) {

        VignereChiffreText vignereCipher = new VignereChiffreText("akey");

        vignereCipher.setKlarText("geheimnis");

        vignereCipher.doEncrypt();
        String encryptedText = vignereCipher.getCrypttext();
        System.out.println("Encrypted Text: " + encryptedText);

        vignereCipher.setCrypttext(encryptedText);
        vignereCipher.doDecrypt();
        String decryptedText = vignereCipher.getKlartext();
        System.out.println("Decrypted Text: " + decryptedText);
}
}