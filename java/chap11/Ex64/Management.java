/*	Management side of "football city"
	Luke
*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class Management
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome what would you like to do?");
		System.out.println("1: Update reservation prices (read from prices.txt)");
		System.out.println("2: Get status of reservations (written to reservation_statuses.txt)");
		System.out.println("3: Create reservations (erases any current reservations)");

		String input;
		do
		{
			System.out.print("Enter a number > ");
			input = scan.next();
		} while (!(input.equals("1") || input.equals("2") || input.equals("3")));

		if (input.equals("1"))
			updateReservationPrices();
		else if (input.equals("2"))
			writeReservationStatuses();
		else if (input.equals("3"))
			resetReservations();
	}

	public static void writeReservationStatuses()
	{
		// get current resrvations
		ArrayList<Reservation> res = new ArrayList<Reservation>();
		try
		{
			FileInputStream fis = new FileInputStream("reserves");
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				while (true)
					res.add((Reservation) ois.readObject());
			}
			catch (EOFException eofe)
			{ }
			catch (ClassNotFoundException cnfe)
			{
				System.out.println(cnfe.getMessage());
			}
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("reserves not found");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		// write to a file
		try
		{
			FileOutputStream fos = new FileOutputStream("reservation_statuses.txt");
			PrintWriter pw = new PrintWriter(fos);

			for (Reservation r : res)
				pw.println(r);

			pw.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
	}

	public static void updateReservationPrices()
	{
		// read prices
		ArrayList<Reservation> updates = new ArrayList<Reservation>();
		try
		{
			Scanner file = new Scanner(new File("prices.txt"));
			Scanner scanLine;
			Pattern del = Pattern.compile("[\\s=]");


			while (file.hasNextLine())
			{
				String line = file.nextLine();
				scanLine = new Scanner(line);
				scanLine.useDelimiter(del);

				try
				{
					updates.add(new Reservation(scanLine.nextInt(), 
												 stringToDay(scanLine.next()),
												 null,
												 scanLine.nextDouble()));
				}
				catch (Exception e)
				{
					System.out.println("Incorrect formating in price.txt");
				}
			}

			file.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}

		// read existing reservations
		ArrayList<Reservation> currentReservations = new ArrayList<Reservation>();
		try
		{
			FileInputStream fis = new FileInputStream("reserves");
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				while (true)
					currentReservations.add((Reservation) ois.readObject());
			}
			catch (EOFException eofe)
			{ }
			catch (ClassNotFoundException cnfe)
			{
				System.out.println(cnfe.getMessage());
			}
			finally
			{
				ois.close();
			}
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to find objects");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		// update reservations with the new prices
		for (Reservation u : updates)
		{
			for (Reservation r : currentReservations)
			{
				if (u.getHouseNumber() == r.getHouseNumber()
					&& u.getReserveDay() == r.getReserveDay()
					&& r.getRenter() == null)
					r.setRentPrice(u.getRentPrice());
			}
		}

		// write the new reservations
		try
		{
			FileOutputStream fos = new FileOutputStream("reserves");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (Reservation r : currentReservations)
				oos.writeObject(r);

			oos.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to write to reserves");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	private static Reservation.Day stringToDay(String s) throws IllegalArgumentException
	{
		return Reservation.Day.valueOf(s);
	}


	public static void resetReservations()
	{
		Reservation r1 = new Reservation(1, Reservation.Day.Friday, null, 10.00);
		Reservation r2 = new Reservation(1, Reservation.Day.Saturday, null, 10.00);
		Reservation r3 = new Reservation(1, Reservation.Day.Sunday, null, 10.00);
		Reservation r4 = new Reservation(2, Reservation.Day.Friday, null, 10.00);
		Reservation r5 = new Reservation(2, Reservation.Day.Saturday, null, 10.00);
		Reservation r6 = new Reservation(2, Reservation.Day.Sunday, null, 10.00);

		try
		{
			FileOutputStream fos = new FileOutputStream("reserves");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(r1);
			oos.writeObject(r2);
			oos.writeObject(r3);
			oos.writeObject(r4);
			oos.writeObject(r5);
			oos.writeObject(r6);

			oos.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to write to reserves");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		updateReservationPrices();
	}
}
