/*	dermines if a number is binary
	Luke
*/

import java.util.Scanner;

public class BinaryWord4
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String word;
		boolean binary;
		int ones;

		do
		{
			binary = true;
			ones = 0;

			System.out.print("Enter a word: ");
			word = scan.next();
	
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

			if (binary == false)
				System.out.println("Please enter a word with only 1s and 0s");
		} while (binary == false);

		if (ones == 2)
			System.out.println("Accepted");
		else
			System.out.println("Rejected");
	}
}

			
