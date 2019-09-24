/*	Enteres two passwords
	Luke
*/

import java.util.Scanner;

public class Password
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your password: ");
		String pass1 = scan.next();
		System.out.print("Enter it agains: ");
		String pass2 = scan.next();

		if (pass1.equals(pass2))
			System.out.println("Passwords match");
		else
			System.out.println(pass1 + " doesn't match " + pass2);
	}
}
