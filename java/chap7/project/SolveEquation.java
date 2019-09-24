/*	Solve an equation
	Luke
*/

import java.util.Scanner;

public class SolveEquation
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter quadratic in the form ax^2+bx+c=0");
		System.out.print("Enter a > ");
		double a = scan.nextDouble();
		System.out.print("Enter b > ");
		double b = scan.nextDouble();
		System.out.print("Enter c > ");
		double c = scan.nextDouble();

		Quadratic eq = new Quadratic(a, b, c);

		ComplexPair solution = eq.findRoots();

		if (solution.getComplexA().equals(solution.getComplexB()))
		{
			System.out.println("One real root");
			System.out.println("x = " + solution.getComplexA());
		}
		else if (solution.getComplexA().isReal() && solution.getComplexB().isReal())
		{
			System.out.println("Two real roots");
			System.out.println("x = " + solution);
		}
		else
		{
			System.out.println("Two complex roots");
			System.out.println("x = " + solution);
		}
	}
}
