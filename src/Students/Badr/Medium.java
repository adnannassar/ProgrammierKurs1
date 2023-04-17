package Students.Badr;

import java.time.LocalDate;


public abstract class Medium {
    public int x = 10;
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

}
