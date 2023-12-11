import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++) {
            intList.add(i);
        }

        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < intList.size(); i++) {
            int randomNumber = rand.nextInt(101);
            if (randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
                intList.remove(randomNumber);
            }
        }

    }
}