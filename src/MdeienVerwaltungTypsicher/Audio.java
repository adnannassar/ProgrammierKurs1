package MdeienVerwaltungTypsicher;

import java.io.*;
import java.util.Objects;

public class Audio extends Medium implements Serializable {
    private String interpret;
    private int dauer;
    private final long serialVersionUID = 2;

    public Audio(){

    }
    public Audio(String titel, String interpret, int jahr, int dauer) {
        super(titel, jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    public String getInterpret() {
        return interpret;
    }

    public int getDauer() {
        return dauer;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    @Override
    public void druckeDaten(OutputStream stream) {
        PrintStream printStream = new PrintStream(stream);
        printStream.printf("ID = %d \"%s\" von %s aus %d Spieldauer: %d sek.\n", getId(), getTitel(), interpret, getJahr(), dauer);
        printStream.flush();
    }


    @Override
    public String toString() {
        return "ID = " + getId() + " \"" + getTitel() + "\"" + " von " + interpret + " aus " + getJahr() + " Spieldauer: " + dauer + " sek.";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interpret, dauer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Audio audio = (Audio) o;
        return dauer == audio.dauer && interpret.equals(audio.interpret);
    }
}
