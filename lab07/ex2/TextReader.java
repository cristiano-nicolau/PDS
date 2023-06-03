package lab07.ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextReader implements TextInterface {
    public Scanner sc;
    public TextReader( String file) throws FileNotFoundException {
        sc=new Scanner(new File(file));   
    }
    
    @Override
    public boolean hasnext() {
        if (sc.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String next(){
        return sc.nextLine();
    }
}
