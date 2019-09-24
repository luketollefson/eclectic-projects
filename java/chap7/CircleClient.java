/*	test out the circle class
	Luke
*/

import java.awt.Point;

public class CircleClient
{
	public static void main(String[] args)
	{
		Circle circle = new Circle(new Point(5,5), 15);
		System.out.println(circle);
		System.out.println(circle.equals(new Circle(new Point(5,5), 15)));

		circle.setLocation(new Point((int) circle.getLocation().getX()+2, 4));
		circle.setRadius(circle.getRadius()+1);
		System.out.println(circle);

		System.out.println(circle.getPerimeter());
		System.out.println(circle.getArea());
	}
}
