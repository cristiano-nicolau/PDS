package Ex3;

public class Place {
    private String name;
    //create new person
    public Place(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
