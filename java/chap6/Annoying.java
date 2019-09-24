/*	beg the user to type @
	Luke
*/

import java.util.Scanner;

public class Annoying
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int atLoc;

		do
		{
			System.out.print("Please type @: ");
			atLoc = scan.next().indexOf('@');
		} while (atLoc == -1);

		System.out.println("Thank you, bitch");
	}
}
