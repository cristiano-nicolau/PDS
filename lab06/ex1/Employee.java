package ex1;

public class Employee {
    private String name;
    private int emp_num;
    private int salary;

    public Employee(String name, int emp_num, int salary) {
        this.name = name;
        this.emp_num = emp_num;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmpNum() {
        return emp_num;
    }

    public int getSalary() {
        return salary;
    }
}
