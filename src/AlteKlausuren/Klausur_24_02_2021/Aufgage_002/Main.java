package AlteKlausuren.Klausur_24_02_2021.Aufgage_002;

import AlteKlausuren.Klausur_24_02_2021.Aufgage_001.Util;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Util.ausgabeFilter(Util.wertetabelle(0, 20, aDouble -> Math.pow(aDouble, 3)), new Predicate<Double>() {
            @Override
            public boolean test(Double aDouble) {
                return aDouble % 2 == 0;
            }
        });
    }
}
