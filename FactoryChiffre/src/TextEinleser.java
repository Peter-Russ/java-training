import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextEinleser {

    public static String textEinlesen() {
        try {
            return new String(Files.readAllBytes(Paths.get("C:/Users/peter/Downloads/ASYM_Kodierer.txt")));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
