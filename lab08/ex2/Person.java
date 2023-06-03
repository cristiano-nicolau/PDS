package lab08.ex2;

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