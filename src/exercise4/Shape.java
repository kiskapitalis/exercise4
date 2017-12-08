package exercise4;

public abstract class Shape {
	private int x0, y0;
	private double dist;
	
	public Shape(int x0, int y0, double dist) throws NumberFormatException {
		this.x0 = x0;
		this.y0 = y0;
		if (dist < 0.0)
			throw new NumberFormatException("Cannot construct a shape with negative dist.");
		this.dist = dist;
	}
	@Override
	public String toString() {
		return "Shape [getX0()=" + getX0() + ", getY0()=" + getY0() + ", getDist()=" + getDist() + ", getDiff()="
				+ getDiff() + ", getRectangleArea()=" + getRectangleArea() + ", getTypeName()=" + getTypeName()
				+ ", getXMax()=" + getXMax() + ", getXMin()=" + getXMin() + ", getYMax()=" + getYMax() + ", getYMin()="
				+ getYMin() + ", getArea()=" + getArea() + ", getPerimeter()=" + getPerimeter() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getX0() {
		return x0;
	}

	public int getY0() {
		return y0;
	}

	public double getDist() {
		return dist;
	}
	
	public double getDiff(){
		return Math.abs(this.getArea() - this.getPerimeter());
	}
	
	public double getRectangleArea(){
		return (this.getXMax() - this.getXMin()) * (this.getYMax() - this.getYMin());
	}
	
	public abstract String getTypeName();

	public abstract double getXMax();
	
	public abstract double getXMin();
	
	public abstract double getYMax();
	
	public abstract double getYMin();
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
}
