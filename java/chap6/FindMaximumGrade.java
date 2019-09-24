/*	Find the maximum test grade
	Luke
*/

import java.util.Scanner;
import java.io.*;

public class FindMaximumGrade
{
	public static void main(String[] args) throws IOException
	{
		int maxGrade;
		int grade;

		Scanner scan = new Scanner(new File("grades.txt"));

		System.out.println("This program finds te maximum grade "
							+ "for a class");

		if (!scan.hasNext())
		{
			System.out.println("No test grades are in the file");
		}
		else
		{
			maxGrade = scan.nextInt();

			while (scan.hasNext())
			{
				grade = scan.nextInt();

				if (grade > maxGrade)
					maxGrade = grade;
			}

			System.out.println("The maximum grade is " + maxGrade);
		}
	}
}
