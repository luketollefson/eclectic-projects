/*	SavingsAccount class
	Luke
*/

import java.text.NumberFormat;

public class SavingsAccount extends BankAccount
{
	public final double DEFAULT_RATE = .03;
	private double interestRate;

	public SavingsAccount()
	{
		super();
		interestRate = DEFAULT_RATE;
		System.out.println("SavingsAcount default constructor called");
	}

	public SavingsAccount(double startBalance,
						  double startInterestRate)
	{
		super(startBalance);
		interestRate = startInterestRate;
	}

	public void applyInterest()
	{
		deposit(getBalance() * interestRate);
	}

	public double getInterestRate()
	{
		return interestRate;
	}

	public void setInterestRate(double newInterestRate)
	{
		if (newInterestRate >= 0.0)
			interestRate = newInterestRate;
		else
			System.err.println("Interest rate cannot be negative");
	}

	public String toString()
	{
		NumberFormat percent = NumberFormat.getPercentInstance();
		return super.toString()
				+ "; annual interest rate " + percent.format(interestRate);
	}
}
