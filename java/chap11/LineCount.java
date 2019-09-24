/*	counts how many lines are in a file
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LineCount
{
	public static void main(String[] args)
	{
		try
		{
			Scanner file = new Scanner(new File("LineCount.java"));
	
			int lines = 0;
	
			while (file.hasNext())
			{
				file.nextLine();
				lines++;
			}
	
			System.out.println(lines);
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
	}
}
