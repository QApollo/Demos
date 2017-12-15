
import java.util.stream.IntStream;


public class RegularCounting {
    public static long regularCount(IntStream stream){
        return stream.distinct().count();
    }
}
