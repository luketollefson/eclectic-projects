/*	finds the minimum of 10 values
	Luke
*/

import java.util.Scanner;

public class MinOfTen
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter and integer: ");
		int n = scan.nextInt();

		int min = n;
		for (int i = 0; i < 10; i++)
		{
			System.out.print("Enter and integer: ");
			n = scan.nextInt();

			min = Math.min(min, n);
		}

		System.out.println("The minimum was " + min);
	}
}
