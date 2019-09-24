/*	Temps of the week
	Luke
*/

public class DailyTemps
{
	private int[] dailyTemps;

	public DailyTemps(int[] temps)
	{
		if (temps.length == 7)
		{
			dailyTemps = new int[temps.length];
			for (int i = 0; i < temps.length; i++)
				dailyTemps[i] = temps[i];
		}
		else
			System.err.println("DailyTemps requires 7 days");
	}

	public int[] sortDailyTemps()
	{
		int[] array = new int[dailyTemps.length];
		for (int i = 0; i < array.length; i++)
			array[i] = dailyTemps[i];

		int temp, j;
		for (int i = 1; i < array.length; i++)
		{
			temp = array[i];
			j = i;
			while (j > 0 && array[j-1] < temp)
			{
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
		}

		return array;
	}

	public int largestChange()
	{
		int range = 0;
		for (int i = 0; i < dailyTemps.length - 1; i++)
			range = Math.max(range, Math.abs(dailyTemps[i+1] - dailyTemps[i]));

		return range;
	}

	public int hotDays()
	{
		int total = 0;
		for (int i = 0; i < dailyTemps.length; i++)
			if (dailyTemps[i] > 100)
				total++;

		return total;
	}

	public int freezingDays()
	{
		int total = 0;
		for (int i = 0; i < dailyTemps.length; i++)
			if (dailyTemps[i] <= 32)
				total++;

		return total;
	}

	public int[] getDailyTemps()
	{
		int[] temp = new int[dailyTemps.length];
		for (int i = 0; i < dailyTemps.length; i++)
			temp[i] = dailyTemps[i];

		return temp;
	}

	public void setDailyTemps(int[] temps)
	{
		if (temps.length != 7)
		{
			System.err.println("Must be seven tempeture");
			return;
		}
		dailyTemps = new int[temps.length];

		for (int i = 0; i < temps.length; i++)
			dailyTemps[i] = temps[i];
	}

	public String toString()
	{
		String s = "";
		for (int i = 0; i < dailyTemps.length; i++)
			s += dailyTemps[i] + " ";

		s += "\n";

		return s;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof DailyTemps))
			return false;
		else
		{
			DailyTemps obj = (DailyTemps) o;
			if (dailyTemps.length != obj.dailyTemps.length)
				return false;

			for (int i = 0; i < dailyTemps.length; i++)
				if (dailyTemps[i] != obj.dailyTemps[i])
					return false;

			return true;
		}
	}
}
