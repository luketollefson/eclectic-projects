/*	Some web addresses
	Luke
*/

import java.util.ArrayList;

public class Ex57
{
	public static void main(String[] args)
	{
		ArrayList<String> addrs = new ArrayList<String>();
		addrs.add("ndsu.edu");
		addrs.add("gnu.org");
		addrs.add("example.com");
		addrs.add("harvard.edu");

		System.out.println(Addresses.countAddresses(addrs, ".com"));
	}
}

class Addresses
{
	public static int countAddresses(ArrayList<String> addrs, String extension)
	{
		int count = 0;
		for (String ad : addrs)
			if (ad.indexOf(extension) != -1 
				&& ad.length() == ad.indexOf(extension) + extension.length()) // ensure its at the end
				count++;

		return count;
	}
}
