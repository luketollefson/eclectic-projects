/*	Compound Interst, calcualte the future value
	of money for 5, 10, and 20 years
	Luke
*/

import java.util.Scanner;
import java.text.NumberFormat;

public class CompoundInterest
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the principle > ");
		double principle = scanner.nextDouble();
		System.out.print("Enter the interst rate > ");
		double interestRate = scanner.nextDouble();

		double year5 = principle * Math.pow((1 + interestRate), 5);
		double year10 = principle * Math.pow((1 + interestRate), 10);
		double year20 = principle * Math.pow((1 + interestRate), 20);

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("After 5 years you will have " + currency.format(year5)
					   + ", after 10 years you will have " + currency.format(year10)
					   + ", after 20 years you will have " + currency.format(year20));
	}
}
