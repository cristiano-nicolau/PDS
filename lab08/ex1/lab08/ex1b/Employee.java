package lab08.ex1b;

class Employee{

	private double salary;
	private String name;
	private BankAccount bankAccount;
	
	public Employee(String n, double s) {
		name = n;
		salary = s;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}

	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	public double getSalary() {
		return salary;
	}
}