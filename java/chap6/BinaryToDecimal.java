/*	converts a binary number to its decimal representation
	Luke
*/

import java.util.Scanner;

public class BinaryToDecimal
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a binary numer: ");
		String binary = scan.next();

		int total = 0;

		for (int i = 0; i < binary.length(); i++)
		{
			if (binary.charAt(i) == '1')
				total += Math.pow(2,binary.length()-i-1);
		}

		System.out.println("The value of " + binary + " is " + total);
	}
}

