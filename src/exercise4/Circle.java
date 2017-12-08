package exercise4;

public class Circle extends Shape {
	
	public Circle(int x0, int y0, double dist) {
		super(x0, y0, dist);
	}
	
	public String getTypeName() {
		return "Circle";
	}

	public double getXMax() {
		return this.getX0() + this.getDist();
	}
	
	public double getXMin() {
		return this.getX0() - this.getDist();
	}
	
	public double getYMax() {
		return this.getY0() + this.getDist();
	}
	
	public double getYMin() {
		return this.getY0() - this.getDist();
	}
	
	public double getArea() {
		return this.getDist() * this.getDist() * Math.PI;
	}
	
	public double getPerimeter() {
		return 2 * this.getDist() * Math.PI;
	}
	
}
