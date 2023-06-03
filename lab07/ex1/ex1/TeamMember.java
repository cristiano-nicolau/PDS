package ex1;
import java.util.Date;
public class TeamMember extends EmployeeDecorator{
    public TeamMember(EmployeeInterface employee) {
        super(employee);
    }
    @Override
    public void start(Date date){
        super.start(date);
        System.out.println("TeamMember started working on " + date);
    }
    @Override
    public void work(){
        super.work();
        System.out.println("TeamMember is working");
    }
    @Override
    public void terminate(Date date){
        super.terminate(date);
        System.out.println("TeamMember terminated on " + date);
    }
    public void colaborate(){
        System.out.println("TeamMember is colaborating");
    }

}
