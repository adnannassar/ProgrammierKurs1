package Students.Badr;

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
        System.out.printf("ID = " + getId() + " "  + " \"" + getTitel() + "\"" + " von " + getInterpret() + " aus " + getJahr() + " Spieldauer: " + getDauer() +" sek." + "\n");
    }
}
