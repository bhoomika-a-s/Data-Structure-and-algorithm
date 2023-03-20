import java.io.*;
import java.util.*;

interface Shape {
public void area(double side);
public void area(double length, double breadth);
}

class Square implements Shape {
	
	public void area(double side) {
			//double area = sq.side * sq.side;
			double area = side * side;
			System.out.println(area);
	}
	
	public static void main (String St[]) {
			Square sq = new Square();
			Scanner scan  = new Scanner(System.in);
			System.out.println("Enter the side of square");
			double lenght = scan.nextDouble();
			sq.area(lenght);
			
	}  
	@Override
	public void area(double length, double breadth) { 

	}	
	
}
/*
Class Triangle implements Shape {
	
	void area(double length, double breadth) {
		double area = 0.5 * length * breadth;
		System.out.println(area);
	}
	
	public static void main (String St[]) {
			Troangle tr = new Triangle();
			Scanner scan  = new Scanner(System.in);
			System.out.println("Enter the breadth and height of triangle");
			double length = scan.nextInt();
			double breadth = scan.nextInt();
			tr.area(length,breadth);
	}		
}

class Rectangle implements Shape {
	
	void area(double length, double breadth) {
		double area = length * breadth;
		System.out.println(area);
	}
	public static void main (String St[]) {
			Rectangle re = new Rectangle();
			Scanner scan  = new Scanner(System.in);
			System.out.println("Enter the length and breadth of rectangle");
			double length = scan.nextInt();
			double breadth = scan.nextInt();
			re.area(length,breadth);
	}
}
*/