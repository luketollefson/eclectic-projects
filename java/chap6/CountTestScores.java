/*	Counting passing test scores
	Luke
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class CountTestScores
{
	public static void main(String[] args)
	{
		int countPassed = 0;
		int countScores = 0;
		int score;
		final int SENTINEL = -1;

		Scanner scan = new Scanner(System.in);

		System.out.println("This program counts "
					+ "the number of passing test scores.");
		System.out.println("Enter a -1 to stop.");

		System.out.print("Enter the first score > ");
		score = scan.nextInt();

		while (score != SENTINEL)
		{
			if (score >= 60)
			{
				countPassed++;
			}
			
			countScores++;

			System.out.print("Enter the next score > ");
			score = scan.nextInt();
		}

		System.out.println("You entered " + countScores + " scores");
		System.out.println("The number of passing test scores is "
								+ countPassed);
		if (countScores != 0)
		{
			DecimalFormat percent = new DecimalFormat("#0.0%");
			System.out.println(
				percent.format((double) (countPassed) / countScores)
				+ " of the class passed the test.");
		}
	}
}
