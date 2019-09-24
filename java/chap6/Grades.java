/*	determins some facts about a list of grades
	Luke
*/

import java.util.Scanner;

public class Grades
{
	public static void main(String[] args)
	{
		final int SENTINEL = -1;
		Scanner scan = new Scanner(System.in);

		int grade, minimum, maximum, total = 0, count = 0;

		System.out.print("Enter a grade or -1 to stop: ");
		grade = scan.nextInt();
		
		minimum = maximum = grade;
		while (grade != SENTINEL)
		{
			if (grade >= 0 && grade <= 100)
			{
				minimum = Math.min(minimum, grade);
				maximum = Math.max(maximum, grade);
				total += grade;
				count++;
			}
			else
				System.out.println("Grade not between 0 and 100, not counted");

			System.out.print("Enter a grade or -1 to stop: ");
			grade = scan.nextInt();
		}

		if (count > 0)
		{
			System.out.println("Minimum grade: " + minimum);
			System.out.println("Maximum grade: " + maximum);
			System.out.println("Average grade: " + (double) total / count);
		}
		else
			System.out.println("No grades entered");
	}
}
