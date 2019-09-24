/*	Find Website Name given a URL
	Luke
*/

import java.util.Scanner;

public class FindWebsiteName
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the URL of a website > ");
		String url = scanner.next();

		String website = url.substring(4,url.length()-4);

		System.out.println("The website name is " + website);
	}
}
