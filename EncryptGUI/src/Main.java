import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        keyInputText.setBorder(margin);

        openFileButton = new JButton("File verarbeiten");
        openFileButton.setBorder(margin);
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement file opening logic
            }
        });

        String[] algorithms = {"1:1", "Caesar", "Subst"};
        algoSelect = new JComboBox<>(algorithms);
        algoSelect.setBorder(margin);
        algoSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement algorithm selection logic
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
