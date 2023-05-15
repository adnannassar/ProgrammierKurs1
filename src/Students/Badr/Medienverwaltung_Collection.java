package Students.Badr;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Medienverwaltung_Collection {

    private Collection medien;

    public Medienverwaltung_Collection(Medium m){
        medien = new LinkedList();
        medien.add(m);
    }

    public void aufnehmen(Medium m){
        medien.add(m);
    }

    public void zeigeMedien(){
        Iterator it = medien.iterator();
        while (it.hasNext()){
            Medium medium;
            medium = (Medium) it.next();
            medium.druckeDaten();
        }
    }

    public void sucheNeueMedium(){
        int jahr;
        Medium neuesMedium = null;
        Iterator it = medien.iterator();
        if (it.hasNext()){
            Medium medium = (Medium) it.next();
            neuesMedium = medium;
            jahr = medium.getJahr();
            while (it.hasNext()){
                medium = (Medium) it.next();
                if (medium.getJahr() > jahr){
                    jahr = medium.getJahr();
                    neuesMedium = medium;
                }
            }
            System.out.print("Das neuste Medium ist: "); neuesMedium.druckeDaten();
        }
    }

    public double berechneErscheinungsjahr(){
        double sum = 0.0;
        if (medien.size() > 0){
            for (Object obj : medien){
                Medium medium = (Medium) obj;
                sum += medium.getJahr();
            }
            sum = sum / (double) medien.size();
        }
        return sum;
    }
}
