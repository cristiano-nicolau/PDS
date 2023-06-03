package lab09.ex1;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[]args){
        //test iterator
        VectorGeneric<String> v = new VectorGeneric<String>();
        v.addElem("a");
        v.addElem("b");
        v.addElem("c");
        v.addElem("d");
        v.addElem("e");
        v.addElem("f");
        v.addElem("g");
        v.addElem("h");
        v.addElem("i");
        v.addElem("j");

        System.out.println("Remove element a");
        v.removeElem("a");
        System.out.println("Get total elemets and get element 0");
        v.totalElem();
        v.getElem(0);
    

        System.out.println("\n");
        //test iterator
        Iterator<String> it = v.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("Iterator does not support remove method\n");

        ListIterator<String> it2 = v.listIterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        while(it2.hasPrevious()){
            System.out.println(it2.previous());
        }
        it2.nextIndex();
        it2.previousIndex();
        System.out.println("ListIterator does not support remove, set and add methods");
    }
}
