/*	Circle
	Luke
*/

public class Circle
{
	public static void main(String[] args)
	{
		final double PI = 3.14159;

		double radius = 3.2; // in inches

		double perimeter = PI * radius;

		double area = PI * radius * radius;

		System.out.println("A circle with a radius of " + radius
						   + "in has a permiter of " + perimeter
						   + "in and has an area of " + area
						   + "sqin.");
	}
}
