package exercise4;

public class Square extends Shape {
	
	public Square(int x0, int y0, double dist) {
		super(x0, y0, dist);
	}
	
	public String getTypeName() {
		return "Square";
	}
	

	public double getXMax() {
		return this.getX0() + (this.getDist() / 2);
	}
	
	public double getXMin() {
		return this.getX0() - (this.getDist() / 2);
	}
	
	public double getYMax() {
		return this.getY0() + (this.getDist() / 2);
	}
	
	public double getYMin() {
		return this.getY0() - (this.getDist() / 2);
	}
	
	public double getArea() {
		return this.getDist() * this.getDist();
	}
	
	public double getPerimeter() {
		return 4 * this.getDist();
	}
	
}
