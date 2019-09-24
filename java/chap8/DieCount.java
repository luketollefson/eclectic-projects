/**	DieCount Class
*	Luke
*/

public class DieCount
{
	public static void main(String[] args)
	{
		final int FACES = 7, NUMBER_OF_ROLLS = 500;

		int[] rollCount = new int[FACES];

		Die d1 = new Die();

		for (int i = 1; i <= NUMBER_OF_ROLLS; i++)
		{
			int myRoll = d1.roll();
			rollCount[myRoll]++;
		}

		System.out.println("Roll\tCount");
		for (int i = 1; i < rollCount.length; i++)
		{
			System.out.println((i) + "\t" + rollCount[i]);
		}
	}
}
