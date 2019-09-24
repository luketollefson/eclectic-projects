/*	some homly things
	Luke
*/

import java.io.Serializable;
import java.util.ArrayList;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;

public class Ex60
{
	public static void main(String[] args)
	{
		// Writing houses
		House h1 = new House(1, 100, false);
		House h2 = new House(2, 200, false);
		House h3 = new House(3, 300, true);
		House h4 = new House(4, 500, false);
		House h5 = new House(5, 6000, true);

		try
		{
			FileOutputStream fos = new FileOutputStream("houses",false);

			ObjectOutputStream oos  = new ObjectOutputStream(fos);

			oos.writeObject(h1);
			oos.writeObject(h2);
			oos.writeObject(h3);
			oos.writeObject(h4);
			oos.writeObject(h5);

			oos.close();
		}
		catch (FileNotFoundException fnfe)
		{	
			System.out.println("Unable to write to houses");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		// reading objects
		ArrayList<House> houses = new ArrayList<House>();
		try
		{
			FileInputStream fis = new FileInputStream("houses");
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				while (true)
					houses.add((House) ois.readObject());
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
			System.out.println("Unable to find houses");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		for (House h : houses)
			System.out.println(h);

	}
}


class House implements Serializable
{
	private int rooms;
	private int sqfootage;
	private boolean basement;

	public House(int r, int s, boolean b)
	{
		rooms = r;
		sqfootage = s;
		basement = b;
	}

	public String toString()
	{
		return "rooms: " + rooms
			+ "; sqft: " + sqfootage
			+ "; basement: " + (basement ? "yes" : "no");
	}
}
