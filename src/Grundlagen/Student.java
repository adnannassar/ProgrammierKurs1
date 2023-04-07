package Grundlagen;

public class Student {
    private String vorname, nachanem;
    private Adresse adresse;

    Note[] noten;

    public Student(String vorname, String nachname, Adresse adresse, Note firstNote) {
        this.vorname = vorname;
        this.nachanem = nachname;
        this.adresse = adresse;
        this.noten = new Note[35];
        this.noten[0] = firstNote;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachanem() {
        return nachanem;
    }

    public void setNachanem(String nachanem) {
        this.nachanem = nachanem;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Note[] getNoten() {
        return noten;
    }

    public void setNoten(Note[] noten) {
        this.noten = noten;
    }
}
