/*	Factors of integers
	with checks for primes
	Luke
*/

import java.util.Scanner;

public class Factors
{
	public static void main(String[] args)
	{
		int number;
		final int SENTINEL = 0;
		boolean factorsFound;

		Scanner scan = new Scanner(System.in);

		do {
			System.out.print("Enter a postive integer or 0 to exit > ");
			number = scan.nextInt();
		} while (number < 0);

		while (number != SENTINEL) {
			System.out.print("Factors of " + number + ": ");
			factorsFound = false;

			for (int factor = 2; factor <= number / 2; factor++) {
				if (number % factor == 0) {
					System.out.print(factor + " ");
					factorsFound = true;
				}
			}

			if (!factorsFound)
				System.out.print("none, " + number + " is prime");

			System.out.println('\n');

			do {
				System.out.print("Enter a positive integer or 0 to exit > ");
				number = scan.nextInt();
			} while (number < 0);
		}
	}
}
