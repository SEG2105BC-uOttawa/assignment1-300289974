import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class arrayTest {
    public static void main(String[] args) {
        long start, end;
        int length = 1000;
        intGenerator generator = new intGenerator(length*3, 0, 10);
        ArrayList<Integer> testArrayList = new ArrayList<Integer>(length);
        Vector<Integer> testVector = new Vector<Integer>(length);
        int[] testArray = new int[length];

        start = System.nanoTime();
        for (int i=0; i < length; i++) {
            testArrayList.add(generator.getNext());
        }
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add integers to all arrays"); 

        start = System.nanoTime();
        for (int i=0; i < length; i++) {
            testVector.add(generator.getNext());
        }
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add integers to all arrays");

        start = System.nanoTime();
        for (int i=0; i < length; i++) {
            testArray[i] = generator.getNext();
        }
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add integers to all arrays");

        int elementSum;

        start = System.nanoTime();
        elementSum = sum(testArrayList.iterator());
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add all elements in an array list");

        start = System.nanoTime();
        elementSum = sum(testVector.iterator());
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add all elements in a vector");

        start = System.nanoTime();
        elementSum = sum(testArray);
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add all elements in an array");

        System.out.println("Sum of all elements: " + elementSum);
    
    }

    public static void printRuntimeSeconds(long start, long end, String task) {
        double runtimeSeconds = (end - start) / Math.pow(10, 9);
        System.out.println("Time taken to " + task + ": " + runtimeSeconds);
    }

    public static int sum(Iterator<Integer> iterator) {
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i=0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

}
