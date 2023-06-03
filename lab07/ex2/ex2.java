package lab07.ex2;

import java.io.FileNotFoundException;

public class ex2 {
    public static void main(String[] args) throws FileNotFoundException {
        TextDecorator t = new CapitalizationFilter((new VowelFilter(new NormalizationFilter(new TextReader("text.txt")))));
        while (t.hasnext()) {
            System.out.println(t.next());
        }
    }
    
}
