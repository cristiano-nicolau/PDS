package lab07.ex3;

public class Bebida extends item{
    private String name;
    private float capacity;

    public Bebida(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public String print(){
        return "* Bebida " + name + " [ Weight: " + capacity + " ]";
    }

    public float getweight(){
        return capacity;
    }
    
}
