/*	A program to translate a numeric grade into a letter grade
	Luke
*/

import java.util.Scanner;

public class LetterGrade
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		char letterGrade;

		System.out.print("Enter your test grade: ");
		int grade = scan.nextInt();

		if (grade >= 90)
			letterGrade = 'A';
		else if (grade >= 80)
			letterGrade = 'B';
		else if (grade >= 70)
			letterGrade = 'C';
		else if (grade >= 60)
			letterGrade = 'D';
		else
			letterGrade = 'F';

		System.out.println("Your test grade of " + grade
						   + " is a letter grade of " + letterGrade);
	}
}
