package Students.AmerBathish;

public class Bild extends Medium {

    private String ort;

    public Bild(int jahr, String Titel, String ort) {
        super(jahr, Titel);
        this.ort=ort;
    }


    @Override
    public void druckeDaten() {
        System.out.println( "ID: "+getId()+" \""+getTitel()+ "\" aufgenommen im Jahr: "+getJahr()+" in \""+ort+"\"");

    }

    public String getOrt() {
        return ort;
    }


}

