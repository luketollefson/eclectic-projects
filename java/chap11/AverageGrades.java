/*	Find the average in grades.txt
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AverageGrades
{
	public static void main(String[] args)
	{
		try
		{
			Scanner file = new Scanner(new File("grades2.txt"));	

			String next = "";
			int line = 0;
			int count = 0;
			int total = 0;

			while (file.hasNext())
			{
				line++;
				next = file.next();
				try
				{
					total += Integer.parseInt(next);
					count++;
				}
				catch (NumberFormatException nfe)
				{
					System.out.println("Bad input on line " + line);
				}
			}

			if (count != 0)
				System.out.println((double) total / count);
			else
				System.out.println("No grades");
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
	}
}
