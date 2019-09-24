/** Binary Search
*	Luke
*/

import java.util.Scanner;

public class BinarySearcher
{
	public static void main(String[] args)
	{
		int[] numbers = {3,6,7,8,12,15,22,36,45,
						 48,51,53,64,69,72,89,95};

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a value to search for > ");
		int key = scan.nextInt();

		int index = binarySearch(numbers, key);
		if (index != -1)
			System.out.println(key + " found at index " + index);
		else
			System.out.println(key + " not found");
	}

	public static int binarySearch(int[] arr, int key)
	{
		int start = 0;
		int end = arr.length - 1;
		int middle;

		while (end >= start)
		{
			middle = (start + end) / 2;

			if (arr[middle] == key)
			{
				return middle;
			}
			else if (arr[middle] > key)
			{
				end = middle - 1;
			}
			else
			{
				start = middle + 1;
			}
		}
		return -1;
	}
}
