package AlteKlausuren.Klausur_24_02_2021.Aufgabe_003;

public class Bestellung {
    private String name;

    public Bestellung(String name) {
        this.name = name;
        System.out.println("Bestellung " + name + " was created!");
    }

    public String getName() {
        return name;
    }
}
