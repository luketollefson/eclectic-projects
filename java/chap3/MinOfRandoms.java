/*	Min Of Randoms, calcuate the minimum of five random
	numbers
	Luke
*/

import java.util.Random;

public class MinOfRandoms
{
	public static void main(String[] args)
	{
		Random rand = new Random();

		int a = rand.nextInt(41) + 60;
		int b = rand.nextInt(41) + 60;
		int c = rand.nextInt(41) + 60;
		int d = rand.nextInt(41) + 60;
		int e = rand.nextInt(41) + 60;

		int min = Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));

		System.out.println(min);
	}
}
