package IO;

import java.io.FileNotFoundException;
import java.io.IOException;


public class StreamMain {

    public static void main(String[] args)  {
        StopUhr uhr = new StopUhr();
        Input_AND_Output io = new Input_AND_Output();
        BufferedInputStream_Class bio = new BufferedInputStream_Class();
        IO_AND_Network ion = new IO_AND_Network();
        Data_Inputput_Output_Stream ds = new Data_Inputput_Output_Stream();

        System.out.println("Coping file(3MB) Slow (Byte for Byte)");
        uhr.start();
        try {
            io.copyFileSlow("Images/4", "jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        uhr.stop();
        System.out.println("Time : " + uhr.getDuration() / 1000000 + " Sekunde");

        System.out.println("-------------------------------------------");
        System.out.println("Coping file(3MB) fast (Byte array)");
        uhr.start();
        try {
            io.copyFileFast("Images/4", "jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        uhr.stop();
        System.out.println("Time : " + uhr.getDuration() / 1000000 + " Sekunde");
        System.out.println("-------------------------------------------");
        System.out.println("Coping file(3MB) Bufferd !! ");
        uhr.start();
        try {
            bio.copyFileBufferd("Images/4", "jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        uhr.stop();
        System.out.println("Time : " + uhr.getDuration() / 1000000 + " Sekunde");
        System.out.println("-------------------------------------------");
        System.out.println("Data out Put Stream in file ");
        try {
            ds.dataWrite("DATAOUTPUTSTRAM");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Data In Put Stream in file ");
        try {
            ds.dataRead("DATAOUTPUTSTRAM");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-------------------------------------------");
        // Using the Writer and the Reader 
        System.out.println("Using the Writer and the Reader ");
        try {
            Reader_Writers.CopyFile("A", "txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------");
        // Coping Files Using Print Writer with printf
        try {
            Reader_Writers.CreatingArrayUsningBufferingWithPrintWriterPrintF("UsersArray", "txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // cpying using the PrintWriter
        System.out.println("-------------------------------------------");
        System.out.println("cpying using the PrintWriter");
        try {
            Reader_Writers.CopyFileBufferingWithPrintWriterPrintln("adnan", "txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Copy Image
        System.out.println("-------------------------------------------");
        System.out.println("Copy Image ");
        ImagesIO.copyPics("C:\\Users\\Home\\Desktop\\yasin\\pic2", "JPG");
        System.out.println("-------------------------------------------");

    }

}
