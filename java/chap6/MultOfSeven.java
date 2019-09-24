/*	finds the number of multiples of seven between 33 and 97
	Luke
*/

public class MultOfSeven
{
	public static void main(String[] args)
	{
		int mults = 0;

		for (int i = 33; i <= 97; i++)
			mults += (i % 7 == 0 ? 1 : 0);

		System.out.println(mults);
	}
}
