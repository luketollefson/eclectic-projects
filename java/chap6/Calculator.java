/*	Addition Calculator
	Luke
*/

import java.util.Scanner;

public class Calculator
{
	public static void main(String[] args)
	{
		final int SENTINEL = 0;
		int number;
		int total = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the addition calculator.\n");

		System.out.print("Enter the first number"
						 + " or 0 for the total > ");
		number = scan.nextInt();

		while (number != SENTINEL)
		{
			total += number;

			System.out.print("Enter the next number"
							 + " or 0 for the total > ");
			number = scan.nextInt();
		}

		System.out.println("The total is " + total);
	}
}
