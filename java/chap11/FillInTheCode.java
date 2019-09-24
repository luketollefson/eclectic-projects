/*	FillInTheCode exercises
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FillInTheCode
{
	public static void main(String[] args)
	{
		/* 24
		String s = "";
		int n = 0;
		try
		{
			Scanner file = new Scanner(new File("data.txt"));
			while (file.hasNext())
			{
				s = file.nextLine();
				try
				{
					n = Integer.parseInt(s);
					System.out.println(n);
				}
				catch (NumberFormatException nfe)
				{ }
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		*/

		/* 25
		Scanner parse = new Scanner("A-B-C-D");
		parse.useDelimiter("-");
		String s = "";
		while (parse.hasNext())
			s += parse.next();

		System.out.println(s.indexOf("C"));
		*/

		/* 26
		try
		{
			Scanner file = new Scanner(new File("data.txt"));
			System.out.println(file.nextLine());
			System.out.println(file.nextLine());
			file.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		*/

		/* 27 28 29
		try
		{
			Scanner file = new Scanner(new File("data.txt"));

			String result = "";
			String temp = "";

			while (file.hasNext())
			{
				temp  = file.next();
				if (temp.indexOf("Sp") != -1)
					result += temp + "\n";
			}

			System.out.println(result);

			file.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		*/

		/* 30
		int[] grades = {98,76,82,90,100,75};
		try
		{
			FileOutputStream fos = new FileOutputStream("data.txt", false);
			PrintWriter pw = new PrintWriter(fos);

			for (int i = 0; i < grades.length; i++)
				pw.println(grades[i]);

			pw.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to find data.txt");
		}
		*/

		/* 32
		int[] grades = {98,76,82,90,100,75};
		double average = 0.0;
		for (int i = 0; i < grades.length; i++)
			average += grades[i];

		average /= grades.length;

		try
		{
			FileOutputStream fos = new FileOutputStream("data.txt",false);
			PrintWriter pw = new PrintWriter(fos);

			pw.println(average);
			pw.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		*/

		/* 32
		int i = 45;
		double d = 6.7;
		try
		{
			FileOutputStream fos = new FileOutputStream("data.txt",false);
			PrintWriter pw = new PrintWriter(fos);

			pw.println(i);
			pw.println(d);

			pw.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		*/

		float f = 13.5f;
		try
		{
			FileOutputStream fos = new FileOutputStream("data.txt", false);
			PrintWriter pw = new PrintWriter(fos);
			
			pw.println(f);
			pw.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
