/*	Sales tax rate
	Luke
*/

import java.util.ArrayList;
import java.util.Random;
import java.text.DecimalFormat;

public class SalesTax
{
	private double[][] salesTax;

	public SalesTax()
	{
		Random rand = new Random();

		salesTax = new double[50][10];
		for (int i = 0; i < salesTax.length; i++)
			for (int j = 0; j < salesTax[i].length; j++)
				salesTax[i][j] = rand.nextDouble() * 0.06;
	}

	public double highestTax(int stateIndex)
	{
		double highest = salesTax[stateIndex][0];
		for (int j = 0; j < salesTax[stateIndex].length; j++)
			highest = Math.max(highest, salesTax[stateIndex][j]);

		return highest;
	}

	public ArrayList<Integer> lowTaxStates()
	{
		ArrayList<Integer> lowTaxes = new ArrayList<Integer>();

		for (int i = 0; i < salesTax.length; i++)
		{
			if (min(salesTax[i]) < 0.001)
				lowTaxes.add(i);
		}

		return lowTaxes;
	}

	private double min(double[] a)
	{
		double minimum = a[0];
		for (int i = 0; i < a.length; i++)
			minimum = Math.min(minimum, a[i]);
		
		return minimum;
	}

	public int highestAvgTax()
	{
		int index = 0;
		double avgTax = 0;
		for (int i = 0; i < salesTax.length; i++)
		{
			if (average(salesTax[i]) > avgTax)
			{
				index = i;
				avgTax = average(salesTax[i]);
			}
		}

		return index;
	}

	private double average(double[] a)
	{
		double total = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++)
		{
			total += a[i];
			count++;
		}

		return total / count;
	}

	public String toString()
	{
		DecimalFormat tax = new DecimalFormat("0.00%");
		String s = "";
		for (int i = 0; i < salesTax.length; i++)
		{
			s += "\nState " + (i+1) + ":\t";
			for (int j = 0; j < salesTax[i].length; j++)
			{
				s += tax.format(salesTax[i][j]) + "\t";
			}
		}
				
		return s;
	}
}
