package lab08.ex1a;

class Person {
	
private String name;
private BankAccount bankAccount;

	public Person(String n) {
		name = n;
		bankAccount = new BankAccountImpl("PeDeMeia", 0);
	}
	
	public String getName() {
		return name;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	BankAccountProxy getBankAccountProxy() {
		return new BankAccountProxy(bankAccount);
	}
}