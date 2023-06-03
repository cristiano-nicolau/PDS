package ex1;
import java.util.Date;
public abstract class EmployeeDecorator{
    EmployeeInterface employee;
    EmployeeDecorator(EmployeeInterface employee){
        this.employee = employee;
    }
    public void start(Date date){
        employee.start(date);
    }
    public void work(){
        employee.work();
    }
    public void terminate(Date date){
        employee.terminate(date);
    }
}
