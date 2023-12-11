
public class Main {
    public static void main(String[] args) {

        String testWord = "wurschtsalatbeschteck";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // ihk version
        StringBuilder strBuilder = new StringBuilder(26);

        for (int i = 0; i < testWord.length(); i++) {

            if (strBuilder.length() == 0) {
                strBuilder.append(testWord.charAt(i));
            }

            for (int j = 0; j < strBuilder.length(); j++) {
                if (testWord.charAt(i) == strBuilder.charAt(j)) {
                    break;
                } else  {
                    // nur wenn kein Treffer und letzter Index von strBuilder
                    if((strBuilder.length() - 1) == j) {
                        strBuilder.append(testWord.charAt(i));
                    }
                }
            }
        }
        for (int k = 0; k < alphabet.length(); k++) {

            for (int l = 0; l < strBuilder.length(); l++) {
                if (alphabet.charAt(k) == strBuilder.charAt(l)) {
                    break;
                } else  {
                    // nur wenn kein Treffer und letzter Index von strBuilder
                    if((strBuilder.length() - 1) == l) {
                        strBuilder.append(alphabet.charAt(k));
                    }
                }
            }
        }
        System.out.println(strBuilder);


        // kurze Version
        StringBuilder strBuilder2 = new StringBuilder(26);

        for (char c: testWord.toCharArray()) {
            if (!strBuilder2.toString().contains(String.valueOf(c))) {
                strBuilder2.append(c);
            }
        }
        for (char c: alphabet.toCharArray()) {
            if(!strBuilder2.toString().contains(String.valueOf(c))) {
                strBuilder2.append(c);
            }
        }
        System.out.println(strBuilder2);
    }
}