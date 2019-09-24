/*	Determines whether a letter comes before 'b'
	Luke
*/

import java.util.Scanner;

public class UnicodeB
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		char input;

		System.out.print("Enter a character: ");
		input = scan.next().charAt(0);

		if (input > 'b')
			System.out.println(input + " is after b");
		else if (input < 'b')
			System.out.println(input + " is before b");
		else
			System.out.println("b is equal to b");
	}
}
