package MiedenVerwaltung;

public class MainArray {
    public static void main(String[] args) {
        Audio audio = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Bild bild = new Bild("Gebaeude FB Informatik", 2004, "Dortmund");
        MedienverwaltungArray mv = new MedienverwaltungArray(5);

        mv.aufnehmen(audio);
        mv.aufnehmen(bild);

        mv.zeigeMedien();
        mv.sucheNeuesMedium();
        System.out.println("Durchschnittliche Erscheinung Jahr: " +mv.berechneErscheinungsjahr() );
    }
}
