package IO;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    public static void main(String[] args) {
        Angestellter angestellter = new Angestellter("Obermeier", 10000.00);
        schreiben(angestellter, new File("IO/Angestellter.txt"));
    }


    static void schreiben(Angestellter a, File f) {
        try (PrintWriter printWriter = new PrintWriter(f)) {
            printWriter.print("Name: " + a.getName());
            printWriter.println();
            printWriter.print("Gehalt: " + a.getGehalt());
            // printWriter.printf("Name: %s\nGehalt: %.2f", a.getName(), a.getGehalt());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static class Angestellter {
        private String name;
        private double gehalt;

        public Angestellter(String name, double gehalt) {
            this.name = name;
            this.gehalt = gehalt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getGehalt() {
            return gehalt;
        }

        public void setGehalt(double gehalt) {
            this.gehalt = gehalt;
        }
    }
}
