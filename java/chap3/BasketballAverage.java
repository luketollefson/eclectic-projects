/*	BasketballAverage, calcuate the shoting average of a basketball player
	Luke
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class BasketballAverage
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of shots taken > ");
		int shotsTaken = scanner.nextInt();
		System.out.print("Enter the number of shots made > ");
		int shotsMade = scanner.nextInt();

		double shootingAverage = (double) shotsMade / shotsTaken;

		DecimalFormat percent = new DecimalFormat("#0.0%");

		System.out.println("The shooting average is " + percent.format(shootingAverage));
	}
}
