/*	The FlightRecord class
	Luke
*/

import java.io.Serializable;
import java.text.DecimalFormat;

public class FlightRecord implements Serializable
{
	public static final DecimalFormat MONEY
							= new DecimalFormat("$###.00");
	private String flightNumber;
	private String origin;
	private String destination;
	private int numPassengers;
	private double avgTicketPrice;

	public FlightRecord(String startFlightNumber,
						String startOrigin,
						String startDestination,
						int startNumPassengers,
						double startAvgTicketPrice)
	{
		flightNumber = startFlightNumber;
		origin = startOrigin;
		destination = startDestination;
		numPassengers = startNumPassengers;
		avgTicketPrice = startAvgTicketPrice;
	}

	public String toString()
	{
		return "Flight " + flightNumber
			+ ": from " + origin
			+ " to " + destination
			+ "\n\t" + numPassengers + " passengers"
			+ "; average ticket price: "
			+ MONEY.format(avgTicketPrice);
	}
}
