package Students.Badr;

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
        System.out.println("ID = " + getId() + " \"" + getTitel()+ "\" " + " aufgenommen im Jahr " + getJahr() + " in " + getOrt() + "\n");
    }
}
