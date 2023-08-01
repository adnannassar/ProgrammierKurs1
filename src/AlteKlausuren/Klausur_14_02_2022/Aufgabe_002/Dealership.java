package AlteKlausuren.Klausur_14_02_2022.Aufgabe_002;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Dealership {
    public static Optional<Car> mostExpensive(List<Car> liste) {
        return liste.stream().max((o1, o2) -> o1.getPrice() - o2.getPrice());
    }

    public static double totalPriceOf(List<Car> liste) {
        return liste.stream().mapToDouble(Car::getPrice).sum();
    }

    public static long totalNumberOf(Predicate<Car> p, List<Car> list) {
            return list.stream().filter(p).count();
    }
}
