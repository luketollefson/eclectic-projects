/*	Simple grep
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ex53
{
	public static void main(String[] args)
	{
		Grep gp = new Grep("important_matters.txt","money");
		System.out.println(gp.occurances());
	}
}

class Grep
{
	private String haystack;
	private	String needle;

	public Grep(String hs, String n)
	{
		haystack = hs;
		needle = n;
	}

	public int occurances()
	{
		try
		{
			Scanner file = new Scanner(new File(haystack));
	
			int i;
			int count = 0;
			String line = "";
	
			while (file.hasNextLine())
			{
				line = file.nextLine();
				i = 0;
				while ((i = line.indexOf(needle,i)) != -1)
				{
					count++;
					i++;
				}
			}
	
			file.close();
			return count;
		}
		catch (FileNotFoundException fnfe)
		{
			System.err.println(fnfe.getMessage());
			return 0;
		}
	}
}
