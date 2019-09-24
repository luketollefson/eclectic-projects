/*	Demonstrating how to read from a text file
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadTextFile
{
	public static void main(String[] args)
	{
		try
		{
			Scanner file = new Scanner(new File("dataFile.txt"));

			while (file.hasNext())
			{
				String stringRead = file.nextLine();
				System.out.println(stringRead);
			}

			file.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to find dataFile.txt, exiting");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
