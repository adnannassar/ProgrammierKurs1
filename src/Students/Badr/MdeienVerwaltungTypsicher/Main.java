package Students.Badr.MdeienVerwaltungTypsicher;

public class Main {
    public static void main(String[] args) {
        Audio audio = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Bild bild = new Bild("Gebaeude FB Informatik", 2004, "Dortmund");
        Medienverwaltung mv = new Medienverwaltung();
        mv.aufnehmen(audio);
        mv.aufnehmen(bild);


        new Menu(mv).showMenu();
    }
}
