package no.vestein.oving1;

public class Location {

	int x;
	int y;
	
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}

	void up() {
		this.y = this.y - 1;
	}
	
	void down() {
		this.y = this.y + 1;
	}
	
	void left() {
		this.x = this.x - 1;
	}
	
	void right() {
		this.x = this.x + 1;
	}
	
	public static void main(String[] args) {
		Location test = new Location();
		System.out.println(test);
		test.up();
		test.right();
		System.out.println(test);
	}
	
}
