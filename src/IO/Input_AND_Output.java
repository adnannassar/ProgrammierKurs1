package IO;

import java.io.*;

public class Input_AND_Output {

    // methode to read bytes from file and write it in a copy of the file 
    public void copyFileSlow(String fileName, String extension) throws FileNotFoundException {
        try {
            // 4.jpg
            String path2 = "IO";
            fileName = fileName + "." + extension;
            String path = "IO" + fileName;

            // make the file 
            File file = new File(path);

            // make the fileInputStream 
            FileInputStream fis = new FileInputStream(file);
            // make the fileOutputStream
            FileOutputStream fos = new FileOutputStream(path2 + " Copy of " + fileName);

            // reading and makeing the copie 
            int a; // an integer of 4 bytes to hold a single byte 
            // very important code !!!!!!!
            while ((a = fis.read()) != -1) {
                fos.write(a);
            }
            // closing the strams 
            fis.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void copyFileFast(String fileName, String extension) throws FileNotFoundException {
        try {
            String path2 = "IO";
            fileName = fileName + "." + extension;
            String path = "IO" + fileName;

            // make the file 
            File file = new File(path);

            // make the fileInputStream 
            FileInputStream fis = new FileInputStream(file);
            // make the fileOutputStream
            FileOutputStream fos = new FileOutputStream(path2 + " Copy of " + fileName);

            // make byte array to store all the bytes form the file
            byte b[] = new byte[1000];// better multiples of 1024 
            // reading and makeing the copie 
            int a; // an integer of 4 bytes to hold a single byte 
            // very important code !!!!!!!
            while ((a = fis.read(b)) != -1) {
                fos.write(b, 0, a);
            }
            // closing the strams 
            fis.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
