package Students.Badr;

public class Medienverwaltung {

    public Medium medien[];

    public Medienverwaltung(int size) {
        medien = new Medium[size];
    }

    /*public void aufnehmen(Medium m) {
        if (m != null){
            for (int i = 0; i < medien.length; i++) {
                if (medien[i] == null) medien[i] = m;
                break;
            }
        }
    }*/
    public void aufnehmen(Medium m){
        if (m!=null) {
            for (int i = 0; i < medien.length; i++) {
                if (medien[i] == null) {
                    medien[i] = m;
                    break;
                }
            }
        }

    }

    public void zeigeMedien() {
        for (int i = 0; i < medien.length; i++) {
            if (medien[i] != null) {
                medien[i].druckeDaten();
            }
        }
    }

    public void sucheNeuesMedium() {
        Medium m = medien[0];
        for (int i = 0; i < medien.length; i++) {
            if (medien[0] != null) {
                if (medien[i].getJahr() < m.getJahr()) {
                    m = medien[i];
                }
            }
        }
        if (m != null) {
            System.out.println("Das neueste Medium ist: ");
            m.druckeDaten();
        }

    }

    public double berechneErscheinungsjahr() {
        double sum = 0.0;
        int counter = 0;
        for (int i = 0; i < medien.length; i++) {
            if (medien[i] != null)
                sum += medien[i].getJahr();
            counter++;
        }
        return sum / counter;
    }


}
