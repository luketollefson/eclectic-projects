/*	output a one line file
	Luke
*/

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class OneCharALine
{
	public static void main(String[] args)
	{
		try
		{
			Scanner scan = new Scanner(new File("source.txt"));

			if (!scan.hasNext())
				System.exit(1);

			String s;
			s = scan.nextLine();

			if (scan.hasNext())
				System.exit(2);

			for (int i = 0; i < s.length(); i++)
				System.out.println(s.charAt(i));
		}
		catch (FileNotFoundException fnfe)
		{	
			System.out.println(fnfe.getMessage());
		}
	}
}
