/*	Morgage, determines monthy mortgage payment
	Luke
*/

import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Mortgage
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the annual interest rate > ");
		double interestRate = scanner.nextDouble();

		System.out.print("Enter the number of years on the mortgage > ");
		double years = scanner.nextInt();

		System.out.print("Enter the amount borrowed for the mortgage > ");
		double borrowed = scanner.nextDouble();

		double mIR = interestRate / 12;
		double monthlyPayment = (mIR * borrowed) / (1 - (1/Math.pow(1+mIR,12*years)));

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		DecimalFormat percent = new DecimalFormat("#0.0%");

		System.out.println("The annual interest rate is " + percent.format(interestRate));
		System.out.println("The morgage amount is " + currency.format(borrowed));
		System.out.println("The monthly payment is " + currency.format(monthlyPayment));
		System.out.println("The total payment is " + currency.format(monthlyPayment*12*years));
		System.out.println("The overpayment is "
			+ currency.format((monthlyPayment*12*years)-borrowed));
		System.out.println("You overpay by "
			+ percent.format((monthlyPayment*12*years)/borrowed));
	}
}
