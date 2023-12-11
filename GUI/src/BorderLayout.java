import javax.swing.*;

public class BorderLayout extends JFrame {
    public BorderLayout() {
        super("BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new java.awt.BorderLayout());
        add(new JButton("drügg mi 1"), java.awt.BorderLayout.LINE_START);
        add(new JButton("drügg mi 2"), java.awt.BorderLayout.LINE_END);
        add(new JButton("drügg mi 3"), java.awt.BorderLayout.NORTH);
        add(new JButton("drügg mi 4"), java.awt.BorderLayout.WEST);
        add(new JButton("drügg mi 5"), java.awt.BorderLayout.CENTER);
        add(new JButton("drügg mi 6"), java.awt.BorderLayout.CENTER);
        add(new JButton("drügg mi 7"), java.awt.BorderLayout.CENTER);
        add(new JButton("drügg mi 8"), java.awt.BorderLayout.CENTER);
        add(new JButton("drügg mi 9"), java.awt.BorderLayout.CENTER);

        // input
        JTextField input = new JTextField();
        add(input, java.awt.BorderLayout.SOUTH);
        JTextField input2 = new JTextField();
        add(input2, java.awt.BorderLayout.SOUTH);
    }
}
