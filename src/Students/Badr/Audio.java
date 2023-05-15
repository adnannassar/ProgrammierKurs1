package Students.Badr;

import java.util.Objects;

public class Audio extends Medium {
    private String interpret;
    private int dauer;

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
    public void druckeDaten() {
        System.out.println("ID = " + getId() + " \"" + getTitel() + "\"" + " von " + interpret + " aus " + getJahr() + " Spieldauer: " + dauer + " sek.");
    }

    @Override
    public String toString(){
      return "ID = " + getId() + " \"" + getTitel() + "\"" + " von " + interpret + " aus " + getJahr() + " Spieldauer: " + dauer + " sek.";
    }

    @Override
    public int hashCode() {
        return Objects.hash (super.hashCode(), this.dauer, this.interpret);}

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Audio other = (Audio) o;
        if (this.dauer != other.dauer) return false;
        if (!this.interpret.equals(other.interpret)) return false;
        return true;
    }

}
