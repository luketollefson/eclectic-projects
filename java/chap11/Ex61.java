/*	some car plates
	Luke
*/

import java.io.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

import java.util.ArrayList;


public class Ex61
{
	public static void main(String[] args)
	{
		// put objects onto file
		CarPlate p1 = new CarPlate("194", "MN", "Blue");		
		CarPlate p2 = new CarPlate("AVE", "CI", "Yellow");		
		CarPlate p3 = new CarPlate("940", "AI", "Green");		
		CarPlate p4 = new CarPlate("A9F", "NZ", "Orange");		
		CarPlate p5 = new CarPlate("MMN", "GB", "Purble");		
		try
		{
			FileOutputStream fos = new FileOutputStream("carplates",false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(p1);	
			oos.writeObject(p2);	
			oos.writeObject(p3);	
			oos.writeObject(p4);	
			oos.writeObject(p5);	

			oos.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File not found carplates");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		// retrive objects
		ArrayList<CarPlate> cps = new ArrayList<CarPlate>();
		try
		{
			FileInputStream fis = new FileInputStream("carplates");
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				while (true)
					cps.add((CarPlate) ois.readObject());
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
			System.out.println("carplates not found");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		for (CarPlate cp : cps)
			System.out.println(cp);
	}
}

class CarPlate implements Serializable
{
	private String plateNumber;
	private String state;
	private String color;

	public CarPlate(String pn, String s, String c)
	{
		plateNumber = pn;
		state = s;
		color = c;
	}

	public String toString()
	{
		return "plate number: " + plateNumber
			+ "; state: " + state
			+ "; color: " + color;
	}
}
