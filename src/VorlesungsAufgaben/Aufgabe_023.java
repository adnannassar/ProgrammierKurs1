package VorlesungsAufgaben;

import java.io.File;
import java.io.FileInputStream;

public class Aufgabe_023 {
    public static void main(String[] args) {
            aufgabe23();
    }

    public static void aufgabe23() {
        File ioFolder = new File("IO");
        if (ioFolder.exists()) {
            File[] files = ioFolder.listFiles();
            if (files.length > 0) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("[" + f.getName() + "]");
                        File[] folderContent = f.listFiles();
                        if (folderContent.length > 0) {
                            for(File f1: folderContent){
                                System.out.println("\t"+ f1.getName());
                            }
                        }
                    }
                    if(f.isFile()){
                        System.out.println(f.getName());
                    }
                }
            }
        }

    }
}
