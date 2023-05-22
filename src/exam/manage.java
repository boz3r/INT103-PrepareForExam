package exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class manage implements room {

    public void WriteFile(String filename, String data) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(data);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String FileReader(String filename) {
        try {
            String data;
            BufferedReader buff = new BufferedReader(new FileReader(filename));
            while ((data = buff.readLine()) != null) {
                return data;
            }
        } catch (IOException ex) {
            Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public void ReverseEngineer() {
        System.out.println("Room information are in \"RE.dat\"");
        WriteFile("RE.dat", "3478");
    }

    @Override
    public void Forensics() {
        System.out.println("Room information are in \"DF.txt\"");
        WriteFile("DF.txt", "8743");
    }

    @Override
    public void Pwnable() {
        System.out.println("I know nothing about this....");
        int REvalue = Integer.parseInt(FileReader("RE.dat"));
        int DFvalue = Integer.parseInt(FileReader("DF.txt"));
        System.out.printf("0xab%d", REvalue+DFvalue);
    }
}
