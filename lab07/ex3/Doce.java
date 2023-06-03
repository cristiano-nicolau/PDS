package lab07.ex3;

public class Doce extends item{
    private String name;
    private float capacity;

    public Doce(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public String print(){
        return "* Doce " + name + " [ Weight: " + capacity + " ]";
    }

    public float getweight(){
        return capacity;
    }
}
