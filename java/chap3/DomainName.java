/*	create a URL from a domain
	Luke
*/

import java.util.Scanner;

public class DomainName
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a website name > ");
		String website = scanner.next();
		String domain = "www." + website + ".com";
		System.out.println("The domain is " + domain);
	}
}
