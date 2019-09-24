/*	Demonstration of the String comparison methods
	Luke
*/

public class ComparingStrings
{
	public static void main(String[] args)
	{
		String title1 = "Green Pastures";
		String title2 = "Green Pastures II";
		String title3 = "green pastures";

		System.out.print("Using equals: ");
		if (title1.equals(title3))
			System.out.println(title1 + " equals " + title3);
		else
			System.out.println(title1 + " is not equal to " + title3);

		System.out.print("Using equalsIgnoreCase: ");
		if (title1.equalsIgnoreCase(title3))
			System.out.println(title1 + " equals " + title3);
		else
			System.out.println(title1 + " is not equal to " + title3);

		System.out.print("Using compareTo: ");
		if (title1.compareTo(title3) > 0)
			System.out.println(title1 + " is greater than " + title3);
		else if (title1.compareTo(title3) < 0)
			System.out.println(title1 + " is less than " + title3);
		else
			System.out.println(title1 + " is equal to " + title3);

		System.out.print("Using compareTo: ");
		if (title1.compareTo(title2) > 0)
			System.out.println(title1 + " is greater than " + title2);
		else if (title1.compareTo(title3) < 0)
			System.out.println(title1 + " is less than " + title2);
		else
			System.out.println(title1 + " is equal to " + title2);
	}
}
