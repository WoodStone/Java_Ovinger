package no.vestein.oop;

public class Rectangle {

	int minX, maxX;
	int minY, maxY;
	int width = 0;
	int height = 0;

	@Override
	public String toString() {
		return "Rectangle [minX=" + minX + ", maxX=" + maxX + ", minY=" + minY
				+ ", maxY=" + maxY + "]";
	}
	
	private void add(int minX, int maxX, int minY, int maxY) {
		if (this.isEmpty()) {
			this.maxX = maxX;
			this.minX = minX;
			this.maxY = maxY;
			this.minY = minY;
		} else {
			if (minX < this.minX) this.minX = minX;
			if (maxX > this.maxX) this.maxX = maxX;
			if (minY < this.minY) this.minY = minY;
			if (maxY > this.maxY) this.maxY = maxY;
		}
		this.height = this.maxY - this.minY + 1;
		this.width = this.maxX - this.minX + 1;
	}
	
	boolean add(int x, int y) {
		if (this.contains(x, y)) return false;
		this.add(x, x, y, y);
		return true;
	}
	
	boolean add(Rectangle rect) {
		if (this.contains(rect)) return false;
		this.add(rect.minX, rect.maxX, rect.minY, rect.maxY);
		return true;
	}
	
	Rectangle union(Rectangle rect) {
		Rectangle newRect = new Rectangle();
		newRect.add(this);
		newRect.add(rect);
		return newRect;
	}
	
	int getMinX() { return this.minX; }
	
	int getMinY() { return this.minY; }
	
	int getMaxX() { return this.maxX; }
	
	int getMaxY() { return this.maxY; }
	
	int getWidth() { return this.width; }
	
	int getHeight() { return this.height; }
	
	boolean isEmpty() { return this.height == 0; }
	
	boolean contains(int x, int y) {
		if (this.isEmpty()) return false;
		return x >= this.minX && x <= this.maxX && y >= this.minY && y <= this.maxY;
	}
	
	boolean contains(Rectangle rect) {
		if (rect.isEmpty()) return false;
		return rect.minX >= this.minX && rect.maxX <= this.maxX && rect.minY >= this.minY && rect.maxY <= this.maxY; 
	}
	
	public static void main(String[] args) {
		Rectangle test = new Rectangle();
		System.out.println(test.isEmpty());
		System.out.println(test.add(13, -27));
		System.out.println(test.contains(13, -27));
	}
	
}
