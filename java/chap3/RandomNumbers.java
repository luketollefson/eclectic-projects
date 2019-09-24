/*	A demonstration of the Random class
	Luke
*/
import java.util.Random;

public class RandomNumbers
{
	public static void main(String[] args)
	{
		Random random = new Random();

		// simulate the roll of a die
		int die = random.nextInt(6) + 1;
		System.out.println("\nThe die roll is " + die);

		// generate a random number between 20 and 200
		int start = 20, end = 200;
		int number = random.nextInt(end - start + 1) + start;
		System.out.println("\nThe random number between " + start
						   + " and " + end + " is " + number);
	}
}
