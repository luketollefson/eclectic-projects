/*	Determines if an email address is proper
	Luke
*/

import java.util.Scanner;

public class Email
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter an email address: ");
		String email = scan.next();

		int atIndex = email.indexOf('@');

		if (atIndex == -1)
			System.out.println("Improper email address.");
		else
			System.out.println("Proper email address.");
	}
}
