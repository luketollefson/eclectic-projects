/*	Determines the meaning of a web extension
	Luke
*/

import java.util.Scanner;

public class WebExtension
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a web url: ");
		String url = scan.next();

		String extension = url.substring(url.length()-3, url.length());
		System.out.println(extension);

		switch (extension)
		{
			case "gov":
				System.out.println("Government web address");
				break;
			case "edu":
				System.out.println("University web address");
				break;
			case "com":
				System.out.println("Commercial web address");
				break;
			case "org":
				System.out.println("Orginazation web address");
				break;
			default:
				System.out.println("The extension is for another entity");
				break;
		}
	}
}
