/*	Small Passwords, outputs the small password
	Luke
*/

import java.util.Scanner;

public class SmallPasswords
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a password > ");
		String pass1 = scanner.next();
		System.out.print("Enter another password > ");
		String pass2 = scanner.next();

		int shorterPassLength = Math.min(pass1.length(), pass2.length());
		System.out.println("The shorter password is "
						   + shorterPassLength
						   + " characters long");
	}
}
