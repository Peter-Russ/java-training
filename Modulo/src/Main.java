
public class Main {
    public static void main(String[] args) {

        DateCode dateCode = new DateCode();
        int code = dateCode.getCodeFromDate(2023, 12, 14);
        System.out.println("Codierter Wert: " + code);
        System.out.println("Decodiertes Datum: " + dateCode.getDateFromCode(code));

        QualityControl qualityControl = new QualityControl();
        String sCode = qualityControl.getCode("21.10.2023", "ba");
        System.out.println("Codierter Wert: " + sCode);

        String sValues = qualityControl.getValues(sCode);
        System.out.println("Decodierte Werte: " + sValues);

    }
}