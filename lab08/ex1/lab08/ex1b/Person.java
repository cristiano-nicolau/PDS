package lab08.ex1b;

class Person {
	
private String name;
private BankAccount bankAccount;

	public Person(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}


	BankAccountProxy getBankAccountProxy() {
		return new BankAccountProxy(bankAccount);
	}
}