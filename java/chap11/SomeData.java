/*	a test file
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class SomeData
{
	public static void main(String[] args)
	{
		try
		{
			Scanner file = new Scanner(new File("data.txt"));

			String result = "";

			while (file.hasNext())
			{
				String s = file.nextLine();
				result += s;
			}

			System.out.println("result is " + result);
			file.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
