import javax.swing.*;

public class ChiffreGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Chiffre Verschlüsselung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel lblChoose = new JLabel("Wählen Sie einen Algorithmus:");
        lblChoose.setBounds(10, 20, 200, 25);
        panel.add(lblChoose);

        JComboBox<String> algoChoice = new JComboBox<>(ChiffreFactory.getChiffreList());
        algoChoice.setBounds(220, 20, 160, 25);
        panel.add(algoChoice);

        JLabel lblKey = new JLabel("Schlüssel:");
        lblKey.setBounds(10, 50, 80, 25);
        panel.add(lblKey);

        JTextField keyText = new JTextField(20);
        keyText.setBounds(100, 50, 165, 25);
        panel.add(keyText);

        JLabel lblText = new JLabel("Klartext:");
        lblText.setBounds(10, 80, 80, 25);
        panel.add(lblText);

        JTextField textToEncrypt = new JTextField(20);
        textToEncrypt.setBounds(100, 80, 165, 25);
        panel.add(textToEncrypt);

        JButton encryptButton = new JButton("Verschlüsseln");
        encryptButton.setBounds(10, 110, 150, 25);
        panel.add(encryptButton);

        JTextArea encryptedText = new JTextArea();
        encryptedText.setBounds(10, 140, 370, 110);
        panel.add(encryptedText);

        encryptButton.addActionListener(e -> {
            int chosenAlgo = algoChoice.getSelectedIndex();
            String key = keyText.getText();
            String text = textToEncrypt.getText();
            ChiffreText chiffre = ChiffreFactory.getChiffre(chosenAlgo, key);
            chiffre.setKlartext(text);
            chiffre.doEncrypt();
            encryptedText.setText(chiffre.getCrypttext());
        });
    }
