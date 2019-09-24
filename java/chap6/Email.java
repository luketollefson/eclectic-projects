/*	determins if a email address has a @ or not
	Luke
*/

import java.util.Scanner;

public class Email
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter an email: ");
		String email = scan.next();

		boolean containsAt = false;
		for (int i = 0; i < email.length(); i++)
		{
			if (email.charAt(i) == '@')
				containsAt = true;
		}

		if (containsAt)
			System.out.println("That is a proper email");
		else
			System.out.println("That is a inproper email");
	}
}
