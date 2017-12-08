package exercise4;

public class Hexagon extends Shape {
	
	public Hexagon(int x0, int y0, double dist) {
		super(x0, y0, dist);
	}
	
	public String getTypeName() {
		return "Hexagon";
	}

	public double getXMax() {
		return this.getX0() + (Math.sqrt(3) * this.getDist() / 2);
	}	

	public double getXMin() {
		return this.getX0() - (Math.sqrt(3) * this.getDist() / 2);
	}
	
	public double getYMax() {
		return this.getY0() + this.getDist();
	}
	
	public double getYMin() {
		return this.getY0() - this.getDist();
	}
	
	public double getArea() {
		return 3.0 / 2.0 * Math.sqrt(3) * this.getDist() * this.getDist();
	}
	
	public double getPerimeter() {
		return 6 * this.getDist();
	}
	
}