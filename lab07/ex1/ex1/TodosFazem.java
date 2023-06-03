package ex1;
import java.util.Date;
public class TodosFazem {
    public static void main(String args[]){
        EmployeeInterface employee = new Employee();
        TeamLeader teamLeader = new TeamLeader(employee);
        TeamMember teamMember = new TeamMember(employee);
        Manager manager = new Manager(employee);
        teamLeader.start(new Date());
        teamLeader.work();
        teamLeader.terminate(new Date());
        teamLeader.plan();
        teamMember.start(new Date());
        teamMember.work();
        teamMember.terminate(new Date());
        teamMember.colaborate();
        manager.start(new Date());
        manager.work();
        manager.terminate(new Date());
        manager.manage();
    }
}