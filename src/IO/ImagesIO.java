package IO;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImagesIO {

    public static void main(String args[]) throws IOException {
        int width = 963; // width of the Image
        int height = 640; // height of the Image
        BufferedImage image = null;
        File file = null;
        // read the image 
        try {
            file = new File("C:\\Users\\Home\\Desktop\\yasin\\pic.JPG"); // image path 
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(file);
            System.out.println("Reading Complete");
        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }
        // write the Image 
        try{
        file = new File("C:\\Users\\Home\\Desktop\\yasin\\Copy Of pic.JPG"); // image output path 
        ImageIO.write(image, "JPG", file);
        System.out.println("Writing completed");
        }catch(IOException ex ){
            System.out.println("Error "+ex);
        }
    }
    public static void copyPics(String Name,String extension){
        String Inputpath = Name+"."+extension;
        String outputpath = Name +"Copy"+"."+extension;
        int width = 963; // width of the Image
        int height = 640; // height of the Image
        BufferedImage image = null;
        File file = null;
        
        // read the image 
        try {
            file = new File(Inputpath); // image path 
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(file);
            System.out.println("Reading Complete");
        } catch (IOException ex) {
            System.out.println("Error" + ex);
        }
        // write the Image 
        try{
        file = new File(outputpath); // image output path 
        ImageIO.write(image, "JPG", file);
        System.out.println("Writing completed");
        }catch(IOException ex ){
            System.out.println("Error "+ ex );
        }
        
    }
}
