package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Reader_Writers {

    public static void CopyFile(String fileName, String extension) throws IOException {
        File file = new File("C:\\Users\\Home\\Desktop\\Files\\" + fileName + "." + extension);
        try {
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter("C:\\Users\\Home\\Desktop\\Files\\" + "Copy of " + fileName + "." + extension);
            int a;  // a will work with 2Bytes 
            while ((a = fr.read()) != -1) {
                fw.write(a);
            }
            System.out.println("File has been copied ");
            fr.close();
            fw.flush();
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found !! ");
        }

    }

    public static void CopyFileBuffering(String fileName, String extension) throws IOException {
        File file = new File("C:\\Users\\Home\\Desktop\\Files\\" + fileName + "." + extension);
        try {
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter("C:\\Users\\Home\\Desktop\\Files\\" + "Copy of " + fileName + "." + extension);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            int a;  // a will work with 2 Bytes 
            while (       (a = br.read())      != -1) {
                bw.write(a);
            }
            System.out.println("File has been copied ");
            br.close();
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found !! ");
        }

    }

    public static void CopyFileBufferingWithReadLine(String fileName, String extension) throws IOException {
        File file = new File("C:\\Users\\Home\\Desktop\\Files\\" + fileName + "." + extension);
        try {
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter("C:\\Users\\Home\\Desktop\\Files\\" + "Copy of " + fileName + "." + extension);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            String a;  //  a is a String this time
            // the writer class can write 
            while ((a = br.readLine()) != null) {
                bw.write(a + "\r\n"); // or bw.newLine();
                /* the bes way to make zeilen umbruch is to us the methode: !! bw.newLine(); !!
                 it is better than "\r\n" because not all operationg systems are supporting "\r\n"
                 */
            }
            System.out.println("File has been copied using the Methode ReadLine ");
            br.close();
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found !! ");
        }

    }

    public static void CopyFileBufferingWithPrintWriterPrintln(String fileName, String extension) throws IOException {
        File file = new File("C:\\Users\\Home\\Desktop\\Files\\" + fileName + "." + extension);
        try {
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter("C:\\Users\\Home\\Desktop\\Files\\" + "Copy of " + fileName + "." + extension);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            String a;  //  a is String this time
            // best way to write 
            while ((a = br.readLine()) != null) {
                pw.println(a);
            }
            System.out.println("File has been copied using the Methode ReadLine ");
            br.close();
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found !! ");
        }

    }

    public static void CreatingArrayUsningBufferingWithPrintWriterPrintF(String fileName, String extension) throws IOException {
        File file = new File("C:\\Users\\Home\\Desktop\\Files\\" + fileName + "." + extension);
        String[] useres = {"Adnan", "yasin", "hamoda", "nassar"};
        int[] ages = {28, 22, 24, 23};
        try (
                FileWriter fw = new FileWriter("C:\\Users\\Home\\Desktop\\Files\\" + fileName + "." + extension);
                PrintWriter pw = new PrintWriter(new BufferedWriter(fw));) {

            pw.printf("Names :         Age:\r\n");
            pw.printf("-------------------\r\n");
            for (int i = 0; i < useres.length; i++) {
                pw.printf("%-8s %10d\r\n", useres[i], ages[i]);
            }
            System.out.println("Array has been created");

        } catch (FileNotFoundException ex) {
            System.out.println("File Not found !! ");
        }

    }

}
