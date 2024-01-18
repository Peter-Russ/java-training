
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Control ctrl = new Control(model);
        new View(ctrl);
    }
}