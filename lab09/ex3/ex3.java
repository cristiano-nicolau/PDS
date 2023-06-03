package lab09.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ex3 {
    public static void main(String[] args) {
        System.out.println("\nTests with Strings\n");
        List<String> testList = new ArrayList<>();

        AddCommand<String> add = new AddCommand<String>(testList);
        RemoveCommand<String> remove = new RemoveCommand<String>(testList);

        add.execute("Sol");
        add.execute("Chuva");
        add.execute("Nublado");
        add.execute("Neve");
        add.execute("Geada");
        add.execute("Granizo");

        System.out.println("After execute adds:   " + testList);

        add.undo();
        add.undo();
        add.undo();

        System.out.println("After execute undo:   " + testList);

        remove.execute("Sol");
        remove.execute("Chuva");
        
        System.out.println("After execute removes:" + testList);

        remove.undo();
        remove.undo();

        System.out.println("After execute undo:   " + testList);


        System.out.println("\nTests with Integers\n");

        List<Integer> integerList = new ArrayList<>();

        AddCommand<Integer> addInteger = new AddCommand<Integer>(integerList);
        RemoveCommand<Integer> removeInteger = new RemoveCommand<Integer>(integerList);

        addInteger.execute(1);
        addInteger.execute(2);
        addInteger.execute(3);
        addInteger.execute(4);
        addInteger.execute(5);
        addInteger.execute(6);

        System.out.println("After execute adds:   " + integerList);

        addInteger.undo();
        addInteger.undo();
        addInteger.undo();

        System.out.println("After execute undo:   " + integerList);

        removeInteger.execute(1);
        removeInteger.execute(2);
        
        System.out.println("After execute removes:" + integerList);

        removeInteger.undo();

        System.out.println("After execute undo:   " + integerList);

      
    }
    
}
