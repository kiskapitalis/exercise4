package exercise4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestShape {

	@Test
	void TestSquare() {
		Shape s = new Square(3, 7, 20.0);
		
		assertEquals(3, s.getX0());
		assertEquals(7, s.getY0());
		assertEquals(20, s.getDist(), 0.001);
		assertEquals(400.0, s.getArea(), 0.001);
	}
	
	@Test
	void TestTriangle() {
		Shape s = new Triangle(0, 5, 17.0);
		
		assertEquals(0, s.getX0());
		assertEquals(5, s.getY0());
		assertEquals(17, s.getDist(), 0.001);
		assertEquals(125.1406, s.getArea(), 0.001);
	}
	
	@Test
	void TestCircle() {
		Shape s = new Circle(5, 5, 5.0);
		
		assertEquals(10, s.getXMax());
		assertEquals(0, s.getYMin());
		assertEquals(100.0, s.getRectangleArea(), 0.001);
	}
	
	
	@Test
	void TestShapeNegativeDist() {
		assertThrows(NumberFormatException.class, () -> new Triangle(0,0,-1.0));
	}
}
