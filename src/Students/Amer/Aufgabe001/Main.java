package Students.Amer.Aufgabe001;

public class Main {





    public static void main(String[] args) {

        Medium sp1 = new Audio(	1960,"hob Eh",2592,"umm kulthum");
        Medium sp2 = new Bild(1506,"Mona Lisa","Paris");
        sp1.druckeDaten();
        sp2.druckeDaten();
        System.out.println("\""+sp2.getTitel()+"\" ist "+sp2.alter()+" Jahre alt");
        System.out.println("\""+sp1.getTitel()+"\" ist "+sp1.alter()+" Jahre alt");


    }
}
