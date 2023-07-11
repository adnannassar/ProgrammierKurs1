package MdeienVerwaltungTypsicher;

import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Medienverwaltung {
    private LinkedList<Medium> medien;

    public Medienverwaltung() {
        this.medien = new LinkedList<>();
    }

    public void aufnehmen(Medium m) {
        if (m != null) {
            medien.add(m);
        }
    }

    public Iterator<Medium> iterator() {
        if (medien != null && !medien.isEmpty()) {
            return medien.iterator();
        } else {
            return null;
        }
    }

    public void zeigeMedien(OutputStream stream) {
        if (medien.isEmpty()) {
            System.out.println("Liste ist leer!");
        }
        Collections.sort(medien);

        Iterator<Medium> it = medien.iterator();
        while (it.hasNext()) {
            it.next().druckeDaten(stream);
        }
    }

    public void sucheNeuesMedium() {
        Medium min = medien.get(0);
        for (Medium m : medien) {
            if (m != null && m.getJahr() > min.getJahr()) {
                min = m;
            }
        }
        if (min != null) {

            // Console
            //System.out.print("Das Neueste Medium: ");
            //min.druckeDaten();
            JOptionPane.showMessageDialog(null, "Das Neueste Medium: " + min.toString());
        }
    }

    public double berechneErscheinungsjahr() {
        double sum = 0;
        int counter = 0;

        for (Medium m : medien) {
            if (m != null) {
                sum += m.getJahr();
                counter++;
            }
        }
        if (counter != 0) {
            return sum / counter;
        } else {
            return 0;
        }

    }

    public void speichern() {
        if (this.medien != null) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("IO/Serialization/Medienliste.ser"))) {
                objectOutputStream.writeObject(this.medien);
                System.out.println("Medienliste wurde erfolgreich serialisiert!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void laden() {
        if (this.medien != null) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("IO/Serialization/Medienliste.ser"))) {
                this.medien = (LinkedList<Medium>) objectInputStream.readObject();
                System.out.println("Medienliste wurde erfolgreich deserialisiert!");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
