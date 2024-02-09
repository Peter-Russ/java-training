import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String sDisplay = "";
        for (int i = 0; i < ChiffreFactory.getChiffreList().length; i++) {
            sDisplay += ChiffreFactory.getChiffreList()[i] + "(" + i + ")\n";
        }

        int iSelectedAlgo = Integer.parseInt(JOptionPane.showInputDialog(sDisplay + "Wählen Sie einen Algorithmus:"));
        String myKey = JOptionPane.showInputDialog("Key:");
        String klartext = JOptionPane.showInputDialog("Klartext:");

        ChiffreText myChiffre = ChiffreFactory.getChiffre(iSelectedAlgo, myKey);
        myChiffre.setKlartext(klartext);

        // Hier würde normalerweise die Verschlüsselung durchgeführt und das Ergebnis ausgegeben
    }
}
