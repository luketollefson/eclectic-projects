/*	keep track of your change
	Luke
*/

import java.text.NumberFormat;

public class Coins
{
	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies;

	public Coins(int q, int d, int n, int p)
	{
		setQuarters(q);
		setDimes(d);
		setNickels(n);
		setPennies(p);
	}

	public String totalValue()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		double total = getQuartersValue()
					+ getDimesValue()
					+ getNickelsValue()
					+ getPenniesValue();
		
		return currency.format(total);
	}

	public double getQuartersValue()
	{
		return quarters * 0.25;
	}

	public double getDimesValue()
	{
		return dimes * 0.10;
	}

	public double getNickelsValue()
	{
		return nickels * 0.05;
	}

	public double getPenniesValue()
	{
		return pennies * 0.01;
	}

	public int getQuarters()
	{
		return quarters;
	}

	public int getDimes()
	{
		return dimes;
	}

	public int getNickels()
	{
		return nickels;
	}

	public int getPennies()
	{
		return pennies;
	}

	public void setQuarters(int q)
	{
		if (q >= 0)
			quarters = q;	
		else
			System.err.println("Number of Quarters Invalid. Quarters Unchanged");
	}

	public void setDimes(int d)
	{
		if (d >= 0)
			dimes = d;	
		else
			System.err.println("Number of Dimes Invalid. Dimes Unchanged");
	}

	public void setNickels(int n)
	{
		if (n >= 0)
			nickels = n;	
		else
			System.err.println("Number of Nickels Invalid. Nickels Unchanged");
	}

	public void setPennies(int p)
	{
		if (p >= 0)
			pennies = p;	
		else
			System.err.println("Number of Pennies Invalid. Pennies Unchanged");
	}

	public String toString()
	{
		return "Quarters: " + quarters
			+ "; Dimes: " + dimes
			+ "; Nickels: " + nickels
			+ "; Pennies: " + pennies;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof Coins))
			return false;
		else
		{
			Coins obj = (Coins) o;
			if (quarters == obj.quarters
				&& dimes == obj.dimes
				&& nickels == obj.nickels
				&& pennies == obj.pennies)
				return true;
			else
				return false;
		}
	}
}
