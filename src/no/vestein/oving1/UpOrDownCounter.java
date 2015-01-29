package no.vestein.oving1;

public class UpOrDownCounter {

	private int end;
	private int counter;
	private int direction;
	
	public UpOrDownCounter(int start, int end) {
		this.end = end;
		this.counter = start;
		
		if (start == end) {
			throw new IllegalArgumentException("Lik start og sluttverdi");
		} else if (start < end) {
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
