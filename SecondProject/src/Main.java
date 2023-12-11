import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numberArr = {1, 5, 7, 2, 9};

        Arrays.stream(numberArr).forEach((int element) -> {
            System.out.println(element);
        });

        for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }

        Person newPerson1 = new Person("max");
        newPerson1.greet();




    }
}