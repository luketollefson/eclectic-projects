/*	find the product of 3 to 7
	Luke
*/

public class ThreeToSeven
{
	public static void main(String[] args)
	{
		int product = 1;

		for (int i = 3; i <= 7; i++)
			product *= i;

		System.out.println(product);
	}
}
