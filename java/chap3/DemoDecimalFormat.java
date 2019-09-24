/*	Demonstrating the DecimalFormat class
	Luke
*/

// import the DecimalFormat class from the java.text package;
import java.text.DecimalFormat;

public class DemoDecimalFormat
{
	public static void main(String[] args)
	{
		// first, instantiate a DecimalFormat object specifying a
		// pattern for currency
		DecimalFormat pricePattern = new DecimalFormat("$#0.00");

		double price1 = 78.6666666;
		double price2 = 34.5;
		double price3 = .3333333;
		int price4 = 3;
		double price5 = 100.23;

		// then print the values using the pattern
		System.out.println("The first price is: " + pricePattern.format(price1));
		System.out.println("The first price is: " + pricePattern.format(price2));
		System.out.println("The first price is: " + pricePattern.format(price3));
		System.out.println("The first price is: " + pricePattern.format(price4));
		System.out.println("The first price is: " + pricePattern.format(price5));

		// instantiate another new DecimalFormat object
		// for printing percentages
		DecimalFormat percentPattern = new DecimalFormat("#0.0%");

		double average = .980;
		System.out.println("\nThe average is: " + percentPattern.format(average));
		// notice that the average is multiplied by 100
		// to print a percentage.


		// now instantiate another new DecimalFormat object
		// for printing time as two digits
		DecimalFormat timePattern = new DecimalFormat("00");

		int hours = 5, minutes = 12, seconds = 0;
		System.out.println("\nThe time is "
						+ timePattern.format(hours) + ":"
						+ timePattern.format(minutes) + ":"
						+ timePattern.format(seconds));

		// now instantiate another DecimalFormat object
		// for printing numbers in the millions.
		DecimalFormat bigNumber = new DecimalFormat("#,###");

		int millions = 1234567;
		System.out.println("\nmillions is " + bigNumber.format(millions));
	}
}
