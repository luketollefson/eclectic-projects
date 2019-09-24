/*	bubble sort
	Luke
*/

public class BubbleSort
{
	public static void main(String[] args)
	{
		/*
		int[] number = {3,6,7,8,12,15,22,36,45,
						48,51,53,64,69,72,89,95};
		*/
		int[] number = {42,52,2,32,6,72,4,114,52,6};

		System.out.println(sequentialSearch(number, 114));
		bubbleSort(number);

		for (int i = 0; i < number.length; i++)
			System.out.print(number[i] + ",");
	}

	public static int sequentialSearch(int[] arr, int n)
	{
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == n)
				return i;

		// if not found
		return -1;
	}

	public static void bubbleSort(int[] arr)
	{
		for (int i = 0; i < arr.length-1; i++)
			for (int j = 0; j < arr.length-i-1; j++)
				if (arr[j] > arr[j+1])
					swap(arr, j, j+1);
	}
		
	public static void swap(int[] arr, int a, int b)
	{
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
