import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Bitweises ODER zum Setzen von Bits
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

        String fileName = "C:/Users/peter/Downloads/sample.bmp";
        byte[] bytes = readByteStream(fileName);
        if (bytes != null) {
            writeByteStream("C:/Users/peter/Downloads/sample2.bmp", bytes);
        } else {
            System.out.println("Fehler beim Lesen der Datei");
        }
        if (bytes != null) {
            int width = getLittleEndValue(bytes, 18, 4);
            int height = getLittleEndValue(bytes, 22, 4);
            System.out.println("Breite: " + width + " Hoehe: " + height);
        } else {
            System.out.println("Fehler beim Lesen der Bitmap-Datei.");
        }
    }


    public static int getLittleEndValue(byte[] data, int pos, int size) {
        if (pos + size > data.length) {
            return -1;
        }

        int value = 0;
        for (int i = 0; i < size; i++) {
            value |= ((data[pos + i] & 0xFF) << (i * 8));
        }
        return value;
    }

    public static String fillWithZero(String sIn, int size) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + sIn.length() < size) {
            sb.append('0');
        }
        sb.append(sIn);
        return sb.toString();
    }

    public static byte[] readByteStream(String fileName) {

        File myFile = new File(fileName);
        if (!myFile.exists()) {
            System.out.println("Datei existiert nicht: " + fileName);
            return null;
        }

        long fileSize = myFile.length();

        byte[] allBytes = new byte[(int) fileSize];
        try (FileInputStream fis = new FileInputStream(myFile)) {
            int bytesRead;
            int totalBytesRead = 0;
            byte[] buffer = new byte[1024];

            while ((bytesRead = fis.read(buffer)) != -1) {
                System.arraycopy(buffer, 0, allBytes, totalBytesRead, bytesRead);
                totalBytesRead += bytesRead;
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
            return null;
        }
        return allBytes;
    }

    public static void writeByteStream(String fileName, byte[] bytes) {

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }


}
