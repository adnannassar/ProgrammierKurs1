package Grundlagen;

public class Adresse {
    private String ort;
    private String straße;
    private int nr;
    private String plz;

    public Adresse(String ort, String straße, int nr, String plz) {
        this.ort = ort;
        this.straße = straße;
        this.nr = nr;
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
}
