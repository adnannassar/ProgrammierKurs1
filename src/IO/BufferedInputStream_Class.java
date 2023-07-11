package IO;

import java.io.*;





public class BufferedInputStream_Class {
   
   public void copyFileBufferd(String fileName,String extension) throws FileNotFoundException{
        try{
         String path2 = "IO";
         fileName=fileName+"."+extension;
         String path = "IO"+fileName;
       
         
         
         // make the file 
         File file = new File(path);
         
         // make the fileInputStream 
         FileInputStream fis = new FileInputStream(file);
         // make the fileOutputStream
         FileOutputStream fos = new FileOutputStream(path2+" Copy of "+fileName);
         //  make BufferdInputStream 
         BufferedInputStream bis= new BufferedInputStream(fis);
         //  make BufferdOutStream 
         BufferedOutputStream bos= new BufferedOutputStream(fos);
        
         
         int a; // an integer of 4 bytes to hold a single byte 
         // very important code !!!!!!!
         while((a=bis.read())!=-1)
             bos.write(a);
                 
        // closing the strams 
         bis.close();
         bos.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally{
        
            
        }
         
    }
}
