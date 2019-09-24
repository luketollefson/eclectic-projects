/*	Class representing a baseball team
	Luke
*/

public class BaseballTeam
{
	private int numberOfPlayers;
	private int[] hits;
	private int[] atBats;

	public BaseballTeam()
	{
		numberOfPlayers = 0;
		hits = new int[0];
		atBats = new int[0];
	}

	public BaseballTeam(int players, int[] h, int[] ab)
	{
		if (players == h.length && h.length == ab.length)
		{
			numberOfPlayers = players;

			hits = new int[h.length];
			for (int i = 0; i < h.length; i++)
				hits[i] = h[i];

			atBats = new int[ab.length];
			for (int i = 0; i < ab.length; i++)
				atBats[i] = ab[i];
		}
		else
			System.err.println("Players, hit, and at bats different length");
	}

	public double[] battingAverages()
	{
		double[] averages = new double[hits.length];

		for (int i = 0; i < hits.length; i++)
			averages[i] = (double) hits[i] / atBats[i];

		return averages;
	}

	public int[] sortedHits()
	{
		int[] a = new int[hits.length];

		for (int i =0; i < hits.length; i++)
			a[i] = hits[i];

		int temp;
		int index;
		for (int i = 0; i < a.length; i++)
		{
			index = getLargestElementIndex(a, 0, a.length - i);

			temp = a[index];
			a[index] = a[a.length - i - 1];
			a[a.length - i - 1] = temp;
		}		

		return a;
	}

	private int getLargestElementIndex(int[] a, int istart, int ilast)
	{
		int index = 0;
		for (int i = 0; i < ilast; i++)
			if (a[i] > a[index])
				index = i;

		return index;
	}

	public int playersOver300()
	{
		int total = 0;
		for (int i = 0; i < hits.length; i++)
			if ((double) hits[i] / atBats[i] > .300)
				total++;

		return total;
	}

	public int totalHits()
	{
		int total = 0;
		for (int i = 0; i < hits.length; i++)
			total += hits[i];

		return total;
	}

	public int getNumberOfPlayers()
	{
		return numberOfPlayers;
	}

	public int[] getHits()
	{
		int[] temp = new int[hits.length];
		for (int i = 0; i < hits.length; i++)
			temp[i] = hits[i];

		return temp;
	}

	public int[] getAtBats()
	{
		int[] temp = new int[atBats.length];
		for (int i = 0; i < atBats.length; i++)
			temp[i] = atBats[i];

		return temp;
	}		

	public void setHits(int[] h)
	{
		if (numberOfPlayers == h.length)
		{
			int[] temp = new int[h.length];
			for (int i = 0; i < h.length; i++)
				temp[i] = h[i];
	
			hits = temp;
			temp = null;
		}
		else
			System.err.println("Array has incorrect team size");
	}

	public String toString()
	{
		String r = "";
		r += "The baseball team\n";
		for (int i = 0; i <= numberOfPlayers; i++)
			r += i + "\t";

		r += "\n";

		for (int i = 0; i < hits.length; i++)
			r += hits[i] + "\t";

		r += "\n";

		for (int i = 0; i < atBats.length; i++)
			r += atBats[i] + "\t";

		return r;
	}

	public boolean equals(Object o)
	{
		if (!(o instanceof BaseballTeam))
			return false;
		else
		{
			BaseballTeam obj = (BaseballTeam) o;
			if (!(numberOfPlayers == obj.numberOfPlayers
				&& hits.length == obj.hits.length
				&& atBats.length == obj.atBats.length))
				return false;

			for (int i = 0; i < hits.length; i++)
				if (hits[i] != obj.hits[i])
					return false;

			for (int i = 0; i < atBats.length; i++)
				if (atBats[i] != obj.atBats[i])
					return false;

			return false;
		}
	}
}
