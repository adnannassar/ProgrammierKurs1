package AlteKlausuren.Klausur_14_02_2022.Aufgabe_001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Util {
   public static void writeToFile(Angestellter a, File f) throws DateiException {
        try (PrintWriter printWriter = new PrintWriter(f)) {
            printWriter.println("Name: " + a.getName() + "\nGehalt: " + a.berechneJahreszahlung());
        } catch (FileNotFoundException e ) {
            throw new DateiException("Fahler beim schreiben in Datei!");
        }
    }
}
