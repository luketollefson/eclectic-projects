/**	Client for Selection Sort
*	Luke
*/
import java.util.Random;

public class InsertionSortClient
{
	public static void main(String[] args)
	{
		int[] numbers = new int[6];
		Random rand = new Random();
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(5000) + 1;
		}

		System.out.println("Before Insertion Sort, the array is");
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + "\t");
		System.out.println();

		Sorter.insertionSort(numbers);

		System.out.println("\nAfter Insertion Sort, the array is");
		for (int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + "\t");
		System.out.println();
	}
}
