package Grundlagen;

public class Main {

    public static void main(String[] args) {

        Student st1 = new Student("Rami", "Rami2", new Adresse("Dortmud", "Teststr", 100, "12345"), new Note("Edip", 2.0f));
        System.out.println(st1.getVorname() + ", " + st1.noten[0].getName() + ": " + st1.noten[0].getMark());

        int x = 10;
        int y = 20;
        int z = 30;
        System.out.println("Before: x =  " + x);
        System.out.println("Before: y =  " + y);

        int x_before = x;
        x = y;
        y = x_before;

        System.out.println("After: x =  " + x);
        System.out.println("After: y =  " + y);


    }

    static void swap() {

    }

}