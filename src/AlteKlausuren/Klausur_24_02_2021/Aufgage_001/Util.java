package AlteKlausuren.Klausur_24_02_2021.Aufgage_001;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class Util {


    public static Value[] wertetabelle(double von, int n, Function<Double, Double> f) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 1");
        }
        Value[] result = new Value[n];
        for (int i = 0; i < result.length; i++) {
            double x = von + i;
            result[i] = new Value(x, f.apply(x));
        }
        return result;
    }

    public static void ausgabeFilter(Value[] values, Predicate<Double> p) {
        Arrays.stream(values).filter(v -> p.test(v.getX())).forEach(System.out::println);
    }
}
