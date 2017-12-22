import java.util.Arrays;
import java.util.stream.IntStream;

public class PCounting {
    private static PCounting instance;
    private PCounting(){
    }

    public static PCounting getInstance() {
        if(instance == null) {
            instance = new PCounting();
        }
        return instance;
    }

    public double pCount(IntStream stream, int k){
        int numBuckets = (int) Math.pow(2,k);
        int[] maxZeros = new int[numBuckets];
        Arrays.fill(maxZeros, 0);
        stream.map(Integer::hashCode)
                .forEach(l -> {if (maxZeros[l & (numBuckets - 1)] < trailingZeroes(l >> k))
                    maxZeros[(int)l & (numBuckets - 1)] = trailingZeroes(l >> k);});

        return Math.pow(2, IntStream.of(maxZeros).sum()/numBuckets) *numBuckets *0.79402;
    }

    private int trailingZeroes(int hashNum){
        if (hashNum == 0) {
            return 32;
        }
        int zeroNumbers = 0;
        while(((hashNum >> zeroNumbers) & 1) == 0){
            zeroNumbers += 1;
        }
        return zeroNumbers;
    }


}
