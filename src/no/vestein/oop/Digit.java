package no.vestein.oop;

public class Digit {

	private int tallsystem;
	private int siffer;
	
	Digit(int n) {
		this.tallsystem = n;
	}
	
	@Override
	public String toString() {
		//return "Digit [tallsystem=" + tallsystem + ", siffer="
		//		+ this.getChar() + "]";
		return this.getChar();
	}
	
	String getChar() {
		if (this.siffer >= 10) {
			return String.valueOf((char)(this.siffer - 10 +'A'));
		}
		return Integer.toString(this.siffer);
	}
	
	int getValue() {
		return this.siffer;
	}
	
	boolean increment() {
		this.siffer = this.siffer + 1;
		if (this.siffer == this.tallsystem) {
			this.siffer = 0;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Digit test = new Digit(16);
		
		System.out.println(test);
		
		test.increment();
		System.out.println(test);
		
		test.increment();
		System.out.println(test);
		
		test.increment();
		System.out.println(test);
		
		//System.out.println(String.valueOf((char)(test.getValue() +'A')));
	}
	
}
