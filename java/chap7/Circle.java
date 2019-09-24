/*	a circle, wow!
	Luke
*/

import java.awt.Point;

public class Circle
{
	private Point location;
	private double radius;

	public Circle()
	{
		location = new Point();
	}

	public Circle(Point location, double radius)
	{
		setLocation(location);
		setRadius(radius);
	}

	public double getPerimeter()
	{
		return 2.0 * Math.PI * radius;
	}

	public double getArea()
	{
		return Math.PI * radius * radius;
	}

	public Point getLocation()
	{
		return location;
	}

	public double getRadius()
	{
		return radius;
	}

	public void setLocation(Point location)
	{
		this.location = location;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	public String toString()
	{
		return "X: " + location.getX()
			+ "; Y: " + location.getY()
			+ "; Radius: " + radius;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Circle))
			return false;
		else
		{
			Circle obj = (Circle) o;
			if (location.equals(obj.location)
				&& radius == obj.radius)
				return true;
			else
				return false;
		}
	}
}
