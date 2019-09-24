/*	A demonstration of reading from the console using Scanner
	Luke
*/

import java.util.Scanner;

public class DataInput
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your first name > ");
		String firstName = scan.next();
		System.out.println("Your name is " + firstName);

		System.out.print("\nEnter your age as an integer > ");
		int age = scan.nextInt();
		System.out.println("Your age is " + age);

		System.out.print("\nEnter your GPA > ");
		float gpa = scan.nextFloat();
		System.out.println("Your GPA is " + gpa);
	}
}
