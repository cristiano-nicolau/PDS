package ex2;
import java.util.List;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ContactTxt implements ContactsStorageInterface {
    private String filename;

    public ContactTxt(String filename) {
        this.filename=filename;
    }
    public List<Contact> loadContacts(){
        List<Contact> list = new ArrayList<Contact>();
        File f= new File(filename);
        try{
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split("\t");
                Contact c = new Contact(parts[0], parts[1]);
                list.add(c);
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    public boolean saveContacts(List<Contact> list){
        try{
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            for(Contact c : list){
                fw.write(c.getName() + "\t" + c.getPhone() + "\n");
            }
            fw.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return true;
    }
    
}
