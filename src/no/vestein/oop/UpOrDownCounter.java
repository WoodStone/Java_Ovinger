package no.vestein.oop;

public class UpOrDownCounter {

	int end;
	int counter;
	int direction;
	
	UpOrDownCounter(int start, int end) {
		this.end = end;
		this.counter = start;
		
		if (this.counter < this.end) {
			this.direction = 1;
		} else {
			this.direction = -1;
		}
		
		
	}
	
	int getCounter() {
		return this.counter;
	}
	
	boolean count() {
		if (this.counter != this.end) {
			this.counter = this.counter + this.direction;
		}
		return this.counter != this.end;
		
	}
	
	public static void main(String[] args) {
		UpOrDownCounter test = new UpOrDownCounter(1,3);
		
		System.out.println(test.counter);
		System.out.println(test.count());
		System.out.println(test.counter);
		System.out.println(test.count());
		System.out.println(test.counter);
		System.out.println(test.count());
		System.out.println(test.counter);
		System.out.println(test.count());
	}

}
