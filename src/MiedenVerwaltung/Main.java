package MiedenVerwaltung;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Audio audio = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Bild bild = new Bild("Gebaeude FB Informatik", 2004, "Dortmund");
        Audio audio2 = new Audio("It Means Nothing", "Stereophonics", 2007, 229);

        if (audio.equals(audio2)) {
            System.out.println("Die Objekte mit id " + audio.getId() + " und id " + audio2.getId() + " sind (fachlich) gleich");
            System.out.println("Die gleichen Objekte haben den Hashcode " + audio.hashCode());
        } else {
            System.out.println("Die Objekte mit id " + audio.getId() + " und id " + audio2.getId() + " sind nicht gleich");
            System.out.println("Die unterschiedlichen Objekte haben die Hashcodes " + audio.hashCode() + " und " + audio2.hashCode());
        }
    }


}
