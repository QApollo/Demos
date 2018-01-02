
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Demo{

    public static IntStream generateDoubleStream(int size) {
        Random randomGenerator = new Random();
        return IntStream.generate(randomGenerator::nextInt).limit(size);
    }

    public static void main(String[] args){
        PCounting pCounting = PCounting.getInstance();

        int size = 1000000;

        //The regular counting method
        long startTime = System.currentTimeMillis();
        long regularCounts = generateDoubleStream(size).distinct().count();
        long endTime = System.currentTimeMillis();

        System.out.println("Total time for regular counting method is " + (endTime - startTime));
        System.out.println("Total distinct number is " + regularCounts);

        //The probabilistic counting method
        startTime = System.currentTimeMillis();
        double[] pCounts = new double[5];
        for (int i = 0; i<5; i++) {
            pCounts[i] = pCounting.pCount(generateDoubleStream(size), 10);
        }
        endTime = System.currentTimeMillis();

        System.out.println("Total time for probabilistic counting method is " + (endTime - startTime));
        System.out.println("Total distinct number is " +DoubleStream.of(pCounts).sum()/(5*regularCounts));

    }
}
