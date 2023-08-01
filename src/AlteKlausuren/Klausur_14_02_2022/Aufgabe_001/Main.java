package AlteKlausuren.Klausur_14_02_2022.Aufgabe_001;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            Util.writeToFile(new Angestellter("Gates", 100000),
                    new File("test.txt"));
        } catch (DateiException e) {
            System.out.println(e.getMessage());
        }
    }
}
