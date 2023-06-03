package lab08.ex1b;
import java.util.*;


class Company {

public static User user;
private List<Employee> emps = new ArrayList<>();

	public void admitPerson(String name, double salary) {
		Employee e = new Employee(name, salary);
		emps.add(e);
	}
	
	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}

	public void admitEmployee(Person p, double salary) {
		if (user == User.COMPANY) {
			Employee e = new Employee(p.getName(), salary);
			emps.add(e);
		}
	}
	
	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}