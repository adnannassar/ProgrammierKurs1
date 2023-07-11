package IO;

import java.io.File;
import java.io.FileFilter;

public class FilterInterFace {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\Home\\Desktop\\Files");
        File fileNmaes[] = f.listFiles(new pdfFilter());
        for(File f1 : fileNmaes){
            System.out.println(f1.getName());
        }

    }

}

class pdfFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.toString().toLowerCase().endsWith(".pdf");
    }

}
