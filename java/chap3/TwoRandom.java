/*	Two Random generates two random numbers and out-
	puts the smaller one
	Luke
*/

import java.util.Random;

public class TwoRandom
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int i = rand.nextInt(101);
		int j = rand.nextInt(101);
		System.out.println(i + " " + j + " " + Math.min(i, j));
	}
}
