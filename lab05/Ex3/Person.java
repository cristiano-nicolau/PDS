package Ex3;

public class Person {
    private String name;
    //create new person
    public Person(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
