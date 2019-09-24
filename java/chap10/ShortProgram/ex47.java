/*	Some boxes
	Luke
*/

public class ex47
{
	public static void main(String[] args)
	{
		Rectangle r1 = new Rectangle(2.0,3.0);
		System.out.println(r1.perimeter());

		Parallelepiped p1 = new Parallelepiped(2.0,3.0,4.0);
		System.out.println(p1.area());
		Parallelepiped p2 = new Parallelepiped(1.0,3.0,4.0);
		System.out.println(p2.equals(p1));
	}
}

class Rectangle
{
	private double width;
	private double height;

	public Rectangle()
	{
		width = 1.0;
		height = 1.0;
	}

	public Rectangle(double w, double h)
	{
		width = w;
		height = h;
	}

	public double perimeter()
	{
		return width * 2 + height * 2;
	}

	public double area()
	{
		return width * height;
	}

	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public String toString()
	{
		return "width: " + width
			+ ";height: " + height;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Rectangle))
			return false;
		else
		{
			Rectangle obj = (Rectangle) o;
			if (width == obj.width && height == obj.height)
				return true;
			else
				return false;
		}
	}
}

class Parallelepiped extends Rectangle
{
	private double length;

	public Parallelepiped()
	{
		super();
		length = 1.0;
	}

	public Parallelepiped(double w, double h, double l)
	{
		super(w, h);
		length = l;
	}

	public double area()
	{
		return 2 * (getWidth()*getHeight())
			+  2 * (getHeight()*length)
			+  2 * (length*getWidth());
	}

	public double volume()
	{
		return length * getWidth() * getHeight();
	}

	public String toString()
	{
		return super.toString()
			+ "; length: " + length;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Parallelepiped))
			return false;
		else
		{
			if (super.equals(o)
				&& length == ((Parallelepiped) o).length)
				return true;
			else
				return false;
		}
	}
}
