package eg.gov.iti.jets.io;
import java.io.*;

public class UserProperties {
    public UserProperties(){

    }
    public void saveUserProperties(String phone, String pass) throws IOException {

        String strPhone = phone;
        String strPass=pass;
        File file = new File("/RememberMe/userProperties.txt");
        FileWriter fw = new FileWriter("userProperties.txt");
        fw.write(phone);
        fw.write('\n');
        fw.write(pass);
        System.out.println("Writing successful");

        fw.close();
    }
    public void RemovePassFrmFile()  {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("userProperties.txt");
            char [] a = new char[50];
            fr.read(a);
            String string = new String(a);
            String lines[] = string.split("\\r?\\n");
             fw = new FileWriter("userProperties.txt");
            fw.write(lines[0]);
            fw.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    public String ReadUserPhone() throws IOException {
//        FileReader fr = new FileReader("userProperties.txt");
//        char [] a = new char[50];
//        fr.read(a);
//        String string = new String(a);
//       return string;
//    }
    public String[] ReadUserData() throws IOException {
        FileReader fr = new FileReader("userProperties.txt");
        char [] a = new char[50];
        fr.read(a);
        String string = new String(a);
        String lines[] = string.split("\\r?\\n");
        return lines;
    }
}
