package Students.Badr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Audio audio2 = new Audio("It Means Nothing", "Stereophonics", 2007, 229);
        Bild bild = new Bild("Gebaeude FB Informatik", 2004, "Dortmund");

        bild.druckeDaten();


        System.out.println(audio1.hashCode());
        System.out.println(audio2.hashCode());


        System.out.println(audio1.equals(audio2));

        System.out.println(audio1.hashCode());

        System.out.println("Alter von " + audio1.getTitel() + " ist " + audio1.alter() + " Jahre alt");
        System.out.println("Alter von " + bild.getTitel() + " ist " + bild.alter() + " Jahre alt");
    }




}
