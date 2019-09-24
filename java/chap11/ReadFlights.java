/*	Reading structured data from a text file
	Luke
*/

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class ReadFlights
{
	public static void main(String[] args)
	{
		ArrayList<FlightRecord> listFlightRecords =
							new ArrayList<FlightRecord>();
		try
		{
			Scanner file = new Scanner(new File("flights.txt"));

			while (file.hasNext())
			{
				String stringRead = file.nextLine();

				Scanner parse = new Scanner(stringRead);
				parse.useDelimiter(",");
				String flightNumber = parse.next();
				String origin = parse.next();
				String destination = parse.next();

				try
				{
					int numPassengers = parse.nextInt();
					double avgTicketPrice = parse.nextDouble();

					FlightRecord frTemp = new FlightRecord(
								 flightNumber, origin, destination,
								 numPassengers, avgTicketPrice);

					listFlightRecords.add(frTemp);
				}
				catch (InputMismatchException ime)
				{
					System.out.println("Error in flight record: "
								+ stringRead + "; record ignored");
				}
			}

			file.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to find flights.txt");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		for (FlightRecord flight : listFlightRecords)
			System.out.println(flight);
	}
}
