/*	Word In Cases, output a word in many cases
	Luke
*/

import java.util.Scanner;

public class WordInCases
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a word > ");
		String word = scanner.next();
		System.out.println(word + ' '
						 + word.toUpperCase() + ' '
						 + word.toLowerCase() + ' '
						 + word);
	}
}
