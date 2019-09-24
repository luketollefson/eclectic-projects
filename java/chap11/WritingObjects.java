/*	Demonstrating how to write objects to a file
	Luke
*/

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WritingObjects
{
	public static void main(String[] args)
	{
		FlightRecord fr1 = new FlightRecord("AA31","BWI","SFO",
											200, 235.9);
		FlightRecord fr2 = new FlightRecord("CO25","LAX","JFK",
											225,419.9);
		FlightRecord fr3 = new FlightRecord("US57","IAD","DEN",
											175,179.5);

		try
		{
			FileOutputStream fos = new FileOutputStream("objects",false);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(fr1);
			oos.writeObject(fr2);
			oos.writeObject(fr3);

			oos.close();
		}

		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to write to object");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
