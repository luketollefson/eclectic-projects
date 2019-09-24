/*	Find the total of 5 numbers
	Luke
*/

import java.util.Scanner;

public class Sum5Numbers
{
	public static void main(String[] args)
	{
		int total = 0;
		int number;

		Scanner scan = new Scanner(System.in);

		for (int i = 1; i <= 5; i++)
		{
			System.out.print("enter an integer > ");
			number = scan.nextInt();

			total += number;
		}

		System.out.println("The total is " + total);
	}
}
