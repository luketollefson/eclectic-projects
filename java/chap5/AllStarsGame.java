/*	tells the user if they can play in the All Stars Game
	Luke
*/

import java.util.Scanner;

public class AllStarsGame
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int hits, atBats;
		double hittingAverage;

		System.out.print("Enter number of hits: ");
		hits = scan.nextInt();
		System.out.print("Enter number of times at bat: ");
		atBats = scan.nextInt();

		hittingAverage = (double) hits / atBats;

		if (hittingAverage > .300)
			System.out.println("You are eligible for the All Stars Game");
		else
			System.out.println("You are ineligible for the All Stars Game");
	}
}
