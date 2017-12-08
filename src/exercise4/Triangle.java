package exercise4;

public class Triangle extends Shape {
	
	public Triangle(int x0, int y0, double dist) {
		super(x0, y0, dist);
	}
	
	public String getTypeName() {
		return "Triangle";
	}
	
	public double getXMax() {
		return this.getX0() + (this.getDist() / 2);
	}
	
	public double getXMin() {
		return this.getX0() - (this.getDist() / 2);
	}
	
	public double getYMax() {
		return this.getY0() + (1.0 / 3.0 * Math.sqrt(3) * this.getDist());
	}
	
	public double getYMin() {
		return this.getY0() - (1.0 / 6.0 * Math.sqrt(3) * this.getDist());
	}
	
	public double getArea() {
		return 1.0 / 4.0 * Math.sqrt(3) * this.getDist() * this.getDist();
	}
	
	public double getPerimeter() {
		return 3.0 * this.getDist();
	}
	
}
