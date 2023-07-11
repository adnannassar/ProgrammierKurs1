package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyingClass {

    public static void main(String[] args) {

        try {
            CopyWithRandomAccessFile(new File("newfile.txt"), new File("CopyOFnewfile.txt"));
        } catch (IOException ex) {

        }

    }

    public static void CopyWithRandomAccessFile(File from, File to) throws IOException, FileNotFoundException {
        if (from.isFile() && to.isFile()) {
            RandomAccessFile in = new RandomAccessFile(from, "r");
            RandomAccessFile out = new RandomAccessFile(to, "rw");
            in.seek(0);
            out.seek(out.length());
            for (int i = 0; i < in.length(); i++) {
                out.write(in.read());
            }
            in.close();
            out.close();
        } else {
            System.out.println("No ! ");
        }
    }

    public static void copyWithBuffer(File from, File to) {
        if (from.isFile() && to.isFile()) {
            try (FileInputStream fis = new FileInputStream(from);
                    FileOutputStream fos = new FileOutputStream(to);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);) {
                int a;
                while ((a = bis.read()) != -1) {
                    bos.write(a);
                }
                System.out.println("DONE ! ");

            } catch (IOException ex) {
                System.err.println("IO Exction");
            }
        } else {
            System.out.println("ERROR ! ");
        }

    }
}
