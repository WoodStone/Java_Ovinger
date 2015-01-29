package no.vestein.oving2;

public class Account {

	private double balance;
	private double rate;
	
	public Account(double balance, double rate) {
		if (balance < 0 || rate < 0) throw new IllegalArgumentException("balance or rate < 0");
		this.balance = balance;
		this.rate = rate;
	}
	
	public double getBalance() { return balance; }
	
	public double getInterestRate() { return rate; }
	
	public void setInterestRate(double rate) {
		if (rate < 0) throw new IllegalArgumentException("rate < 0");
		this.rate = rate;
	}
	
	public void deposit(double amount) {
		if (amount < 0) throw new IllegalArgumentException("amount < 0");
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount < 0) throw new IllegalArgumentException("amount < 0");
		if (balance - amount < 0) throw new IllegalStateException("balance < 0");
		balance -= amount;
	}
	
}
