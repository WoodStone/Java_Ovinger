package no.vestein.oop;

public class Digit {

	public final int tallsystem;
	private int siffer;
	
	public Digit(int tallsystem) {
		this.tallsystem = tallsystem;
	}
	
	@Override
	public String toString() {
		return this.getChar();
	}
	
	public String getChar() {
		if (siffer >= 10) return String.valueOf((char)(siffer - 10 +'A'));
		return Integer.toString(siffer);
	}
	
	public int getValue() {
		return this.siffer;
	}
	
	public boolean increment() {
		siffer++;
		if (siffer == tallsystem) {
			siffer = 0;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Digit n1 = new Digit(16);
		Digit n2 = new Digit(16);
		Digit n3 = new Digit(16);
		
		for (int i = 0; i < n3.tallsystem; i++) {
			for (int j = 0; j < n2.tallsystem; j++) {
				for (int j2 = 0; j2 < n1.tallsystem; j2++) {
					System.out.println(n3 + ":" + n2 + ":" + n1);
					n1.increment();
				}
				n2.increment();
			}
			n3.increment();
		}
		System.out.println(n3 + ":" + n2 + ":" + n1);
	}
	
}
