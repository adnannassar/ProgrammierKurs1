package Students.AmerBathish;

public class Audio extends Medium {
    private String interpret;
    private int dauer;

    public Audio(int jahr, String Titel,int dauer,String interpret) {
        super(jahr, Titel);
        this.dauer=dauer;
        this.interpret=interpret;

    }


    @Override
    public void druckeDaten() {
        System.out.println("ID: "+getId()+" \""+getTitel()+"\" von \""+ interpret+"\" aus "+getJahr()+" Spieldauer: "+ dauer+ " sek.");

    }

    public int getDauer() {
        return dauer;
    }

    public String getInterpret() {
        return interpret;
    }
}
