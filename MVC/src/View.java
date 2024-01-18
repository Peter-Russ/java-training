import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class View implements ActionListener {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final double WIDTH_RATIO = 0.6;
    private static final double HEIGHT_RATIO = 0.6;
    private static final String TITLE = "Rock Paper Scissors";
    private static final String PATH = "../.idea/img/";
    private static final String[] IMG_NAMES = {"rock.png", "paper.png", "scissors.png"};
    private static final String[] TEXTS = {"Rock", "Paper", "Scissors"};
    private static final String[] STATUS_TEXTS = {"No one wins", "You win", "Computer wins"};
    private Control ctrl;
    private ImageIcon[] images = new ImageIcon[3];
    public View(Control ctrl) {
        this.ctrl = ctrl;
        initialize();
        preloadImages();
        setElements();
    }
    private void initialize() {

    }
    private void preloadImages() {

    }
    private BufferedImage getImage(String path) {

    }
    private void setElements() {

    }
    private void getConstr(int width, int height, double widthRatio, double heightRatio) {

    }
    public void changeView(ViewChange viewChange) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private ImageIcon getImageByElement(ELEMENTS element) {

    }
    private ImageIcon getImageByStatus(STATUS status) {

    }
    private String getTextByStatus(STATUS status) {

    }
}
