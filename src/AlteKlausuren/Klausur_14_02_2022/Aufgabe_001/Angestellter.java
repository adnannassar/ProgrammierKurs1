package AlteKlausuren.Klausur_14_02_2022.Aufgabe_001;

public class Angestellter {
    private String name;
    private double gehalt;


    public Angestellter(String name, double gehalt) {
        this.name = name;
        this.gehalt = gehalt;
    }

    public String getName() {
        return name;
    }

    public double getGehalt() {
        return gehalt;
    }

    public double berechneJahreszahlung() {
        return gehalt * 12;
    }
}
