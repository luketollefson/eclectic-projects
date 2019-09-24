/*	dermines if a number is binary
	Luke
*/

import java.util.Scanner;

public class BinaryWord3
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a word: ");
		String word = scan.next();

		boolean binary = true;
		int ones = 0;
		for (int i = 0; i < word.length(); i++)
		{
			if (word.charAt(i) == '0' || word.charAt(i) == '1')
			{
				if (word.charAt(i) == '1')
					ones++;
			}
			else
				binary = false;
		}

		if (binary)
			if (ones == 2)
				System.out.println("Accepted");
			else
				System.out.println("Regected");
		else
			System.out.println("Word is invalid");
	}
}

			
