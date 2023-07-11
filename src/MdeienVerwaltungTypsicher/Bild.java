package MdeienVerwaltungTypsicher;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Objects;

public class Bild extends Medium implements Serializable {
    private String ort;
    private final long serialVersionUID = 3;

    public Bild(String titel, int jahr, String ort) {
        super(titel, jahr);
        this.ort = ort;
    }

    public Bild(){

    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public void druckeDaten(OutputStream stream) {
        PrintStream printStream = new PrintStream(stream);
        printStream.printf("ID = %d \"%s\" aufgenommen im Jahr %d in %s\n", getId(), getTitel(), getJahr(), ort);

        printStream.flush();
    }

    @Override
    public String toString() {
        return "ID = " + getId() + " \"" + getTitel() + "\" " + "aufgenommen im Jahr " + getJahr() + " in " + ort;
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

