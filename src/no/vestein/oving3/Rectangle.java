package no.vestein.oving3;

public class Rectangle {

	private int minX, maxX;
	private int minY, maxY;
	private int width;
	private int height;

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
	
	public boolean add(int x, int y) {
		if (this.contains(x, y)) return false;
		this.add(x, x, y, y);
		return true;
	}
	
	public boolean add(Rectangle rect) {
		if (this.contains(rect)) return false;
		this.add(rect.minX, rect.maxX, rect.minY, rect.maxY);
		return true;
	}
	
	public Rectangle union(Rectangle rect) {
		Rectangle newRect = new Rectangle();
		newRect.add(this);
		newRect.add(rect);
		return newRect;
	}
	
	public Rectangle intersection(Rectangle rect) {
		Rectangle newRect = new Rectangle();
		int minX, maxX;
		int minY, maxY;
		minX = this.minX;
		maxX = this.maxX;
		minY = this.minY;
		maxY = this.maxY;
		if (this.minX < rect.minX) minX = rect.minX;
		if (this.maxX > rect.maxX) maxX = rect.maxX;
		if (this.minY < rect.minY) minY = rect.minY;
		if (this.maxY > rect.maxY) maxY = rect.maxY;
		newRect.add(minX, maxX, minY, maxY);
		return newRect;
	}
	
	public boolean intersects(Rectangle rect) {
		return this.maxX > rect.minX &&
				this.maxY > rect.minY &&
				rect.maxX > this.minX &&
				rect.maxY > this.minY;
	}
	
	public int getMinX() { return this.minX; }
	
	public int getMinY() { return this.minY; }
	
	public int getMaxX() { return this.maxX; }
	
	public int getMaxY() { return this.maxY; }
	
	public int getWidth() { return this.width; }
	
	public int getHeight() { return this.height; }
	
	public boolean isEmpty() { return this.height == 0; }
	
	public boolean contains(int x, int y) {
		if (this.isEmpty()) return false;
		return x >= this.minX &&
				x <= this.maxX &&
				y >= this.minY &&
				y <= this.maxY;
	}
	
	public boolean contains(Rectangle rect) {
		if (rect.isEmpty()) return false;
		return rect.minX >= this.minX && 
				rect.maxX <= this.maxX && 
				rect.minY >= this.minY && 
				rect.maxY <= this.maxY; 
	}
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		Rectangle r3 = new Rectangle();
		Rectangle r4 = new Rectangle();
		
		r1.add(3, 12, 4, 12);
		r2.add(7, 16, 7, 15);
		r3.add(5, 14, 2, 8);
		r4.add(5, 10, 6, 10);
		
		System.out.println(r1);
		System.out.println(r2);
		
		Rectangle rNew = r1.intersection(r3);
		System.out.println(rNew);
	}
	
}
