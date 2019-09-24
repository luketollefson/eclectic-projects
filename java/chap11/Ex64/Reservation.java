/*	Class representing a house
	Luke
*/

import java.text.NumberFormat;
import java.io.Serializable;

public class Reservation implements Serializable
{
	public static enum Day {Friday, Saturday, Sunday};
	private int houseNumber;
	private Day reserveDay;
	private double rentPrice;
	private String renter; // null for not rented

	/**	Reservation constructor
	*	@param n The house number (either 1 or 2)
	*	@param r The day the house is reserved
	*	@param name The name of person renting, null if unrented
	*	@param price The price of renting/the price being rented at
	*/
	public Reservation(int n, Day r, String name, double price)
	{
		houseNumber = n;
		reserveDay = r;
		renter = name;
		rentPrice = price;
	}

	public int getHouseNumber()
	{
		return houseNumber;
	}

	public Day getReserveDay()
	{
		return reserveDay;
	}

	public String getRenter()
	{
		return renter;
	}

	public double getRentPrice()
	{
		return rentPrice;
	}

	public void setRenter(String r)
	{
		renter = r;
	}

	public void setRentPrice(double p)
	{
		rentPrice = p;
	}

	public String toString()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return "House #" + houseNumber + ": "
			+ (renter == null ? "is avaliable on " : "is rented by " + renter + " on ")
			+ reserveDay + " for " + currency.format(rentPrice);
	}
}
