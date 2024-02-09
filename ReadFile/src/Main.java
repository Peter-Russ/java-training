import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        readPrintFile("C:\\Users\\peter\\Downloads\\Polymorphie.txt");
    }

    public static void readPrintFile(String fileName) {
        try (FileInputStream fileStream = new FileInputStream(fileName)) {
            int bytesRead;
            byte[] buffer = new byte[10]; // 10 Bytes wegen Aufgabenstellung

            while ((bytesRead = fileStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.printf("%02x ", buffer[i]); // printf für formatierte Ausgabe %02x = 2 Stellen hexadezimal
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}
