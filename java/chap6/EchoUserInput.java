/*	Working with a sentinel value
	Luke
*/

import java.util.Scanner;

public class EchoUserInput
{
	public static void main(String[] args)
	{
		final int SENTINEL = -1;
		int number;

		Scanner scan = new Scanner(System.in);

		// priming read
		System.out.print("Enter an integer, or -1 to stop > ");
		number = scan.nextInt();

		while (number != SENTINEL)
		{
			// processing
			System.out.println(number);

			// update read
			System.out.print("Enter an integer, or -1 to stop > ");
			number = scan.nextInt();
		}

		System.out.println("Sentinal value detected. Goodbye");
	}
}
