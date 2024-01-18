import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class View extends JFrame implements ActionListener {
    private String TITLE = "Rock Paper Scissors";
    private String PATH = "./img/";
    private JButton rockBtn = new JButton(getImageByElement(ELEMENTS.ROCK));
    private JButton paperBtn = new JButton(getImageByElement(ELEMENTS.PAPER));
    private JButton scissorsBtn = new JButton(getImageByElement(ELEMENTS.SCISSORS));
    private JButton lizardBtn = new JButton(getImageByElement(ELEMENTS.LIZARD));
    private JButton spockBtn = new JButton(getImageByElement(ELEMENTS.SPOCK));
    private JLabel userPoints = new JLabel("0");
    private JLabel compPoints = new JLabel("0");
    private JLabel statusText = new JLabel(getTextByStatus(STATUS.NOONE_WINS));
    private JLabel userInput = new JLabel(getImageByElement(ELEMENTS.ROCK));
    private JLabel compInput = new JLabel(getImageByElement(ELEMENTS.ROCK));
    private JLabel statusImg = new JLabel(getImageByStatus(STATUS.NOONE_WINS));
    private Control ctrl;
    public View(Control ctrl) {
        this.ctrl = ctrl;
        initialize();
        setElements();
    }
    private void initialize() {
        setTitle(TITLE);
        setSize(500, 550);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setElements() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(userPoints, BorderLayout.WEST);
        panel.add(statusText, BorderLayout.CENTER);
        panel.add(compPoints, BorderLayout.EAST);
        panel.add(userInput, BorderLayout.WEST);
        panel.add(statusImg, BorderLayout.CENTER);
        panel.add(compInput, BorderLayout.EAST);
        panel.add(rockBtn, BorderLayout.WEST);
        panel.add(paperBtn, BorderLayout.CENTER);
        panel.add(scissorsBtn, BorderLayout.EAST);
        panel.add(lizardBtn, BorderLayout.WEST);
        panel.add(spockBtn, BorderLayout.EAST);
        add(panel);
        rockBtn.addActionListener(this);
        paperBtn.addActionListener(this);
        scissorsBtn.addActionListener(this);
        lizardBtn.addActionListener(this);
        spockBtn.addActionListener(this);
    }

    public void changeView(ViewChange viewChange) {
        userPoints.setText(String.valueOf(viewChange.getPointsUser()));
        compPoints.setText(String.valueOf(viewChange.getPointsComp()));
        userInput.setIcon(getImageByElement(viewChange.getUserSet()));
        compInput.setIcon(getImageByElement(viewChange.getCompSet()));
        statusImg.setIcon(getImageByStatus(viewChange.getStatusValue()));
        statusText.setText(getTextByStatus(viewChange.getStatusValue()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rockBtn) {
            ctrl.actionOccurred(new Action(ELEMENTS.ROCK));
        } else if (e.getSource() == paperBtn) {
            ctrl.actionOccurred(new Action(ELEMENTS.PAPER));
        } else if (e.getSource() == scissorsBtn) {
            ctrl.actionOccurred(new Action(ELEMENTS.SCISSORS));
        } else if (e.getSource() == lizardBtn) {
            ctrl.actionOccurred(new Action(ELEMENTS.LIZARD));
        } else if (e.getSource() == spockBtn) {
            ctrl.actionOccurred(new Action(ELEMENTS.SPOCK));
        }
    }

    private ImageIcon getImageByElement(ELEMENTS element) {
        switch(element) {
            case ROCK:
                URL rockUrl = View.class.getResource(PATH + "rock.png");
                return new ImageIcon(rockUrl);
            case PAPER:
                URL paperUrl = View.class.getResource(PATH + "paper.png");
                return new ImageIcon(paperUrl);
            case SCISSORS:
                URL scissorsUrl = View.class.getResource(PATH + "scissors.png");
                return new ImageIcon(scissorsUrl);
            case LIZARD:
                URL lizzardUrl = View.class.getResource(PATH + "lizzard.png");
                return new ImageIcon(lizzardUrl);
            case SPOCK:
                URL spockUrl = View.class.getResource(PATH + "spock.png");
                return new ImageIcon(spockUrl);
        }
        return null;
    }

    private ImageIcon getImageByStatus(STATUS status) {
        switch(status) {
            case NOONE_WINS:
                URL nooneUrl = View.class.getResource(PATH + "ind.png");
                return new ImageIcon(nooneUrl);
            case USER_WINS:
                URL userUrl = View.class.getResource(PATH + "smile.png");
                return new ImageIcon(userUrl);
            case COMP_WINS:
                URL compUrl = View.class.getResource(PATH + "sad.png");
                return new ImageIcon(compUrl);
        }
        return null;
    }

    private String getTextByStatus(STATUS status) {
        switch(status) {
            case NOONE_WINS:
                return "No one wins";
            case USER_WINS:
                return "You win";
            case COMP_WINS:
                return "Computer wins";
        }
        return null;
    }
}
