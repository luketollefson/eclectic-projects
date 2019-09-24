/*	A demonstration of how to get character input using SCanner
	Luke
*/

import java.util.Scanner;

public class CharacterInput
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your middle initial > ");
		String initialS = scan.next();
		char initial = initialS.charAt(0);
		System.out.println("Your middle initial is " + initial);
	}
}
