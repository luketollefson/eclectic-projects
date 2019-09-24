/*	Average, caluclate the average of three random ints
	Luke
*/

import java.util.Random;

public class Average
{
	public static void main(String[] args)
	{
		Random rand = new Random();

		int i = rand.nextInt(51);
		int j = rand.nextInt(51);
		int k = rand.nextInt(51);

		double average = (i + j + k) / 3.0;

		System.out.println("The average of the three random numbers is " + average);
	}
}
