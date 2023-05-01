package MiedenVerwaltung;

public class MedienverwaltungArray {
    private Medium[] medien;

    public MedienverwaltungArray(int size) {
        this.medien = new Medium[size];
    }

    public void aufnehmen(Medium m) {
        if (m != null) {
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
        Medium min = medien[0];
        for (int i = 0; i < medien.length; i++) {
            if (medien[i] != null && medien[i].getJahr() > min.getJahr()) {
                min = medien[i];
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
        for (int i = 0; i < medien.length; i++) {
            if (medien[i] != null) {
                sum += medien[i].getJahr();
                counter++;
            }
        }
        return sum / counter;
    }


}
