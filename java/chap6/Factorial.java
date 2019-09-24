/*	calcualte the factorial of a number
	Luke
*/

import java.util.Scanner;

public class Factorial
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int x = scan.nextInt();

		int product = 1;
		for (int i = 1; i <= x; i++)
			product *= i;

		System.out.println(product);
	}
}
