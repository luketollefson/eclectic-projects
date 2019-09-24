/*	increment number.txt
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class VisitorCount
{
	public static void main(String[] args)
	{
		try
		{
			int i = 0;
			Scanner file = new Scanner(new File("number.txt"));

			if (!file.hasNextInt())
			{
				System.out.println("file has improper format, setting to 1");
				i = 0;
			}
			else
				i = file.nextInt();

			i++;

			file.close();

			FileOutputStream fos = new FileOutputStream("number.txt");
			PrintWriter pw = new PrintWriter(fos);

			pw.println(i);

			pw.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
	}
}
