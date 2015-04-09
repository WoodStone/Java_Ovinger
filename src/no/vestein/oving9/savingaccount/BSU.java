package no.vestein.oving9.savingaccount;

public class BSU extends SavingsAccount {
	
	private double depositLimit;
	private double depositAmount;

	public BSU(double interest, double depositLimit) {
		super(interest);
		this.depositLimit = depositLimit;
	}

	public double getTaxDeduction() {
		return depositAmount * 0.2;
	}
	
	@Override
	public void withdraw(double amount) {
		if (depositAmount - amount < 0) throw new IllegalStateException();
		super.withdraw(amount);
		depositAmount -= amount;
	}
	
	@Override
	public void deposit(double amount) {
		if (depositAmount + amount > depositLimit) throw new IllegalStateException();
		super.deposit(amount);
		depositAmount += amount;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		depositAmount = 0;
	}
	
}
