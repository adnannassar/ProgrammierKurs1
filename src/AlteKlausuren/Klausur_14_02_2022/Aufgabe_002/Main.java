package AlteKlausuren.Klausur_14_02_2022.Aufgabe_002;

import Extras.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>(
                Arrays.asList(
                        new Car("BMW", 1000),
                        new Car("Audi", 2000),
                        new Car("Tesla", 500),
                        new Car("Tesla", 1500))
        );

        System.out.println("Most Expensive: " + Dealership.mostExpensive(list).get());
        System.out.println("Total PriceOf: " + Dealership.totalPriceOf(list));
        System.out.println("Total Number Of Teslas: " + Dealership.totalNumberOf(new CarTeslaPredicate(), list));

    }
}
