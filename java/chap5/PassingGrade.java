/*	Using if/else
	Luke
*/

import java.util.Scanner;

public class PassingGrade
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a grade > ");
		int grade = scan.nextInt();

		String message;
		if (grade >= 60)
			message = "You passed";
		else
			message = "You failed";

		System.out.println(message);
	}
}
