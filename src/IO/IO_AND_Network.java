package IO;

import java.io.*;
import java.net.*;

public class IO_AND_Network {

    public void copyFromInternet(String numberOfVorlesung) {
        try {
            String ss = numberOfVorlesung;
            String Name = "pk1-Teil";
            String path= "C:\\Users\\Home\\Desktop\\Files\\Hallo Welt";
            if (ss == "2" || ss == "3" || ss == "4" || ss == "5") {
                Name = Name + ss;
            }
            URL url = new URL("https://www.ilias.fh-dortmund.de/ilias/goto_ilias-fhdo_fold_632181.html" + Name + ".pdf");
            URLConnection uc = url.openConnection();
            BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+ss+".pdf"));
            int a ;
            while((a=bis.read())!=-1)
                bos.write(a);
            bis.close();
            bos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
