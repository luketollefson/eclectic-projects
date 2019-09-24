/*	Demonstrating how to read objects from a file
	Luke
*/

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;

public class ReadingObjects
{
	public static void main(String[] args)
	{
		try
		{
			FileInputStream fis = new FileInputStream("objects");
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				while (true)
				{
					FlightRecord temp = (FlightRecord) ois.readObject();

					System.out.println(temp);
				}
			}
			catch (EOFException eofe)
			{
				System.out.println("Endo of the file reached");
			}
			catch (ClassNotFoundException cnfe)
			{
				System.out.println(cnfe.getMessage());
			}
			finally
			{
				System.out.println("Closing file");
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
	}
}
