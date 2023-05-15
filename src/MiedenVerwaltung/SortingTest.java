package MiedenVerwaltung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(list);
        // list.sort();
        Collections.sort(list);

        System.out.println(list);

    }
}
