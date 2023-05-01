package MiedenVerwaltung;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class MedienverwaltungNichtTypsicher {
    private List medien;

    public MedienverwaltungNichtTypsicher() {
        this.medien = new LinkedList();
    }

    public void aufnehmen(Medium m) {
        if (m != null) {
            medien.add(m);
        }
    }

    public void zeigeMedien() {
        // Iterator
        Iterator it = medien.iterator();
        while (it.hasNext()) {
            ((Medium) it.next()).druckeDaten();
        }
    }

    public void sucheNeuesMedium() {
        Medium min = (Medium) medien.get(0);
        for (Object m : medien) {
            if (m != null && ((Medium) m).getJahr() > min.getJahr()) {
                min = (Medium) m;
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

        for (Object m : medien) {
            if (m != null) {
                sum += ((Medium) m).getJahr();
                counter++;
            }
        }
        return sum / counter;
    }


}
