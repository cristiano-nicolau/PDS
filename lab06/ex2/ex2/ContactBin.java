package ex2;
import java.util.List;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactBin implements ContactsStorageInterface{
    private String filename;

    public ContactBin(String filename){
        this.filename=filename;
    }

    public List<Contact> loadContacts(){
        List<Contact> list = new ArrayList<Contact>();
        File f= new File(filename);
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split("\t");
                Contact c = new Contact(parts[0], parts[1]);
                list.add(c);
                }
              }
              catch(IOException e){
                  System.out.println("Error: " + e.getMessage());
              }
        return list;

    }

    public boolean saveContacts(List<Contact> list){
        String data = "";
        for (Contact contact : list){
            data = data + StrToBin(contact.toString())+ "\n";
        }
        try {
            Path filePath = Paths.get("contacts.bin");
            BufferedWriter bwriter = new BufferedWriter(new FileWriter(filePath.toString()));
            bwriter.write(data);
            bwriter.close();
        } catch (IOException e) {
            System.out.println("An error has occurred: couldn't write to file.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

        public static String StrToBin(String text) {
            String String="";
            String x="";
            for(int i=0;i<text.length();i++)
            {
                x=Integer.toBinaryString(text.charAt(i));
                for(int j=x.length();j<8;j++)
                {
                    x="0"+x;
                }
                String+=x+" ";
            }
            return String;
        }

}
