/*	Guess a number between 1 and 10
	Luke
*/

import java.util.Random;
import java.util.Scanner;

public class GuessANumber
{
	public static void main(String[] args)
	{
		Random random = new Random();
		int secretNumber = random.nextInt(10) + 1;

		Scanner scan = new Scanner(System.in);

		System.out.print("I'm thinking of a number"
					+ " between 1 and 10. What is your guess? ");
		int guess = scan.nextInt();

		if (guess < 1 || guess > 10)
		{
			System.out.println("Well, if you're not going to try"
								+ " I'm not playing.");
		}
		else
		{
			if (guess == secretNumber)
				System.out.println("Hoorah. You win!");
			else
			{
				System.out.println("The number was " + secretNumber);

				if (Math.abs(guess - secretNumber) > 3)
					System.out.println("You missed it by a mile!");
				else
					System.out.println("You were close.");

				System.out.println("Better luck next time.");
			}
		}
	}
}
