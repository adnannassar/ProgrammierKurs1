package MiedenVerwaltungFX.Datenhaltung;

import MiedenVerwaltungFX.Fachlogic.Medium;

import java.io.*;
import java.util.*;

public class SerialisierungDAO implements IDao {


    @Override
    public void speichern(List<Medium> liste) throws PersistenzException {
        if (liste != null) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/MiedenVerwaltungFX/Datenhaltung/SavedObjects/Medienliste.ser"))) {
                objectOutputStream.writeObject(liste);
                System.out.println("Medienliste wurde erfolgreich serialisiert!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Medium> laden() throws PersistenzException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/MiedenVerwaltungFX/Datenhaltung/SavedObjects/Medienliste.ser"))) {
            List<Medium> list;
            list = (LinkedList<Medium>) objectInputStream.readObject();
            System.out.println("Medienliste wurde erfolgreich deserialisiert!");
            return list;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void schreibeListeInDatei(List<Medium> list) throws FileNotFoundException {
        if(!list.isEmpty()){
            FileOutputStream fileOutputStream = new FileOutputStream("src/MiedenVerwaltungFX/Datenhaltung/SavedObjects/Medienliste.txt");
            Collections.sort(list);
            for (Medium medium : list) {
                medium.druckeDaten(fileOutputStream);
            }
        }

    }
}
