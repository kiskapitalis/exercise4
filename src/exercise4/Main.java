package exercise4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		List<Shape> Shapes = new ArrayList<Shape>();
		Scanner cin = new Scanner(System.in);
		tryFileParser(Shapes, cin);
		cin.close();
		calculator(Shapes);
	}

	private static void tryFileParser(List<Shape> Shapes, Scanner cin) {
		boolean success = false;
		while (!success) {
			try 
			{
				fileParser(Shapes, cin);
				success = true;
			}
			catch (FileNotFoundException e) {
				System.out.println("A megadott fájl nem található");}
			catch(NumberFormatException e) {
				System.out.println("Az elsõ sor tartalma egész szám kell legyen, mely az alakzatok számát jelöli");}
			catch (NoSuchElementException e) {
				System.out.println("Az inputfájl a megadottnál rövidebb");}
			catch (LineException e) {
				System.out.println(e);}
		}
	}

	private static void fileParser(List<Shape> Shapes, Scanner cin) throws FileNotFoundException, LineException, NoSuchElementException, NumberFormatException {
		String fpath = inputFile(cin);
		Scanner infile = new Scanner(new FileReader(fpath));
		int n = Integer.parseInt(infile.nextLine());
		for (int i = 0; i < n; ++i) {
			String line = infile.nextLine();
			generateShape(line, i, Shapes);
		}
		infile.close();
	}

	public static String inputFile(Scanner cin) {
		System.out.println("Please enter the input file name!");
		String fpath = cin.next();
		return fpath;
	}

	private static void generateShape(String line, int i, List<Shape> Shapes) throws LineException {
		
		Pattern shapeLine = Pattern.compile("(?<type>[0,3,4,6])\\s+(?<x0>-?\\d+)\\s+(?<y0>-?\\d+)\\s+(?<dist>\\d+)");
		Matcher m = shapeLine.matcher(line);
		if (!m.find()) {
			throw new LineException("Invalid line content at line: " + (i+2));
		}
		int type = Integer.parseInt(m.group("type"));
		int x0 = Integer.parseInt(m.group("x0"));
		int y0 = Integer.parseInt(m.group("y0"));
		double dist = Double.parseDouble(m.group("dist"));
		
		// generate Shape Object for every line
		if (type == 0)
			Shapes.add(new Circle(x0, y0, dist));
		else if (type == 3)
			Shapes.add(new Triangle(x0, y0, dist));
		else if (type == 4)
			Shapes.add(new Square(x0, y0, dist));
		else
			Shapes.add(new Hexagon(x0, y0, dist));
		
	}
	
	private static void calculator(List<Shape> Shapes) {

		double xMax = Shapes.get(0).getXMax();
		double xMin = Shapes.get(0).getXMax();
		double yMax = Shapes.get(0).getYMax();
		double yMin = Shapes.get(0).getYMax();
		double minDiff = Math.abs(Shapes.get(0).getArea() - Shapes.get(0).getPerimeter());
		int diffId = 0;
		double maxArea = 0;
		int areaId = 0;
		
		for (int Id = 0; Id < Shapes.size(); ++Id)
		{
			//System.out.println(Shapes.get(Id).toString());

			if(Shapes.get(Id).getXMax() > xMax)
				xMax = Shapes.get(Id).getXMax();
			if(Shapes.get(Id).getXMin() < xMin)
				xMin = Shapes.get(Id).getXMin();
			if(Shapes.get(Id).getYMax() > yMax)
				yMax = Shapes.get(Id).getYMax();
			if(Shapes.get(Id).getYMin() < yMin)
				yMin = Shapes.get(Id).getYMin();
			if(minDiff > Shapes.get(Id).getDiff()){	
				minDiff = Shapes.get(Id).getDiff();
				diffId = Id;}
			if(Shapes.get(Id).getRectangleArea() > maxArea) {
				maxArea = Shapes.get(Id).getRectangleArea();
				areaId = Id;}
		}
		

		System.out.println("1.) A mindent lefedõ téglalap:");
		System.out.println("Maximumai:  maxX = " + xMax);
		System.out.println("            maxY = " + yMax);
		System.out.println("Maximumai:  minX = " + xMin);
		System.out.println("            minY = " + yMin);
		System.out.println("Középpontja:   X = " + (xMin + xMax) / 2 );
		System.out.println("               Y = " + (yMin + yMax) / 2 );
		System.out.println("Oldalhosszai: dX = " + (xMax - xMin));
		System.out.println("              dY = " + (yMax - yMin));
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("2.) A(z) " + (diffId + 1) + ". síkidom esetén a legkisebb az eltérés a terület és a kerület között.");
		System.out.println("    Eltérés: " + minDiff);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("3.) A(z) " + (areaId + 1) + ". síkidom köré írt téglalap a legnagyobb méretû");
		System.out.println("    Területe: " + maxArea);	
	}
}
