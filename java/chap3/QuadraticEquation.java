/*	Quadratic Equation, use the quadratic equation to
	find real roots of a quadratic
	Luke
*/

import java.util.Scanner;

public class QuadraticEquation
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a quadratic equation in the form ax^2+bx+c");
		System.out.print("Value of a > ");
		double a = scanner.nextDouble();
		System.out.print("Value of b > ");
		double b = scanner.nextDouble();
		System.out.print("Value of c > ");
		double c = scanner.nextDouble();

		// find the solutions
		double x1 = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
		double x2 = (-b-Math.sqrt(b*b-4*a*c))/(2*a);

		System.out.println("Solution 1 is " + x1 + " and solution 2 is " + x2);
	}
}
