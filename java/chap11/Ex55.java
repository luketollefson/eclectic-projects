/*	some attributes of a text
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Ex55
{
	public static void main(String[] args)
	{
		TextFile f = new TextFile("file3.txt");
		System.out.println("# of lines: " + f.numberOfLinesInFile());
		System.out.println("longest ln: " + f.longestLineInFile());
		System.out.println("shortst ln: " + f.shortestLineInFile());
		System.out.println("avg ln len: " + f.averageNumberOfCharactersPerLine());
	}
}

class TextFile
{
	private String file;

	public TextFile(String f)
	{
		file = f;
	}

	private Scanner getFileScanner()
	{
		try
		{
			Scanner scanFile = new Scanner(new File(file));	
			return scanFile;
		}
		catch (FileNotFoundException fnfe)
		{
			System.err.println(fnfe.getMessage());
			return null;
		}
	}

	public int numberOfLinesInFile()
	{
		Scanner f = getFileScanner();
		if (f == null)
			return 0;

		int count = 0;
		while (f.hasNextLine())
		{
			f.nextLine();
			count++;
		}

		return count;
	}

	public int longestLineInFile()
	{
		Scanner f = getFileScanner();
		if (f == null)
			return 0;

		int currentLine = 1;
		int currentLength = 0;
		int longest = 0;
		int line = 1;
		while (f.hasNextLine())
		{
			if ((currentLength = f.nextLine().length()) > longest)
			{
				longest = currentLength;
				line = currentLine;
			}
			currentLine++;
		}

		return line;
	}

	public int shortestLineInFile()
	{
		Scanner f = getFileScanner();
		if (f == null)
			return 0;

		int currentLine = 1;
		int currentLength = 0;
		int shortest = Integer.MAX_VALUE;
		int line = 1;
		while (f.hasNextLine())
		{
			if ((currentLength = f.nextLine().length()) < shortest)
			{
				shortest = currentLength;
				line = currentLine;
			}
			currentLine++;
		}

		return line;
	}

	public double averageNumberOfCharactersPerLine()
	{
		Scanner f = getFileScanner();
		if (f == null)
			return 0.0;

		int lines = 0;
		double average = 0.0;

		while (f.hasNextLine())
		{
			average += f.nextLine().length();
			lines++;
		}

		if (lines > 0)
			return average / lines;
		else
			return 0;
	}
}
