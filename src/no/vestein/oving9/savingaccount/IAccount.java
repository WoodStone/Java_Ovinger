package no.vestein.oving9.savingaccount;

public interface IAccount {
	
	public void deposit(double amount);
	
	public void withdraw(double amount);
	
	public double getBalance();

}
