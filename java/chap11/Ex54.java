/*	a simple program
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ex54
{
	public static void main(String[] args)
	{
		Diff df = new Diff("file1.txt","file2.txt");
		System.out.println("Files differ by " + df.diffAmount() + " lines");
	}
}

class Diff
{
	private String file1;
	private String file2;

	public Diff(String f1, String f2)
	{
		file1 = f1;
		file2 = f2;
	}

	public int diffAmount()
	{
		try
		{
			Scanner f1 = new Scanner(new File(file1));
			Scanner f2 = new Scanner(new File(file2));

			int diff = 0;
			while (f1.hasNextLine() && f2.hasNextLine())
			{
				if (!f1.nextLine().equals(f2.nextLine()))
					diff++;
			}

			while (f1.hasNextLine())
			{
				f1.nextLine();
				diff++;
			}

			while (f2.hasNextLine())
			{
				f2.nextLine();
				diff++;
			}

			return diff;
		}
		catch (FileNotFoundException fnfe)
		{
			System.err.println(fnfe.getMessage());
			return 0;
		}
	}
}
