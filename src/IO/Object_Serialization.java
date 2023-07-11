package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Object_Serialization {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Angestellter> arrayList;

    public static void main(String[] args) {
        arrayList = new ArrayList<>();
        loadObject(new File("IO/Serialization/Angestellter.ser"));
        deleteEntry("Test");
        printList();
        add();
        printList();
    }

    public static void add() {
        System.out.println("Add new Angestellter: ");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Gehalt: ");
        double gehalt = scanner.nextDouble();
        arrayList.add(new Angestellter(name, gehalt));
        saveObject(new File("IO/Serialization/Angestellter.ser"));
    }

    private static void deleteEntry(String name) {
        int index = IntStream.range(0, arrayList.size())
                .filter(i -> name.equals(arrayList.get(i).getName()))
                .findAny()
                .orElse(-1);
        if (index >= 0) {
            arrayList.remove(index);
            saveObject(new File("IO/Serialization/Angestellter.ser"));
        } else {
            System.out.println("Not Found");
        }


    }

    private static void saveObject(File f) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f))) {
            objectOutputStream.writeObject(arrayList);
            System.out.println("Gespeichert!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadObject(File f) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f))) {
            arrayList = (ArrayList<Angestellter>) objectInputStream.readObject();
            System.out.println("Geladen!");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printList() {
        if (arrayList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            for (Angestellter a : arrayList) {
                System.out.println(a);
            }
        }
    }


}
