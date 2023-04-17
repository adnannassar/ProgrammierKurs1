package Students.AmerBathish;

public abstract class Medium {
    private int id;
    private String Titel;
    private int jahr;
    static int cont=0;



    public Medium (int jahr, String Titel){
        this.jahr=jahr;
        this.Titel=Titel;
        id=cont;
        cont++;
    }


    int x= java.time.LocalDate.now().getYear();

    public int alter(){
        return x-getJahr();

    }
    public abstract void druckeDaten();


    public int getId() {
        return id;
    }

    public int getJahr() {
        return jahr;
    }

    public String getTitel() {
        return Titel;
    }
}

