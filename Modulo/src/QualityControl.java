public class QualityControl {

    public String getCode(String date, String empl) {
        String[] parts = date.split("\\.");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        int dateCode = year * (31 * 12) + (month - 1) * 31 + (day - 1);
        int emplCode = (empl.charAt(0) - 'a') * 26 + (empl.charAt(1) - 'a');
        long totalCode = dateCode * (26 * 26) + emplCode;

        int checksum = 0;
        long tempCode = totalCode;
        while (tempCode > 0) {
            checksum += tempCode % 10;
            tempCode /= 10;
        }

        return String.valueOf(totalCode) + (checksum % 10);
    }
    public String getValues(String sCode) {
        int checkDigit = Character.getNumericValue(sCode.charAt(sCode.length() - 1));
        int code = Integer.parseInt(sCode.substring(0, sCode.length() - 1));

        int checksum = 0;
        int tempCode = code;
        while (tempCode > 0) {
            checksum += tempCode % 10;
            tempCode /= 10;
        }
        if (checksum % 10 != checkDigit) {
            return "code not valid";
        }

        int emplCode = code % (26 * 26);
        char firstChar = (char) ('a' + emplCode / 26);
        char secondChar = (char) ('a' + emplCode % 26);
        String empl = "" + firstChar + secondChar;

        code /= (26 * 26);
        int year = code / (31 * 12);
        int month = (code % (31 * 12)) / 31 + 1;
        int day = code % 31 + 1;

        return String.format("%02d.%02d.%d e:%s (code valid)", day, month, year, empl);
    }


}
