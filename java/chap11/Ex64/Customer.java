/*	Customer side of the software
	Luke
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class Customer
{
	public static void main(String[] args)
	{
		// retrive the reservations
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
				cnfe.printStackTrace();
			}
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		if (res.size() == 0)
		{
			System.out.println("No spaces available");
			System.exit(0);
		}

		// Ask user what house and day to reserve
		System.out.println("Open reservations:");
		for (int i = 0; i < res.size(); i++)
		{
			if (res.get(i).getRenter() == null)
				System.out.println((i+1) + ": " + res.get(i));
		}

		// get user selection
		Scanner scan = new Scanner(System.in);
		String input = "";
		int i = -1;
		boolean validInput = false;
		while (!validInput)
		{
			System.out.print("Enter a selection > ");
			try
			{
				i = Integer.valueOf(scan.next());
				validInput = true;
			}
			catch (NumberFormatException nfe)
			{ }
		}

		i--; //index of house

		System.out.print("Enter a name > ");
		String name = scan.next();

		if (res.get(i).getRenter() == null)
		{
			res.get(i).setRenter(name);
			System.out.println("reservation made");
		}
		else
		{
			System.out.println("invalid reservation");
			System.exit(1);
		}

		// write new reservation
		try
		{
			FileOutputStream fis = new FileOutputStream("reserves",false);
			ObjectOutputStream oos = new ObjectOutputStream(fis);

			for (Reservation r : res)
				oos.writeObject(r);

			oos.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
