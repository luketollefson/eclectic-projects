/*	Telephone Number, reprint telephone number
	Luke
*/

import java.util.Scanner;

public class TelephoneNumber
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a telephone number > ");
		String phoneNumber = scanner.next();

		String n1 = phoneNumber.substring(0,3);
		String n2 = phoneNumber.substring(4,7);
		String n3 = phoneNumber.substring(8,12);

		System.out.println(n1 + " " + n2 + " " + n3);
	}
}
