package Students.Badr.MdeienVerwaltungTypsicher;

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

    public void zeigeMedien() {
        if(medien.isEmpty()){
            System.out.println("Liste ist leer!");
        }
        Collections.sort(medien);

        // Print using Iterator
        Iterator<Medium> it = medien.iterator();
        while (it.hasNext()) {
            it.next().druckeDaten();
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
            System.out.print("Das Neueste Medium: ");
            min.druckeDaten();
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
        return sum / counter;
    }


}
