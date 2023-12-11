import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int noOfElements = 100000;
        int valueRange = 1000000;

        int[] array = new int[valueRange];
        ArrayList<Integer> arrayList = new ArrayList<>(valueRange);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>(valueRange);

        // Range für Suche befüllen...
        for (int i = 0; i < valueRange; i++) {
            array[i] = i;
            arrayList.add(i);
            hashtable.put(i, i);
        }

        int[] randomNumbers = getRandomNumbers(noOfElements, valueRange);

        long totalArrayTime = 0;
        long totalArrayListTime = 0;
        long totalHashtableTime = 0;

        for (int num : randomNumbers) {
            // Array
            long startTimeArray = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == num) {
                    break;
                }
            }
            long stopTimeArray = System.currentTimeMillis();
            totalArrayTime += (stopTimeArray - startTimeArray);

            // ArrayList
            long startTimeArrayList = System.currentTimeMillis();
            arrayList.contains(num);
            long stopTimeArrayList = System.currentTimeMillis();
            totalArrayListTime += (stopTimeArrayList - startTimeArrayList);

            // Hashtable
            long startTimeHashtable = System.currentTimeMillis();
            hashtable.containsKey(num);
            long stopTimeHashtable = System.currentTimeMillis();
            totalHashtableTime += (stopTimeHashtable - startTimeHashtable);
        }

        System.out.println("Gesamte Array Suchzeit [s]: " + (double) totalArrayTime / 1000);
        System.out.println("Gesamte ArrayList Suchzeit [s]: " + (double) totalArrayListTime / 1000);
        System.out.println("Gesamte Hashtable Suchzeit [s]: " + (double) totalHashtableTime / 1000);
    }

    public static int[] getRandomNumbers(int noOfElements, int valueRange) {

        Random myRnd = new Random();
        ArrayList<Integer> allNumbers = new ArrayList<>(valueRange);
        int[] randomNumbers = new int[noOfElements];

        for (int i = 0; i < valueRange; i++) {
            allNumbers.add(i);
        }

        for (int i = 0; i < randomNumbers.length; i++) {

            int pos = myRnd.nextInt(allNumbers.size());
            randomNumbers[i] = allNumbers.get(pos);
            allNumbers.remove(pos);
        }
        return randomNumbers;
    }
}

//Gesamte Array Suchzeit [s]: 26.011
//Gesamte ArrayList Suchzeit [s]: 81.896
//Gesamte Hashtable Suchzeit [s]: 0.072