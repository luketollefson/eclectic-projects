/*	Demonstration of currency and percentage formatting
	using the NumberFormat class.
	Luke.
*/

import java.text.NumberFormat;

public class DemoNumberFormat
{
	public static void main(String[] args)
	{
		double winningPercentage = .675;
		double price = 78.0;

		// get a NumberFormat object for printing a percentage
		NumberFormat percentFormat = NumberFormat.getPercentInstance();

		System.out.print("The winning percentage is ");
		System.out.println(percentFormat.format(winningPercentage));

		NumberFormat priceFormat = NumberFormat.getCurrencyInstance();

		System.out.println("\nThe price is: " + priceFormat.format(price));
	}
}
