package IO;

import java.io.*;


public class Data_Inputput_Output_Stream {

    public void dataWrite(String Filename) throws IOException {
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(Filename)));
            dos.writeInt(15); // 4 bytes
            dos.writeDouble(102.22); // 8 bytes 
            dos.writeBoolean(true); // 1 byte
            dos.writeUTF("HALLO"); // each Charakter  = 2bytes
            dos.flush();
            dos.close();
        } catch (FileNotFoundException ex) {
        }

    }

    public void dataRead(String Filename) throws IOException {
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(Filename)));
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readUTF());
            dis.close();
            

        } catch (FileNotFoundException ex) {
        }

    }
}
