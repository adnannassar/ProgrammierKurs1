package AlteKlausuren.Klausur_24_02_2021.Aufgabe_003;

public class VersandTask implements Runnable {
    private Bestellung bestellung;

    public VersandTask(Bestellung bestellung) {
        this.bestellung = bestellung;
    }

    @Override
    public void run() {
        if(bestellung != null)
        System.out.println(bestellung.getName() + " sent!");
    }
}
