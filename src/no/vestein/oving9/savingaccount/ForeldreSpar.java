package no.vestein.oving9.savingaccount;

public class ForeldreSpar extends SavingsAccount {
	
	private int maxWithdraws;
	private int withdraws = 0;

	public ForeldreSpar(double interest, int maxWithdraws) {
		super(interest);
		this.maxWithdraws = maxWithdraws;
	}

	@Override
	public void withdraw(double amount) {
		if (withdraws >= maxWithdraws) throw new IllegalStateException();
		super.withdraw(amount);
		withdraws++;
	}
	
	@Override
	public void endYearUpdate() {
		super.endYearUpdate();
		withdraws = 0;
	}
	
	public int getRemainingWithdrawals() {
		return maxWithdraws - withdraws;
	}
	
}
