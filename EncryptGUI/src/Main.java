import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main extends JFrame {
    private JRadioButton encryptRadio;
    private JRadioButton decryptRadio;
    private JTextField keyInputText;
    private JButton openFileButton;
    private JComboBox<String> algoSelect;

    public Main() {
        setTitle("Encryption Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));
        Border margin = new EmptyBorder(20, 80, 20,80);

        encryptRadio = new JRadioButton("Verschlüsseln");
        encryptRadio.setBorder(margin);
        decryptRadio = new JRadioButton("Entschlüsseln");
        decryptRadio.setBorder(margin);
        ButtonGroup group = new ButtonGroup();
        group.add(encryptRadio);
        group.add(decryptRadio);

        keyInputText = new JTextField(10);

        openFileButton = new JButton("File verarbeiten");
        openFileButton.setBorder(margin);
        openFileButton.addActionListener(new ActionListener() {
            JFileChooser fc = new JFileChooser();
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fc.showOpenDialog(null);
                File selectedFile = fc.getSelectedFile();

                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    StringBuilder strBuilder = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        strBuilder.append(line);
                    }

                    if (encryptRadio.isSelected()) {
                        String selectedAlgo = (String) algoSelect.getSelectedItem();
                        switch (selectedAlgo) {
                            case "Caesar":
                                CaeserChiffreText caesar = new CaeserChiffreText(keyInputText.getText());
                                caesar.setKlartext(strBuilder.toString());
                                caesar.doEncrypt();
                                System.out.println(caesar.getCrypttext());
                                break;
                            case "Subst":
                                SubstChiffreText subst = new SubstChiffreText(keyInputText.getText());
                                subst.setKlartext(strBuilder.toString());
                                subst.doEncrypt();
                                System.out.println(subst.getCrypttext());
                                break;
                            case "Playfair":
                                PlayfairChiffreText playfair = new PlayfairChiffreText(keyInputText.getText());
                                playfair.setKlartext(strBuilder.toString());
                                playfair.doEncrypt();
                                System.out.println(playfair.getCrypttext());
                                break;
                            case "Polybios":
                                PolybiosChiffreText polybios = new PolybiosChiffreText(keyInputText.getText());
                                polybios.setKlartext(strBuilder.toString());
                                polybios.doEncrypt();
                                System.out.println(polybios.getCrypttext());
                                break;
                            default:
                                System.out.println("No algorithm selected");
                                break;
                        }
                    } else if (decryptRadio.isSelected()) {
                        String selectedAlgo = (String) algoSelect.getSelectedItem();
                        switch (selectedAlgo) {
                            case "Caesar":
                                CaeserChiffreText caesar = new CaeserChiffreText(keyInputText.getText());
                                caesar.setCrypttext(strBuilder.toString());
                                caesar.doDecrypt();
                                System.out.println(caesar.getKlartext());
                                break;
                            case "Subst":
                                SubstChiffreText subst = new SubstChiffreText(keyInputText.getText());
                                subst.setCrypttext(strBuilder.toString());
                                subst.doDecrypt();
                                System.out.println(subst.getKlartext());
                                break;
                            case "Playfair":
                                PlayfairChiffreText playfair = new PlayfairChiffreText(keyInputText.getText());
                                playfair.setCrypttext(strBuilder.toString());
                                //playfair.doDecrypt();
                                System.out.println(playfair.getKlartext());
                                break;
                            case "Polybios":
                                PolybiosChiffreText polybios = new PolybiosChiffreText(keyInputText.getText());
                                polybios.setCrypttext(strBuilder.toString());
                                polybios.doDecrypt();
                                System.out.println(polybios.getKlartext());
                                break;
                            default:
                                System.out.println("No algorithm selected");
                                break;
                        }

                    } else {
                        System.out.println("No option selected");
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        String[] algorithms = {"Caesar", "Subst", "Playfair", "Polybios"};
        algoSelect = new JComboBox<>(algorithms);
        algoSelect.setBorder(margin);
        algoSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(encryptRadio);
        add(decryptRadio);
        add(keyInputText);
        add(openFileButton);
        add(algoSelect);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
