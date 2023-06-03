package lab08.ex2;


public class BankAccountProxy implements BankAccount{
    BankAccount ba;

    BankAccountProxy(BankAccount ba){
        this.ba= ba;
    }
    
    @Override
    public void deposit(double amount) {
        this.ba.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if(Company.user==User.COMPANY){
            return false;
        }
        else{
            return this.ba.withdraw(amount);
        }
    }

    @Override
    public double balance() {
        if(Company.user==User.COMPANY){
            return 0;
        }
        else{
            return this.ba.balance();
        }
    }
    
}
