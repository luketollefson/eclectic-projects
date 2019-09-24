/*	Numeric Character find the unicode value of characters
	Luke
*/

import java.util.Scanner;

public class NumericCharacter
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a character > ");
		char c = scanner.next().charAt(0);

		System.out.println(c + " has a Unicode value of "
					         + Character.getNumericValue(c));
	}
}
