/*	A demonstration of using Scanner's nextLine method
	Luke
*/

import java.util.Scanner;

public class InputALine
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("enter a sentence > ");
		String sentence = scan.nextLine();
		System.out.println("You said: \"" + sentence + "\"");
	}
}
