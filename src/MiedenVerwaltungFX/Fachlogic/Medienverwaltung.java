package MiedenVerwaltungFX.Fachlogic;

import MiedenVerwaltungFX.Datenhaltung.IDao;
import MiedenVerwaltungFX.Datenhaltung.PersistenzException;
import MiedenVerwaltungFX.Datenhaltung.SerialisierungDAO;
import MiedenVerwaltungFX.GUI.GuiUtil.MessageView;

import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Medienverwaltung {
    private LinkedList<Medium> medien;
    private SerialisierungDAO serialisierungDAO;

    public Medienverwaltung() {
        this.medien = new LinkedList<>();
        this.serialisierungDAO = new SerialisierungDAO();
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

    public String zeigeMedien() {
        StringBuilder erg = new StringBuilder();
        if (this.medien.isEmpty()) {
            erg = new StringBuilder("List ist leer!");
        } else {
            for (Medium medium : medien) {
                erg.append(medium);
            }
        }
        return erg.toString();
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

    public String getNeuesMedium() {
        String str = "";
        if (this.medien.isEmpty()) {
            str = "Es gibt keine neues Medium, weil die List leer ist!";
        } else {
            Medium min = medien.get(0);
            for (Medium m : medien) {
                if (m != null && m.getJahr() > min.getJahr()) {
                    min = m;
                }
            }
            if (min != null) {
                str += min;
            }
        }
        return str;
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

    public void speichern() throws PersistenzException {
        if (this.medien.isEmpty()) {
            throw new PersistenzException("Fehler beim Speichern!");
        }
        try {
            this.serialisierungDAO.speichern(this.medien);
        } catch (PersistenzException e) {
            throw new PersistenzException("Fehler beim Speichern!");
        }
    }

    public void laden() throws PersistenzException {
        try {
            this.medien = (LinkedList<Medium>) this.serialisierungDAO.laden();
        } catch (PersistenzException e) {
            throw new PersistenzException("Fehler beim Laden!");
        }
    }

    public void schreibeListeInDatei() throws PersistenzException, FileNotFoundException {
        if (medien.isEmpty()) {
            throw new PersistenzException("Fhler beim Schreiben der Liste in Dateo");
        }
        this.serialisierungDAO.schreibeListeInDatei(this.medien);
    }
}
