package IO;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\Home\\Desktop\\Files");
        if (f.isDirectory()) {
            String[] files = f.list();
            for (String str : files) {
                if (str.contains(".")) {
                    System.out.println(str);
                } else {
                    System.out.println("[" + str + "]");
                }
            }
        }
    }

}
