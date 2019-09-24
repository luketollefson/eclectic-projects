/*	Type-Safe Input Using Scanner
	Luke
*/

import java.util.Scanner;

public class TypeSafeReadInteger
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String garbage;

		System.out.print("Enter your age as an integer > ");
		while (!scan.hasNextInt())
		{
			garbage = scan.nextLine();
			System.out.print("\nPlease enter and integer > ");
		}
		int age = scan.nextInt();
		System.out.println("Your age is " + age);
	}
}
