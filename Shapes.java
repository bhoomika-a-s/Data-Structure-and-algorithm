import java.io.*;
import java.util.*;

interface AreaCalculation {
	public void area(double length,double breadth);
	public void area(double side);
}


class Shapes {
public static void main (String st[]) {
	Square sq = new Square();
	Rectangle re = new Rectangle();
	Triangle tr = new Triangle();
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter the side of Square");
	double side = scan.nextDouble();
	System.out.println("Area of square:" + sq.area(side));
	
	System.out.println("Enter the base and height of triangle");
	double base = scan.nextDouble();
	double height = scan.nextDouble();
	System.out.println("Area of triangle:" + tr.area(base,height));
	
	System.out.println("Enter the length and breadth of rectangle");
	double length = scan.nextDouble();
	double breadth = scan.nextDouble();
	System.out.println("Area of rectangle:" + re.area(length,breadth));
}

 public class Square implements AreaCalculation {
	public void area(double side) {
		double area = side * side;
		System.out.println(area);
	}
	@override
	public void area(double length,double breadth) {
		
	}
}

 public class Rectangle implements AreaCalculation {
	public void area(double length,double breadth) {
		double area = length * breadth;
		System.out.println(area);
	}
}
	
public class Triangle implements AreaCalculation {
	public void area(double length,double height) {
		double area = 0.5 * length * height;
		System.out.println(area);
	}
}
}