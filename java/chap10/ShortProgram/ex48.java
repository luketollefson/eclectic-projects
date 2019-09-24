/*	some circles and cylender
	Luke
*/

public class ex48
{
	public static void main(String[] args)
	{
		Cylinder cyl1 = new Cylinder(2.0,3.0);
		Cylinder cyl2 = new Cylinder(2.0,3.0);
		Circle cir1 = new Circle(3.0);
		System.out.println(cyl1.volume());
	}
}

class Circle
{
	private double radius;

	public Circle()
	{
		radius = 1.0;
	}

	public Circle(double r)
	{
		radius = r;
	}

	public double perimeter()
	{
		return 2.0 * Math.PI * radius;
	}

	public double area()
	{
		return Math.PI * radius * radius;
	}

	public String toString()
	{
		return "radius: " + radius;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Circle))
			return false;
		else
		{
			Circle obj = (Circle) o;
			if (radius == obj.radius)
				return true;
			else
				return false;
		}
	}
}

class Cylinder extends Circle
{
	private double length;

	public Cylinder()
	{
		super();
		length = 1.0;
	}

	public Cylinder(double r, double l)
	{
		super(r);
		length = l;
	}

	public double area()
	{
		return super.perimeter() * length + 2 * super.area();
	}

	public double volume()
	{
		return super.area() * length;
	}

	public String toString()
	{
		return super.toString() + "; length: " + length;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Cylinder))
			return false;
		else if (super.equals(o) && length == ((Cylinder) o).length)
			return true;
		else
			return false;
	}
}
