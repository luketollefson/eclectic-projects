/*	Find the smallest of three integers
	Luke
*/

import java.util.Scanner;

public class FindSmallest
{
	public static void main(String[] args)
	{
		int smallest;
		int num1, num2, num3;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the first integer: ");
		num1 = scan.nextInt();
		System.out.print("Enter the second integer: ");
		num2 = scan.nextInt();
		System.out.print("Enter the third integer: ");
		num3 = scan.nextInt();

		if (num1 < num2)
			smallest = num1;
		else
			smallest = num2;

		if (num3 < smallest)
			smallest = num3;

		System.out.println("The smallest is " + smallest);
	}
}
