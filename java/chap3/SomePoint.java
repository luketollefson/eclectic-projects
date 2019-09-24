/*	Some Point, doing some stuff with points
	Luke
*/

import java.util.Scanner;
import java.awt.Point;

public class SomePoint
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the x coordinate of p1 > ");
		int x1 = scanner.nextInt();
		System.out.print("Enter the y coordinate of p1 > ");
		int y1 = scanner.nextInt();

		System.out.print("Enter the x coordinate of p2 > ");
		int x2 = scanner.nextInt();
		System.out.print("Enter the y coordinate of p2 > ");
		int y2 = scanner.nextInt();

		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);

		System.out.println("p1 is " + p1.toString() + ", p2 is " + p2.toString());
	}
}
