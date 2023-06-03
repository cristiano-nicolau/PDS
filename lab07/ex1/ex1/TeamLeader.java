package ex1;
import java.util.Date;
public class TeamLeader extends EmployeeDecorator {
    public TeamLeader(EmployeeInterface employee) {
        super(employee);
    }
    @Override
    public void start(Date date){
        super.start(date);
        System.out.println("TeamLeader started working on " + date);
    }
    @Override
    public void work(){
        super.work();
        System.out.println("TeamLeader is working");
    }
    @Override
    public void terminate(Date date){
        super.terminate(date);
        System.out.println("TeamLeader terminated on " + date);
    }
    public void plan(){
        System.out.println("TeamLeader is planning");
    }
}
