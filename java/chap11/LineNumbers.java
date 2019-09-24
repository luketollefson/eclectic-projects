/*	A program that takes a file and adds line number
	Luke
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class LineNumbers
{
	public static void main(String[] args)
	{
		try
		{
			Scanner source = new Scanner(new File("source.txt"));
			FileOutputStream dest = new FileOutputStream("dest.txt");
			PrintWriter pw = new PrintWriter(dest);

			int line = 1;
			while (source.hasNext())
			{
				pw.printf("%7d %s\n", line, source.nextLine());
				line++;
			}

			source.close();
			pw.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
	}
}
