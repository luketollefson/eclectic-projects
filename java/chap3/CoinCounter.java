/*	Coin Counter, caluclate the total value of coins
	Luke
*/

import java.util.Scanner;
import java.text.NumberFormat;

public class CoinCounter
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Quarters > ");
		int quarters = scanner.nextInt();
		System.out.print("Dimes > ");
		int dimes = scanner.nextInt();
		System.out.print("Nickles > ");
		int nickels = scanner.nextInt();

		double totalValue = .25 * quarters + .10 * dimes + .05 * nickels;

		NumberFormat currency = NumberFormat.getCurrencyInstance();

		System.out.println("The total value is " + currency.format(totalValue));
	}
}
