/*	Summer Job class
	Luke
*/

import java.text.NumberFormat;
import java.util.Random;

public class SummerJob
{
	// rows represent people, columns represent the year worked
	private double[][] salaries;

	public SummerJob(int people, int years)
	{
		setSalaries(people, years);
	}

	public double totalPayed()
	{
		double total = 0;
		for (int i = 0; i < salaries.length; i++)
			for (int j = 0; j < salaries[i].length; j++)
				total += salaries[i][j];

		return total;
	}

	public int yearOfHighestEarnings()
	{
		int columnIndex = 0;
		double maxEarnings = 0;
		for (int i = 0; i < salaries.length; i++)
		{
			for (int j = 0; j < salaries[i].length; j++)
				if (salaries[i][j] > maxEarnings)
				{
					columnIndex = j;
					maxEarnings = salaries[i][j];
				}
		}

		return columnIndex;
	}

	public int getHighestPayed()
	{
		int index = 0;
		double indexEarnings = 0;
		double earnings;
		for (int i = 0; i < salaries.length; i++)
		{
			earnings = 0;
			for (int j = 0; j < salaries[i].length; j++)
				earnings += salaries[i][j];

			if (earnings > indexEarnings)
			{
				index = i;
				indexEarnings = earnings;
			}
		}

		return index;
	}

	public double[][] getSalaries()
	{
		double[][] temp = new double[salaries.length][];
		for (int i = 0; i < salaries.length; i++)
			temp[i] = new double[salaries[i].length];

		for (int i = 0; i < salaries.length; i++)
			for (int j = 0; i < salaries[i].length; j++)
				temp[i][j] = salaries[i][j];

		return temp;
	}

	public void setSalaries(int people, int years)
	{
		salaries = new double[people][years];
		Random rand = new Random();

		for (int i = 0; i < salaries.length; i++)
		{
			for (int j = 0; j < salaries[i].length; j++)
			{
				salaries[i][j] = rand.nextDouble() * 10000 + 1000; // $0-$10,000
			}
		}
	}

	public String toString()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String s = "";
		for (int i = 0; i < salaries.length; i++)
		{
			s += "\nPerson " + (i+1) + ":\t";
			for (int j = 0; j < salaries[i].length; j++)
				s += currency.format(salaries[i][j]) + '\t';
		}

		return s;
	}
}
