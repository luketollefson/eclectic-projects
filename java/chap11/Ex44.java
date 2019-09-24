/*	Exercise 44
	Luke
*/

import java.util.Scanner;

public class Ex44
{
	public static void main(String[] args)
	{
		String query = "first=Mike&last=Jones&id=mike1&password=hello";

		Scanner scan = new Scanner(query);
		scan.useDelimiter("&");

		System.out.println(scan.next().replace("=", ": "));
		System.out.println(scan.next().replace("=", ": "));
		System.out.println(scan.next().replace("=", ": "));
		System.out.println(scan.next().replace("=", ": "));
	}
}
