package ex1;
import java.util.Date;
public class Manager extends EmployeeDecorator {
    public Manager(EmployeeInterface employee) {
        super(employee);
    }
    @Override
    public void start(Date date){
        super.start(date);
        System.out.println("Manager started working on " + date);
    }
    @Override
    public void work(){
        super.work();
        System.out.println("Manager is working");
    }
    @Override
    public void terminate(Date date){
        super.terminate(date);
        System.out.println("Manager terminated on " + date);
    }
    public void manage(){
        System.out.println("Manager is managing");
    }
}
