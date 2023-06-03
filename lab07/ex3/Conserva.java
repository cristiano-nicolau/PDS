package lab07.ex3;

public class Conserva extends item{
    private String name;
    private float capacity;

    public Conserva(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public String print(){
        return "* Conserva " + name + " [ Weight: " + capacity + " ]";
    }

    public float getweight(){
        return capacity;
    }

}
