/*	dermines if a number is binary
	Luke
*/

import java.util.Scanner;

public class BinaryWord6
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String word;
		boolean binary;
		boolean accepted;

		binary = true;
		accepted = false;

		System.out.print("Enter a word: ");
		word = scan.next();

		for (int i = 0; i < word.length(); i++)
		{
			for (int j = 0; i + j < word.length() && word.charAt(i + j) == '1'; j++)
				if (j >= 2)
					accepted = true;
				
			if (word.charAt(i) == '0' || word.charAt(i) == '1')
				;
			else
				binary = false;
		}

		if (accepted && binary)
			System.out.println("Accepted");
		else if (binary)
			System.out.println("Rejected");
		else
			System.out.println("Invalid");
	}
}

			
