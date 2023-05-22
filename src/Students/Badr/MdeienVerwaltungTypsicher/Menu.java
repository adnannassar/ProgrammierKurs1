package Students.Badr.MdeienVerwaltungTypsicher;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Medienverwaltung mv;

    public Menu(Medienverwaltung mv) {
        this.mv = mv;
    }

    public void showMenu() {
        int option;
        do {
            System.out.println(
                    "\n\nMedienverwaltung\n" +
                            "1. Audio aufnehmen\n" +
                            "2. Bild aufnehmen\n" +
                            "3. Zeige alle Medien\n" +
                            "4. Zeige neues Medium\n" +
                            "5. Berechne durchschnittliches Erscheinungsjahr\n" +
                            "6. Beenden\n");
            System.out.print("Bitte Menuepunkt waehlen: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    addAudio();
                    break;
                case 2:
                    addBild();
                    break;
                case 3:
                    mv.zeigeMedien();
                    break;
                case 4:
                    mv.sucheNeuesMedium();
                    break;
                case 5:
                    System.out.println("Durchschnittliche Erscheinung Jahr: " + mv.berechneErscheinungsjahr());
                    break;
                case 6:
                    System.out.println("Bey Bey");
                    break;
                default:
                    System.out.println("Bitte etwas gültiges eingeben!");
            }
        } while (option != 6);

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


        int jahr = Integer.parseInt(JOptionPane.showInputDialog(null, "Jahr"));

        String ort = JOptionPane.showInputDialog(null, "Ort:");


        Bild bild = new Bild(title, jahr, ort);

        mv.aufnehmen(bild);
        System.out.println("Bild erfolgreich hinzugefügt!");
        JOptionPane.showMessageDialog(null, "Bild erfolgreich hinzugefügt!");

    }

    private void zeigeMedien(String name, ArrayList list)
    {   for(int index=0; index<list.size(); index++)
    {
        Medium c = (Medium) list.get(index);

        JOptionPane.showMessageDialog(null, c);

    }
    }
}


