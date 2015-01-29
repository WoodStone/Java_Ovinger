package no.vestein.oving1;

public class Account {

	double balance;
	double interestRate = 5;
	
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", interestRate=" + interestRate
				+ "]";
	}

	void deposit(double n) {
		if (n > 0) {
			this.balance = this.balance + n;
		}
	}
	
	void addInterest() {
		this.balance = this.balance + this.balance * (this.interestRate / 100);
	}

	public static void main(String[] args) {
		Account test = new Account();
		test.deposit(200);
		test.interestRate = 5;
		test.addInterest();
		System.out.println(test);
	}
	
}
