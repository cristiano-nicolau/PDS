package Composite.ex1;

public class Employee implements EmployeeInterface {
    private String name;
    private Position position;

    public Employee(String name, Position position) {
        this.name = name;
        this.position = position;
    }


    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
