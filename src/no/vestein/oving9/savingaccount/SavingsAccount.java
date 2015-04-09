package no.vestein.oving9.savingaccount;

public class SavingsAccount implements IAccount {

	protected double balance = 0;
	protected double interest;
	
	public SavingsAccount(double interest) {
		this.interest = interest;
	}
	
	public void deposit(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) throw new IllegalArgumentException();
		if (balance - amount < 0) throw new IllegalStateException();
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
	
	public void endYearUpdate() {
		balance += balance * interest;
	}

}
