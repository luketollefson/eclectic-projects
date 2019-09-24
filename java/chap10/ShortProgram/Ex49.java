/*	Exerise 49
	Luke
*/

import java.util.ArrayList;

public class Ex49
{
	public static void main(String[] args)
	{
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(10.0));
		shapes.add(new Rectangle(15.0,3));

		for (Shape s : shapes)
			System.out.println(s.area());
	}
}

abstract class Shape
{
	public final double PI = 3.1415;
	public abstract double perimeter();
	public abstract double area();
}

class Circle extends Shape
{
	private double radius;

	public Circle(double r)
	{
		radius = r;
	}

	public double perimeter()
	{
		return 2.0 * PI * radius;
	}

	public double area()
	{
		return PI * radius * radius;
	}
}

class Rectangle extends Shape
{
	private double width;
	private double height;
	
	public Rectangle(double w, double h)
	{
		width = w;
		height = h;
	}

	public double perimeter()
	{
		return 2.0 * width + 2 * height;
	}

	public double area()
	{
		return width * height;
	}
}
