package MiedenVerwaltung;

public class MainTypsicher {
    public static void main(String[] args) {
        Audio audio = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Bild bild = new Bild("Gebaeude FB Informatik", 2004, "Dortmund");
        MedienverwaltungTypsicher mv = new MedienverwaltungTypsicher();

        mv.aufnehmen(audio);
        mv.aufnehmen(bild);

        mv.zeigeMedien();
        mv.sucheNeuesMedium();
        System.out.println("Durchschnittliche Erscheinung Jahr: " +mv.berechneErscheinungsjahr() );
    }
}
