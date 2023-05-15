package Grundlagen;

import java.util.Formatter;

public class StringFormatter {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        int x = 100;
        int y = 200;
        f.format("x= %d, y= %d", x, y);
        f.close();
    }
}
