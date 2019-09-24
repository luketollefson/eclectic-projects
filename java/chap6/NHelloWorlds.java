/*	print "Hello World" based on user input
	Luke
*/

import java.util.Scanner;

public class NHelloWorlds
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		while (!scan.hasNextInt())
		{
			scan.nextLine();
			System.out.print("Enter an integer: ");
		}
		int n = scan.nextInt();

		for (int i = 0; i < n; i++)
			System.out.println("Hello World");
	}
}
