import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World");
        byte byteVar = 127;
        short shortVar = Short.MAX_VALUE;
        int intVar = Integer.MAX_VALUE;
        long longVar = Long.MAX_VALUE;
        byteVar++;
        shortVar++;
        intVar++;
        longVar++;
        System.out.println(byteVar);
        System.out.println(shortVar);
        System.out.println(intVar);
        System.out.println(longVar);

        double d1 = 1;
        System.out.println(d1/0);
        double d2 = 0;
        System.out.println(-1 * d2);
        int i1 = 1;
        System.out.println(i1/2);
        int i2 = 1;
        // System.out.println(i2/0);

        String s1 = "hallo";
        String s2 = JOptionPane.showInputDialog("Eingabe");
        if (s1 == s2) {
            System.out.println("gleich");
        } else {
            System.out.println("ungleich");
        }

        int testVal = 1;
        int[] testArr = {6, 3, 5};
        TestMethod(testVal, testArr);
        System.out.println(testVal);
        System.out.println(testArr.toString());
    }

    public static void TestMethod(int testVal, int[] testArr) {
        System.out.println(testVal);
    }

}