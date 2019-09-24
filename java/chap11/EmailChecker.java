/*	The EmailChecker class
	Luke
*/

import java.util.Scanner;

public class EmailChecker
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your email address > ");
		String myEmail = scan.next();
		try
		{
			EmailAddress address = new EmailAddress(myEmail);
			System.out.println("Your host is " + address.getHost());
		}
		catch (IllegalEmailException iee)
		{
			System.out.println(iee.getMessage());
		}
	}
}
