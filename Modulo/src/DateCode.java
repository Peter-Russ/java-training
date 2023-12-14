public class DateCode {
    public int getCodeFromDate(int y, int m, int d) {
        int code = y;
        code *= 12;
        code += m - 1;
        code *= 31;
        code += d - 1;
        return code;
    }

    public String getDateFromCode(int code) {
        int d = code % 31 + 1;
        code /= 31;
        int m = code % 12 + 1;
        code /= 12;
        int y = code;

        return y + "-" + m + "-" + d;
    }

}
