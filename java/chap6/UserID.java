/*	counts the number of digits in a userID
	Luke
*/

import java.util.Scanner;

public class UserID
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter userID: ");
		String userID = scan.next();
		int digits = 0;

		for (int i = 0; i < userID.length(); i++)
		{
			switch (userID.charAt(i))
			{
				case '1': case '2': case '3': case '4': case '5':
				case '6': case '7': case '8': case '9': case '0':
					digits++;
			}
		}

		if (digits == 2)
			System.out.println("Valid UserID");
		else
			System.out.println("Invalid UserID");
	}
}
