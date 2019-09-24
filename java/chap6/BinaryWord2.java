/*	dermines if a number is binary
	Luke
*/

import java.util.Scanner;

public class BinaryWord2
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

		System.out.println(word + " is binary");
		System.out.println("Word contains " + ones + " 1s");
	}
}

			
