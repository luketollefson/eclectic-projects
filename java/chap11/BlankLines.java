/*	Add blank lines to
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BlankLines
{
	public static void main(String[] args)
	{
		try
		{
			Scanner file = new Scanner(new File("BlankLines.java"));

			while (file.hasNext())
				System.out.println(file.nextLine() + "\n");

			file.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
	}
}
