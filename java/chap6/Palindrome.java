/*	determines wether a word is a palindrome
	Luke
*/

import java.util.Scanner;

public class Palindrome
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a word: ");
		String word = scan.nextLine();

		String reverse = "";

		for (int i = 0; i < word.length(); i++)
			reverse = word.charAt(i) + reverse;

		if (word.equalsIgnoreCase(reverse))
			System.out.println("Word is a palindrome");
		else
			System.out.println("Word is not a palindrome");
	}
}
