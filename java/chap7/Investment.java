/*	investments
	Luke
*/

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Investment
{
	private double value;
	private double interestRate;

	public Investment(double v, double ir)
	{
		setValue(v);
		setInterestRate(ir);
	}

	public double futureValue(int years)
	{
		return value * Math.pow(1.0 + interestRate, years);
	}

	public double getValue()
	{
		return value;
	}

	public double getInterestRate()
	{
		return interestRate;
	}

	public void setValue(double v)
	{
		value = v;
	}

	public void setInterestRate(double ir)
	{
		interestRate = ir;
	}

	public String toString()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		DecimalFormat rate = new DecimalFormat("#0.00%");
		return "Value: " + currency.format(value)
			+ "; Interest Rate: " + rate.format(interestRate);
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Investment))
			return false;
		else
		{
			Investment obj = (Investment) o;
			if (Math.abs(value - obj.value) < 0.001
				&& Math.abs(interestRate - obj.interestRate) < 0.001)
				return true;
			else
				return false;
		}
	}
}
