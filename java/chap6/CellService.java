/*	Calculate the price for cell phone service
	Luke
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class CellService
{
	public static void main(String[] args)
	{
		String menu = "\nAvailable Options";
		menu += "\n\tA 1,000 anytime minutes: $25.49";
		menu += "\n\tU Unlimited weekend minutes: $6.99";
		menu += "\n\tN Nationwide long distance: $12.99";
		menu += "\n\tT Text messaging: $5.99";

		String optionS;
		char option;
		double cost = 10.99; // base cost

		DecimalFormat money = new DecimalFormat("$###.00");
		Scanner scan = new Scanner(System.in);

		System.out.println("Select the options "
						   + "for your cell phone service: ");
		System.out.println("Base cost: " + money.format(cost));

		System.out.println(menu); // print the menu
		System.out.print("Enter an option, or \"S\" to stop > ");
		option = scan.next().charAt(0);

		while (option != 'S' && option != 's')
		{
			switch (option)
			{
				case 'a':
				case 'A':
					System.out.println("1,000 anytime minutes: $25.49");
					cost += 25.49;
					break;
				case 'u':
				case 'U':
					System.out.println("Unlimited weekend minutes: $6.99");
					cost += 6.99;
					break;
				case 'n':
				case 'N':
					System.out.println("Nationwide long distance: $12.99");
					cost += 12.99;
					break;
				case 't':
				case 'T':
					System.out.println("Text messaging: $5.99");
					cost += 5.99;
					break;
				default:
					System.out.println("Unrecognized option");
			}

			System.out.println("Current cost: " + money.format(cost));

			System.out.println(menu);
			System.out.print("enter an option, or \"S\" to stop > ");

			option = scan.next().charAt(0);
		}

		System.out.println("\nTotal cost of cell service is "
							+ money.format(cost));
	}
}
