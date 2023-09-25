import java.util.Random;
import java.util.PrimitiveIterator.OfInt;

public class intGenerator {
    private Random random = new Random(System.nanoTime());
    private OfInt values;

    public intGenerator(int length, int start, int end) {
        values = random.ints(length, start, end).iterator();
    }

    public int getNext() {
        return values.nextInt();
    }
}
