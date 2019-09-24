/*	Determines the likely season
	Luke
*/

import java.util.Scanner;

public class Season
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the tempeture in F: ");
		int temp = scan.nextInt();

		if (temp > 110)
			System.out.println("Where on earth does it get that hot?");
		else if (temp >= 90)
			System.out.println("Summer time baby!");
		else if (temp >= 70)
			System.out.println("Spring you see");
		else if (temp >= 50)
			System.out.println("Nice autum tempeture");
		else if (temp >= -5)
			System.out.println("Burr, winter cold");
		else
			System.out.println("It should never be that cold!");
	}
}
