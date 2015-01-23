package no.vestein.oop;

public class UpOrDownCounter {

	private int end;
	private int counter;
	private int direction;
	
	public UpOrDownCounter(int start, int end) {
		this.end = end;
		this.counter = start;
		
		if (this.counter < this.end) {
			this.direction = 1;
		} else {
			this.direction = -1;
		}
	}
	
	public int getCounter() {
		return counter;
	}
	
	public boolean count() {
		if (counter != end) counter += direction;
		return counter != end;	
	}
	
}
