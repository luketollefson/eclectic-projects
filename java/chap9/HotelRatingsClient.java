/*	Using the hotel ratings class
	Luke
*/

import java.util.ArrayList;

public class HotelRatingsClient
{
	public static void main(String[] args)
	{
		HotelRatings hr = new HotelRatings(2, 3);

		System.out.println(hr);

		System.out.print("Hotels that have earned five stars: ");
		ArrayList<Integer> fiveStar = hr.fiveStarHotels();
		for (int i : fiveStar)
			System.out.print((i+1) + " ");
		System.out.println();

		System.out.print("Hotels that have always earned five stars: ");
		ArrayList<Integer> bestHotels = hr.bestHotels();
		for (int i : bestHotels)
			System.out.print((i+1) + " ");
		if (bestHotels.size() == 0)
			System.out.print("none");
		System.out.println();


		System.out.println(hr.atLeastOneGoodOne());
	}
}
