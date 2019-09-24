/*	Some stats stuff
	Luke
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Ex59
{
	public static void main(String[] args)
	{
		Grades g = new Grades("grades3.txt");
		System.out.println("Highest is: " + g.highest());
		System.out.println("Lowest is: " + g.lowest());
		System.out.println("Average is: " + g.average());

		char[] letters = g.letterGrades();

		for (int i = 0; i < letters.length; i++)
			System.out.print(letters[i] + " ");

		System.out.println();
	}
}

class Grades
{
	private ArrayList<Integer> grades;
	private String fileName;

	public Grades(String file)
	{
		fileName = file;
		grades = new ArrayList<Integer>();
		try
		{
			Scanner f = new Scanner(new File(file));

			int line = 1;
			int grade;
			while (f.hasNext())
			{
				try
				{
					grade = f.nextInt();
					grades.add(grade);
				}
				catch (InputMismatchException ime)
				{
					System.err.println("Bad data on line " + line);
				}
				line++;
			}
		}
		catch (FileNotFoundException fnfe)
		{
			System.err.println(fnfe.getMessage());
		}
	}

	public double average()
	{
		double total = 0.0;
		for (int g : grades)
			total += g;

		if (grades.size() != 0)
			return total / grades.size();
		else
			return 0.0;
	}

	public int highest()
	{
		int max = grades.get(0);
		for (int g : grades)
			max = Math.max(max, g);

		return max;
	}

	public int lowest()
	{
		int min = grades.get(0);
		for (int g : grades)
			min = Math.min(min, g);

		return min;
	}

	public char[] letterGrades()
	{
		char[] letters = new char[grades.size()];

		for (int i = 0; i < grades.size(); i++)
			letters[i] = gradeLetter(grades.get(i));

		return letters;
	}

	private char gradeLetter(int i)
	{
		if (i >= 90)
			return 'A';
		else if (i >= 80)
			return 'B';
		else if (i >= 70)
			return 'C';
		else if (i >= 60)
			return 'D';
		else
			return 'F';
	}
}
