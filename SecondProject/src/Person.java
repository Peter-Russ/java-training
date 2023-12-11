public class Person extends Group {
    private String name;
    Person(String name) {
        super("Admin");
        this.name = name;
    }
    public void greet() {
        System.out.println("Hallo %s".formatted(name));
    }

}
