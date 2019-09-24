/*	prints a word with each character seperated by a space
	Luke
*/

import java.util.Scanner;

public class Spacy
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a word > ");
		String word = scan.next();

		for (int i = 0; i < word.length(); i++)
			System.out.print(word.charAt(i) + " ");

		System.out.println();
	}
}
