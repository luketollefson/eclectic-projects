/*	allows idomatic year input
	Luke
*/

import java.util.Scanner;

public class Year
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int year;

		System.out.print("Enter the year: ");
		String stringYear = scan.next();

		if (stringYear.length() == 4)
			year = Integer.parseInt(stringYear);
		else if (stringYear.length() == 2)
			year = 2000 + Integer.parseInt(stringYear);
		else
			year = 0;

		if (year == 0)
			System.out.println("Invalid year");
		else
			System.out.println("The year is " + year);
	}
}
