package MiedenVerwaltung;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;


public abstract class Medium implements Comparable<Medium> {
    private final int id;
    public static int counter = 0;
    private String titel;
    private int jahr;


    public Medium() {
        this.id = counter++;
    }

    public Medium(String titel, int jahr) {
        this.id = counter++;
        this.titel = titel;
        this.jahr = jahr;
    }

    public final int getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public int getJahr() {
        return jahr;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public int alter() {
        return LocalDate.now().getYear() - jahr;
    }

    public abstract void druckeDaten();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medium m = (Medium) o;
        if (this.jahr == m.jahr && this.titel.equals(m.titel)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel, jahr);
    }

    @Override
    public int compareTo(Medium o) {
        if (this.jahr > o.jahr) {
            return 1;
        } else if (this.jahr < o.jahr) {
            return -1;
        } else {
            return 0;
        }
    }
}
