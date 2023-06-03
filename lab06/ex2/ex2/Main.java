package ex2;
import java.util.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {
    public static void main(String args[]){
        System.out.println("Text file separated by spaces \n");
        try{
            File f = new File("contacts.txt");
            FileWriter fw = new FileWriter(f);
            //write contact to file
            fw.write("John\t1234567890\n");
            fw.write("Jane\t0987654321\n");
            fw.write("Joan\t1234567890\n");
            fw.write("Jake\t0987654321\n");
            fw.close();
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        //create a new contact engine
        ContactEngine ce = new ContactEngine();
        //create a new file storage
         ContactTxt ctxt = new ContactTxt("contacts.txt");
        //create a new contact
        Contact c = new Contact("JoaoR", "123456777");
        ce.openAndLoad(ctxt);
        ce.add(c);
        //save contacts to file
        ce.saveAndClose(ctxt);
        if(ce.exist(c)==true){
            System.out.println("Contact exists");
        }
        else{
            System.out.println("Contact does not exist");
        }
        Contact c2 = ce.getByName("Jane");
        System.out.println(c2);

        //binary file
        System.out.println("Binary file \n");
        ContactBin cbin = new ContactBin("contacts.txt");
        ce.openAndLoad(cbin);
        Contact c3= new Contact("Joaodf", "123456777");
        ce.add(c3);
        ce.saveAndClose(cbin);
        if(ce.exist(c)==true){
            System.out.println("Contact exists");
        }
        else{
            System.out.println("Contact does not exist");
        }

        //another text file but now separated by comma
        System.out.println("Another text file but now separated by comma \n");
        ContactText1 ctxt1 = new ContactText1("contacts1.txt");
        ce.saveAndClose(ctxt1);
        Contact c1= new Contact("Joaott", "123456888");
        if(ce.exist(c1)==true){
            System.out.println("Contact exists");
        }
        else{
            System.out.println("Contact does not exist");
        }
        Contact c4 = ce.getByName("JoaoR");
        System.out.println(c4);
    }
}
