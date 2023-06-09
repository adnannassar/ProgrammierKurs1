package Students.Badr;

import java.time.LocalDate;
import java.util.Objects;


public abstract class Medium {
    private final int id;
    public static int counter = 0;
    private String titel;
    private int jahr;

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
    public int hashCode() {return Objects.hash(this.titel, this.jahr);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Medium other = (Medium) o;
        if (!this.titel.equals(other.titel)) return false;
        if (this.jahr != other.jahr) return false;
        return true;
    }

}
