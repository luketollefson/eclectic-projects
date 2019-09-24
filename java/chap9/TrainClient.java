/*	CHOO-CHOO!
	Luke
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

public class TrainClient
{
	public static void main(String[] args)
	{
		try {
			Train train = new Train();
			System.out.println(train);
			System.out.println(train.percentFirstRank());
			System.out.println(train.totalRevenue(1000,500));
			System.out.println(train.onTrain("Al"));
		} catch (IOException e) {
			System.err.println("lol");
		}
	}
}

class Train
{
	private ArrayList<Passenger> passengers;

	public Train()  throws IOException
	{
		File manifestFile = new File("passengers.txt");
		Scanner scan = new Scanner(manifestFile);

		passengers = new ArrayList<Passenger>();
		String name;
		int rank;
		while (scan.hasNext())
		{
			name = scan.next();
			rank = scan.nextInt();
			passengers.add(new Passenger(name, rank));
		}
	}

	public boolean onTrain(String name)
	{
		for (Passenger p : passengers)
			if (p.getName().equals(name))
				return true;

		return false;
	}

	public double totalRevenue(double firstRank, double secondRank)
	{
		double totalRevenue = 0;
		for (Passenger p : passengers)
			if (p.getRank() == 1)
				totalRevenue += firstRank;
			else
				totalRevenue += secondRank;

		return totalRevenue;
	}

	public String percentFirstRank()
	{
		int firstRank = 0;
		for (Passenger p : passengers)
			if (p.getRank() == 1)
				firstRank++;

		NumberFormat percent = NumberFormat.getPercentInstance();
		return percent.format((double) firstRank / passengers.size());
	}

	public String toString()
	{
		String s = "";
			for (Passenger p : passengers)
				s += p.getName() + "\t" + p.getRank() + "\n";

		return s;
	}
}

class Passenger
{
	private String name;
	private int rank; // 1 or 2

	public Passenger(String name, int rank)
	{
		this.name = name;
		this.rank = rank;
	}

	public String getName()
	{
		return name;
	}

	public int getRank()
	{
		return rank;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}
}
