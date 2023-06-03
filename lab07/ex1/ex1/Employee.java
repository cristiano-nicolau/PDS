package ex1;
import java.util.Date;
public class Employee implements EmployeeInterface{
    public String name;
    public int age;
    public Employee(String name2, long empNum, double salary) {
    }
    @Override
    public void start(Date date) {
        System.out.println("Employee started working on " + date);
    }
    @Override
    public void work() {
        System.out.println("Employee is working");
    }
    @Override
    public void terminate(Date date) {
        System.out.println("Employee terminated on " + date);
    }
    public int getEmpNum() {
        return 0;
    }
    public String getName() {
        return null;
    }
    public int getSalary() {
        return 0;
    }


}
