import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String fileName = "C:/Users/peter/Downloads/sample.bmp";
        byte[] bytes = readByteStream(fileName);
        //if (bytes != null) {
          //  writeByteStream("C:/Users/peter/Downloads/sample2.bmp", bytes);
        //}

        int width = 0;
        int height = 0;

        if (bytes != null) {
            width = getLittleEndValue(bytes, 18, 4);
            height = getLittleEndValue(bytes, 22, 4);
            System.out.println("Breite: " + width + " Hoehe: " + height);
        }

        convertToBlackWhite(bytes, width, height);

    }


    public static void convertToBlackWhite(byte[] data, int width, int height) {

        int padding = (4 - (width * 3 % 4)) % 4;
        int rowWidth = (width * 3) + padding; // Breite einer Zeile im Array inklusive Abstand

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Position des Pixels berechnen
                int pos = y * rowWidth + x * 3;

                if (y == 0) {
                    pos += 54;
                }

                int r = data[pos + 2] & 0xFF;
                int g = data[pos + 1] & 0xFF;
                int b = data[pos] & 0xFF;

                int average = (r + g + b) / 3;

                data[pos] = (byte) average;
                data[pos + 1] = (byte) average;
                data[pos + 2] = (byte) average;
            }


        }
        writeByteStream("C:/Users/peter/Downloads/sampleBlackWhite.bmp", data);
    }


    public static int getLittleEndValue(byte[] data, int pos, int size) {
        int returnValue = 0;
        if(pos + size >= data.length) {
            System.out.println("Fehler: Array-Groesse ueberschritten.");
            return -1;
        }
        int factor = 1;
        for (int i = pos; i < pos + size; i++) {
            returnValue += (data[i] & 0xFF) * factor;
            factor *= 256;
        }
        return returnValue;
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
