package MiedenVerwaltung;

import java.util.Objects;

public class Bild extends Medium {
    private String ort;

    public Bild(String titel, int jahr, String ort) {
        super(titel, jahr);
        this.ort = ort;
    }


    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public void druckeDaten() {
        System.out.println("ID = " + getId() + " \"" + getTitel() + "\" " + "aufgenommen im Jahr " + getJahr() + " in " + ort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ort);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bild bild = (Bild) o;
        return ort.equals(bild.ort);
    }
}

