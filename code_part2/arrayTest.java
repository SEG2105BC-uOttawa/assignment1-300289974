import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/*
 * Note, due to the high number of elements
 * required to reach a ~10 second runtime for
 * ArrayList, this java program requires at
 * least 12gb of memory. Please run the class
 * file with -Xmx12g to allocate this memory.
 * 
 * > java -Xmx12g arrayTest
 */
public class arrayTest {
    public static void main(String[] args) {
        long start, end;
        intGenerator generator;
        int length = 800000000;
        ArrayList<Integer> testArrayList = new ArrayList<Integer>(length);
        Vector<Integer> testVector = new Vector<Integer>(length);
        int[] testArray = new int[length];

        generator = new intGenerator(length, 0, 10);
        start = System.nanoTime();
        for (int i=0; i < length; i++) {
            testArrayList.add(generator.getNext());
        }
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add integers to an array list"); 

        generator = new intGenerator(length, 0, 10);
        start = System.nanoTime();
        for (int i=0; i < length; i++) {
            testVector.add(generator.getNext());
        }
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add integers to a vector");

        generator = new intGenerator(length, 0, 10);
        start = System.nanoTime();
        for (int i=0; i < length; i++) {
            testArray[i] = generator.getNext();
        }
        end = System.nanoTime();
        printRuntimeSeconds(start, end, "add integers to an array");

        long elementSum;

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

    public static long sum(Iterator<Integer> iterator) {
        long sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }

    public static long sum(int[] array) {
        long sum = 0;
        for (int i=0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

}
