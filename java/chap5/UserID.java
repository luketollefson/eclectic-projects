/*	determines wether a userID is valid
	Luke
*/

import java.util.Scanner;

public class UserID
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your id: ");
		String id = scan.next();

		if (id.length() >= 6 && id.length() <= 10)
			System.out.println("Welcome " + id);
		else
			System.out.println("Sorry, user ID invalid");
	}
}
