/*	Class for hotel ratings over time
	Luke
*/

import java.util.ArrayList;
import java.util.Random;

public class HotelRatings
{
	private int[][] hotelRatings;

	public HotelRatings(int hotels, int years)
	{
		Random rand = new Random();

		hotelRatings = new int[hotels][years];

		for (int i = 0; i < hotelRatings.length; i++)
		{
			for (int j = 0; j < hotelRatings[i].length; j++)
				hotelRatings[i][j] = rand.nextInt(5) + 1;
		}
	}

	public boolean atLeastOneGoodOne()
	{
		ArrayList<Integer> al = fiveStarHotels();
		if (al.size() > 0)
			return true;
		else
			return false;
	}

	public ArrayList<Integer> bestHotels()
	{
		ArrayList<Integer> hotels = new ArrayList<Integer>();
		for (int i = 0; i < hotelRatings.length; i++)
			if (alwaysFiveStar(hotelRatings[i]))
				hotels.add(i);

		return hotels;
	}

	private boolean alwaysFiveStar(int[] a)
	{
		for (int j = 0; j < a.length; j++)
			if (a[j] != 5)
				return false;

		return true;
	}

	public ArrayList<Integer> fiveStarHotels()
	{
		ArrayList<Integer> hotels = new ArrayList<Integer>();
		for (int i = 0; i < hotelRatings.length; i++)
		{
			if (hasFiveStar(hotelRatings[i]))
				hotels.add(i);
		}

		return hotels;
	}

	private boolean hasFiveStar(int[] a)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i] == 5)
				return true;

		return false;
	}

	public String toString()
	{
		String s = "";
		for (int i = 0; i < hotelRatings.length; i++)
		{
			s += "\nHotel " + (i+1 > 9 ? i+1 : " " + (i+1)) + ": ";
			for (int j = 0; j < hotelRatings[i].length; j++)
				s += hotelRatings[i][j] + " ";
		}

		return s;
	}
}
