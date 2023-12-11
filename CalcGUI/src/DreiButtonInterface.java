import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DreiButtonInterface extends JFrame implements ActionListener {
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;

    public DreiButtonInterface() {
        setTitle("Drei Buttons GUI");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        redButton = new JButton("Rot");
        redButton.addActionListener(this);
        add(redButton);

        greenButton = new JButton("Grün");
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
