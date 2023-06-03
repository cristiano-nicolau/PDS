package lab07.ex3;

import java.util.ArrayList;

public class Caixa extends item{
    private String name;
    private float capacity;
    private float totalcapacity;
    private ArrayList<item> items = new ArrayList<item>();

    public Caixa(String name, int capacity){
        this.name = name;
        this.capacity = capacity;

    }

    public void add(item i){
        items.add(i);
    }

    public String print(){
        return "* Caixa " + name + " [ Weight: " + capacity + " ; Total : " + getweight() + "]";
    }

    public float getweight(){
        float totalcapacity = 0;
        for(item i : items){
            totalcapacity += i.getweight();
        }
        return totalcapacity+capacity;
    }
 
    public void draw(){
        System.out.println(sb.toString() + print());
        sb.append("  ");
        for (item it : items) {
            totalcapacity += 1.0;

            if (it instanceof Caixa) {
                ((Caixa) it).draw();

            } else {
                System.out.println(sb.toString() + it.print());
            }
        }
        sb.setLength(sb.length() - 2);
    }

}
