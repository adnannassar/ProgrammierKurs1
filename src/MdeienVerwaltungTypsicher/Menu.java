package MdeienVerwaltungTypsicher;


import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Medienverwaltung mv;

    public Menu(Medienverwaltung mv) {
        this.mv = mv;
    }

    public void showMenu() {
        mv.laden();
        int option = 0;
        do {
            System.out.println("\n\nMedienverwaltung\n" +
                    "1. Audio aufnehmen\n" +
                    "2. Bild aufnehmen\n" +
                    "3. Zeige alle Medien\n" +
                    "4. Medienliste in Datei schreiben\n" +
                    "5. Zeige neues Medium\n" +
                    "6. Berechne durchschnittliches Erscheinungsjahr\n" +
                    "7. Speichern\n" +
                    "8. Laden\n" +
                    "9. Beenden\n");
            System.out.print("Bitte Menuepunkt waehlen: ");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addAudio();
                        break;
                    case 2:
                        addBild();
                        break;
                    case 3:
                        mv.zeigeMedien(System.out);
                        break;
                    case 4:
                        medienListInDateiSchreiben();
                        break;
                    case 5:
                        mv.sucheNeuesMedium();
                        break;
                    case 6:
                        berechneErscheinungJahr();
                        break;
                    case 7:
                        mv.speichern();
                        break;
                    case 8:
                        mv.laden();
                        break;
                    case 9:
                        System.out.println("Ciao!");
                        break;
                    default:
                        System.out.println("Bitte etwas gültiges eingeben!");
                }
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
            }

        } while (option != 7);

    }

    private void addAudio() {

        System.out.println("Adding new Audio: ");
        JOptionPane.showMessageDialog(null, "Adding new Audio");


        String title = JOptionPane.showInputDialog(null, "Title:");

        String interpret = JOptionPane.showInputDialog(null, "Interpret:");

        int jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Jahr"));

        int dauer = Integer.parseInt(JOptionPane.showInputDialog(null, "Dauer:"));
        Audio audio = new Audio(title, interpret, jahr, dauer);

        mv.aufnehmen(audio);
        System.out.println("Audio added successfully!");
        JOptionPane.showMessageDialog(null, "Audio added successfully!");

    }

    private void addBild() {

        System.out.println("Neues Bild Hinzufügen: ");
        JOptionPane.showMessageDialog(null, "Neues Bild Hinzufügen");


        String title = JOptionPane.showInputDialog(null, "Title:");

        boolean validesJahr = false;
        int jahr = 0;
        do {
            try {
                jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Jahr"));
                validesJahr = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bitte ein gültiges Jahr eingeben!");
            }
        } while (!validesJahr);

        String ort = JOptionPane.showInputDialog(null, "Ort:");


        Bild bild = new Bild(title, jahr, ort);

        mv.aufnehmen(bild);
        System.out.println("Bild erfolgreich hinzugefügt!");
        JOptionPane.showMessageDialog(null, "Bild erfolgreich hinzugefügt!");

    }

    private void medienListInDateiSchreiben() {
        String filename = JOptionPane.showInputDialog(null, "Dateiname");
        if (filename == null) {
            return;
        }
        if (filename != null && filename.length() == 0) {
            // yes --> 0, no --> 1, cancel --> 2
            int auswahl = JOptionPane.showConfirmDialog(null, "Datainame ist leer!\nneue Dateiname wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
            if (auswahl == JOptionPane.NO_OPTION) {
                return;
            } else {
                // if yes --> repeat
            }
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream("IO/MV/Medienliste.txt")) {
            mv.zeigeMedien(fileOutputStream);
            System.out.println("Medienliste wurde in Datei gespeichert!");
        } catch (IOException e) {
            System.out.println("Fahler beim Speichern!");
        }
    }

    private void berechneErscheinungJahr() {
        double erg = mv.berechneErscheinungsjahr();
        if (erg != 0) {
            JOptionPane.showMessageDialog(null, "Durchschnittliche Erscheinung Jahr: " + erg);
        } else {
            JOptionPane.showMessageDialog(null, "Kiene Medien in der Liste enthalten!");
        }
    }
}


