/*	debugging area
	Luke
*/

import java.util.ArrayList;

public class Test
{
	public static void main(String[] args)
	{
		/* 59
		int[][] a = { {2, 7}, {9, 2} };
		*/

		/* 60
		int[][] a = { {1, 2, 3, 4},
					  {10, 20, 30} };

		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				System.out.println(a[i][j]);
			}
		}
		*/

		/* 61
		int[][] a = { {9, 8, 7, 6},
					  {10, 20, 30, 40} };
		int min = a[0][0];
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				if (a[i][j] < min)
					min = a[i][j];
			}
		}
		System.out.println("The minimum is " + min);
		*/

		/* 62
		int[][] a= { {9, 8, 7, 6},
					 {10, 20, 30, 40} };

		for (int j = 0; j < a[1].length; j++)
		{
			if (a[1][j] == 20)
			{
				System.out.println("Found 20 at column index " + j
									+ " of second row");
			}
		}
		*/

		/* 64
		ArrayList<String> a = new ArrayList<String>();
		a.add("Cloudy");
		a.add("Snowy");
		a.add("Cloudy");
		System.out.println("Weather is " + a.get(2));
		*/

		/* 65
		ArrayList<Integer> a = new ArrayList<Integer>();
		*/

		/* 66
		ArrayList<Double> a = new ArrayList<Double>();
		a.add(new Double(2.3));
		a.add(8.4);
		a.add(new Double(5));
		*/

		/* 67
		ArrayList<Character> a = new ArrayList<Character>();
		a.add('X');
		a.add('A');
		a.add('V');
		a.add('A');
		a.set(0, 'J');
		for (Character c : a)
			System.out.print(c + " ");
		*/
	}

	/* 63
	public static void main(String[] args)
	{
		for (Auto a : cars)
		{
			System.out.println(a.toString());
		}
	}
	*/
}
