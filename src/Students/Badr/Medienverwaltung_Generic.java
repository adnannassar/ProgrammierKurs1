package Students.Badr;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Medienverwaltung_Generic {

    private List<Medium> medien;

    public Medienverwaltung_Generic() {this.medien = new LinkedList<>();}

    public void aufnehmen (Medium m){medien.add(m);}

    public void zeigeMedien(){
        Iterator<Medium> it = medien.iterator();
        while (it.hasNext()){
           it.next().druckeDaten();
        }
    }

    public void sucheNeueMedium(){
        Medium neu = null;
        int jahr;
        Iterator<Medium> it = medien.iterator();
        if (it.hasNext()){
            neu = it.next();
            jahr = neu.getJahr();
            while (it.hasNext()){
                Medium medium = it.next();
                if (medium.alter() < jahr){
                    jahr = medium.alter();
                    neu = medium;
                }
            }
            neu.druckeDaten();
        }
    }

    public double berechneErscheinungsjahr(){
        double jahr = 0.0;
        if (medien.size() > 0){
            for (Medium medium: medien){
                jahr += medium.getJahr();
            }
        }
        return jahr / (double) medien.size();
    }

}
