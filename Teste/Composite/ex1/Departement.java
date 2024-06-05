package Composite.ex1;

import java.util.ArrayList;
import java.util.List;

public class Departement implements EmployeeInterface{
    public String name;
    public List<EmployeeInterface> employees = new ArrayList<EmployeeInterface>();


    public Departement(String name) {
        this.name = name;
    }

    public void addEmployee(Employee object) {
        employees.add(object);
    }

    public void addDepartment(Departement object) {
        employees.add(object);
    }

    public void showDetails() {
        System.out.println("Departement: " + name);
        for (EmployeeInterface employeeInterface : employees) {
            employeeInterface.showDetails();
        }
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
