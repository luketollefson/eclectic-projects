/*	Printing numbers using nested for loops
	Luke
*/

public class NestedForLoops
{
	public static void main(String[] args)
	{
		for (int line = 1; line <= 5; line++)
		{
			for (int number = 1; number <= line; number++)
			{
				System.out.print(number + " ");
			}

			System.out.println();
		}
	}
}
