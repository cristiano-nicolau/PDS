package lab07.ex2;

import java.util.Scanner;

public class TermFilter extends TextDecorator {
    public TermFilter(TextInterface i) {
        super(i);
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public boolean hasnext(){
        if(sc.hasNext()) {
            return true;
        } 
        else {
            return false;
        }
    }
    @Override
    public String next(){
        String line = sc.nextLine();
        String[] words = line.split(" ");
        return words[0];
    }
}
