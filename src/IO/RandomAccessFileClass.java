package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileClass {

    public static void main(String[] args) {
        char[] buchstaben = {'A', 'B', 'C', 'D', 'E', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        try (RandomAccessFile raf = new RandomAccessFile(new File("newfile.txt"), "rw");) {
            for (int i = 0; i < buchstaben.length; i++) {
                raf.writeChar(buchstaben[i]);
            }
            for (int i = 1; i < buchstaben.length; i += 2) {
                raf.seek(i);
                System.out.println(raf.readChar());
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }
}
