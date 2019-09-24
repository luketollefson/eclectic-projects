/*	counts how many websites are .coms
	Luke
*/

import java.util.Scanner;

public class ComWebsites
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int comCount = 0;
		String website;

		do
		{
			System.out.print("Enter a website or \"stop\" to stop: ");
			website = scan.next();

			if (website.length() >= 4)
				if (website.substring(website.length()-4,website.length()).equals(".com"))
					comCount++;
		} while (!website.equals("stop"));

		System.out.println(comCount + " websites were .com");
	}
}
