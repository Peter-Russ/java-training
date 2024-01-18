import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class View extends JFrame implements ActionListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final double WIDTH_RATIO = 0.6;
    private static final double HEIGHT_RATIO = 0.6;
    private static final String TITLE = "Rock Paper Scissors";
    private static final String PATH = "../.idea/img/";
    private static final String[] IMG_NAMES = {"rock.png", "paper.png", "scissors.png", "ind.png", "smile.png", "sad.png"};
    private static final String[] STATUS_TEXTS = {"No one wins", "You win", "Computer wins"};
    private JButton[] buttons = new JButton[3];
    private Control ctrl;
    private ImageIcon[] images = new ImageIcon[6];
    public View(Control ctrl) {
        this.ctrl = ctrl;
        initialize();
        preloadImages();
        setElements();
    }
    private void initialize() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void preloadImages() {
        for (int i = 0; i < IMG_NAMES.length; i++) {
            images[i] = new ImageIcon(getImage(PATH + IMG_NAMES[i]));
        }
    }
    private BufferedImage getImage(String path) {
        
    }
    private void setElements() {
        getConstr(WIDTH, HEIGHT, WIDTH_RATIO, HEIGHT_RATIO);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(getImageByElement(ELEMENTS.values()[i]));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
    }
    private void getConstr(int width, int height, double widthRatio, double heightRatio) {
        int x = (int) (width * (1 - widthRatio) / 2);
        int y = (int) (height * (1 - heightRatio) / 2);
        int w = (int) (width * widthRatio);
        int h = (int) (height * heightRatio);
        setBounds(x, y, w, h);
    }
    public void changeView(ViewChange viewChange) {
        buttons[viewChange.getUserSet().ordinal()].setIcon(getImageByStatus(viewChange.getStatusValue()));
        buttons[viewChange.getCompSet().ordinal()].setIcon(getImageByStatus(viewChange.getStatusValue()));
        JOptionPane.showMessageDialog(this, getTextByStatus(viewChange.getStatusValue()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == buttons[0]) {
            ctrl.actionOccurred(new Action(ELEMENTS.ROCK));
        } else if (button == buttons[1]) {
            ctrl.actionOccurred(new Action(ELEMENTS.PAPER));
        } else { // button == buttons[2]
            ctrl.actionOccurred(new Action(ELEMENTS.SCISSORS));
        }
    }
    private ImageIcon getImageByElement(ELEMENTS element) {
        switch(element) {
            case ROCK:
                return images[0];
            case PAPER:
                return images[1];
            default: // case SCISSORS
                return images[2];
        }
    }
    private ImageIcon getImageByStatus(STATUS status) {
        switch(status) {
            case NOONE_WINS:
                return images[3];
            case USER_WINS:
                return images[4];
            default: // case COMP_WINS
                return images[5];
        }
    }
    private String getTextByStatus(STATUS status) {
        switch(status) {
            case NOONE_WINS:
                return STATUS_TEXTS[0];
            case USER_WINS:
                return STATUS_TEXTS[1];
            default: // case COMP_WINS
                return STATUS_TEXTS[2];
        }
    }
}
