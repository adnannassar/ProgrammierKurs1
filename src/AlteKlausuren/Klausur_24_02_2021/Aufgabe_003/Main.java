package AlteKlausuren.Klausur_24_02_2021.Aufgabe_003;

import Extras.A;

public class Main {
    public static void main(String[] args) {
        Warteschlange warteschlange = new Warteschlange(10);
        BestellService bestellService = new BestellService(warteschlange, 1000);
        VersandService versandService = new VersandService(warteschlange, 1000);


        Thread t1 = new Thread(bestellService);
        Thread t2 = new Thread(versandService);

        t1.start();
        t2.start();
    }

}
