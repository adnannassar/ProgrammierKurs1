package Students.Badr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Bild bild = new Bild("Gebaeude FB Informatik", 2004, "Dortmund");
        Audio audio2 = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Bild bild2 = new Bild("AudioMax Gebaeude TU", 2015, "Dortmund");

        /*
        bild.druckeDaten();


        System.out.println(audio1.hashCode());
        System.out.println(audio2.hashCode());


        System.out.println(audio1.equals(audio2));

        System.out.println(audio1.hashCode());

        System.out.println("Alter von " + audio1.getTitel() + " ist " + audio1.alter() + " Jahre alt");
        System.out.println("Alter von " + bild.getTitel() + " ist " + bild.alter() + " Jahre alt\n");


        if (audio1.equals(audio2)){
            System.out.println("Die Objekte mit Id " + audio1.getId() +  " und Id " + audio2.getId()  + " sind (fachlich) gleich");
            if (audio1.hashCode() == audio2.hashCode()) System.out.println("Die gleichen Objekte haben den Hashcode " + audio1.hashCode() + "\n");
        }

        if (!audio1.equals(bild)){
            System.out.println("Die Objekte mit Id " + bild.getId() +  " und Id " + bild.getId()  + " sind nicht gleich");
            if (audio1.hashCode() != bild.hashCode()) System.out.println("Die unterschidliche Objekte haben den Hashcode " + audio1.hashCode() + " und " + bild.hashCode());
        }


        Medienverwaltung mediaManager1 = new Medienverwaltung(50);

        mediaManager1.aufnehmen(audio1);
        mediaManager1.aufnehmen(audio2);
        mediaManager1.aufnehmen(bild);
        mediaManager1.aufnehmen(bild2);

        mediaManager1.medien[0].druckeDaten();
        mediaManager1.medien[1].druckeDaten();
        mediaManager1.medien[2].druckeDaten();


        mediaManager1.zeigeMedien();

        Medienverwaltung_Collection mediaManager2 = new Medienverwaltung_Collection(audio1);
        mediaManager2.aufnehmen(audio2);
        mediaManager2.aufnehmen(bild2);
        mediaManager2.aufnehmen(bild);

        mediaManager2.zeigeMedien();
        mediaManager2.sucheNeueMedium();
        #
         */


    }
}




