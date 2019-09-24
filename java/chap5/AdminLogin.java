/*	Sees if admin access is allowable
	Luke
*/

import java.util.Scanner;

public class AdminLogin
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String username, password;

		System.out.print("Enter username: ");
		username = scan.next();
		System.out.print("Enter password: ");
		password = scan.next();

		if (username.equals("admin") && password.equals("open"))
			System.out.println("Welcome");
		else if (username.equals("admin") && !password.equals("open"))
			System.out.println("Wrong password");
		else if (!username.equals("admin") && password.equals("open"))
			System.out.println("Wrong user ID");
		else 
			System.out.println("Sorry, wrong ID and password");
	}
}
