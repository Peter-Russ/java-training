public class Control {
    private Model model;
    private View view;
    Control(Model model) {
        this.model = model;
    }
    public void setView(View view) {
        this.view = view;
    }
    public void actionOccurred(Action action) {
}
