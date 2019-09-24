/*	Circle Facts, calculate some infomation about circles
	Luke
*/

import java.util.Scanner;

public class CircleFacts
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the radius > ");
		double radius = scanner.nextDouble();

		double area = Math.PI * Math.pow(radius, 2);
		double perimeter = 2 * Math.PI * radius;

		System.out.println("The area of the circle is "
						 + area + " and the perimeter is "
						 + perimeter);
	}
}
