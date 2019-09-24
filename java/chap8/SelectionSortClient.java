/**	Client for Selection Sort
*	Luke
*/
import java.util.Random;

public class SelectionSortClient
{
	public static void main(String[] args)
	{
		int[] numbers = new int[6];
		Random rand = new Random();
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(5000) + 1;
		}

		System.out.println("Before Selection Sort, the array is");
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + "\t");
		System.out.println();

		Sorter.selectionSort(numbers);

		System.out.println("\nAfter Selection Sort, the array is");
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + "\t");
		System.out.println();
	}
}
