/*	compute the number of times sqrt has to be applied
	Luke
*/

import java.util.Scanner;

public class ManySqrt
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		double value;

		do
		{
			System.out.print("Enter a number greater than 10 > ");
			value = scan.nextDouble();
		} while (value <= 10.0);

		int applicationsOfSqrt = 0;

		while (value > 1.01)
		{
			value = Math.sqrt(value);
			applicationsOfSqrt++;
		}

		System.out.println("Sqrt was applied " + applicationsOfSqrt + " times");
	}
}
