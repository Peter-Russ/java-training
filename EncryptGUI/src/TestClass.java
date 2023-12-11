import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestClass extends JFrame implements ActionListener {
    private JRadioButton decryptRadio;
    private JRadioButton encryptRadio;
    private JTextField inputText = new JTextField(20);
    private JButton openFileButton = new JButton("File verarbeiten");
    private JComboBox selectChiffre = new JComboBox();

    public TestClass() {
        setTitle("GUI für Chiffre");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        decryptRadio = new JRadioButton("Entschlüsseln");
        encryptRadio = new JRadioButton("Verschlüsseln");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(decryptRadio);
        radioGroup.add(encryptRadio);

       if (decryptRadio.isSelected()) {
           System.out.println("Entschlüsseln");
         } else if (encryptRadio.isSelected()) {
              System.out.println("Verschlüsseln");
       }

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greenButton.setBackground(Color.GREEN);
                greenButton.setForeground(Color.WHITE);
            }
        });
        add(greenButton);

        blueButton = new JButton("Blau");
        blueButton.addActionListener(new BlueButtonListener());
        add(blueButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            redButton.setBackground(Color.RED);
            redButton.setForeground(Color.WHITE);
        }
    }

    class BlueButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            blueButton.setBackground(Color.BLUE);
            blueButton.setForeground(Color.WHITE);
        }
    }


}
