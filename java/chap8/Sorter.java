/*	Sort Utility Class
*	Luke
*/

public class Sorter
{
	/** Uses Selection Sort to sort
	*	an integer array in ascending order
	*	@param array the arry to sort
	*/
	public static void selectionSort(int[] array)
	{
		int temp;
		int max;

		for (int i = 0; i < array.length - 1; i++)
		{
			max = indexOfLargestElement(array, array.length - i);

			temp = array[max];
			array[max] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
	}

	/** Finds index of largest element
	*	@param size the size of the subarray
	*	@param array the array to search
	*	@return the index of the largest element in the subarray
	*/
	private static int indexOfLargestElement(int[] array, int size)
	{
		int index = 0;
		for (int i = 1; i < size; i++)
		{
			if (array[i] > array[index])
				index = i;
		}
		return index;
	}

	public static void insertionSort(int[] array)
	{
		int j, temp;

		for (int i = 1; i < array.length; i++)
		{
			j = i;
			temp = array[i];

			while (j != 0 && array[j - 1] > temp)
			{
				array[j] = array[j - 1];
				j--;
			}

			array[j] = temp;
		}
	}

	public static void insertionSort(Auto[] arr)
	{
		Auto temp;
		int j;

		for (int i = 1; i < arr.length; i++)
		{
			j = i;
			temp = arr[i];

			while (j != 0 && (temp.getModel()).compareTo(
					arr[j-1].getModel()) < 0)
			{
				arr[j] = arr[j - 1];
				j--;
			}

			arr[j] = temp;
		}
	}
}
