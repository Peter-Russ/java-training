public class Main {

    public static void main(String[] args) {

        int b = 0b10010110010110011000110010110001;
        int m = 0b00000000111111110000000000000000;
        int e = b & m;
        System.out.println(fillWithZero(Integer.toBinaryString(e), 32));
        System.out.println(fillWithZero(Integer.toBinaryString(e >> 16), 32));

        shift1();
        shift2();
        shift3();
        print4(255);
        divideBy2(50, 3);
        shiftRightBy1(50, 3);
        multBy2(3, 4);
        shiftLeftBy1(3, 4);

        int n = 0;
        n |= 0b100;
        n |= 0b10001;
        System.out.println(fillWithZero(Integer.toBinaryString(n), 8));

        // Verwendung des UND-Operators zum Prüfen, ob ein Bit gesetzt ist
        if ((n & 0b100) != 0) {
            System.out.println("Das Bit wurde gesetzt");
        } else {
            System.out.println("Das Bit wurde nicht gesetzt");
        }

        // Negation
        n = ~0b10001;
        System.out.println(n);
        System.out.println(fillWithZero(Integer.toBinaryString(n), 8));
    }

    public static String fillWithZero(String sIn, int size) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + sIn.length() < size) {
            sb.append('0');
        }
        sb.append(sIn);
        return sb.toString();
    }


    public static void shift1() {
        int value = 1;
        for (int i = 0; i < 32; i++) {
            System.out.println(fillWithZero(Integer.toBinaryString(value << i), 32));
        }
    }

    public static void shift2() {
        int value = 2147483647;
        for (int i = 0; i < 32; i++) {
            System.out.println(fillWithZero(Integer.toBinaryString(value << i), 32));
        }
    }

    public static void shift3() {
        int value = -2147483648;
        for (int i = 0; i < 32; i++) {
            System.out.println(fillWithZero(Integer.toBinaryString(value << i), 32));
        }
    }

    public static void print4(int n) {
        String binaryString = fillWithZero(Integer.toBinaryString(n), 32);
        for (int i = 0; i < binaryString.length(); i += 4) {
            System.out.println(binaryString.substring(i, i + 4));
        }
    }

    public static void divideBy2(int n, int count) {
        for (int i = 0; i < count; i++) {
            n /= 2;
            System.out.println(n);
        }
    }

    public static void shiftRightBy1(int n, int count) {
        for (int i = 0; i < count; i++) {
            n >>= 1;
            System.out.println(n);
        }
    }

    public static void multBy2(int n, int count) {
        for (int i = 0; i < count; i++) {
            n *= 2;
            System.out.println(n);
        }
    }
    public static void shiftLeftBy1(int n, int count) {
        for (int i = 0; i < count; i++) {
            n <<= 1;
            System.out.println(n);
        }
    }

}
   
