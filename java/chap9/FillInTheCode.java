/*	Fill In The Code exercises
	Luke
*/

import java.util.ArrayList;

public class FillInTheCode
{
	public static void main(String[] args)
	{
		/* 33-37
		String[][] geo = { {"MD", "NY", "NJ", "MA", "ME", "CA", "MI", "OR"},
						   {"Detroit", "Newark", "Boston", "Seattle"} };

		// 33
		System.out.println(geo[1][2]);

		// 34
		System.out.println(geo[0][5]);

		// 35
		for (int j = 0; j < geo[0].length; j++)
		{
			if (geo[0][j].charAt(0) == 'M')
				System.out.print(geo[0][j] + "\t");
		}
		System.out.println();

		// 36
		for (int j = 0; j < geo[1].length; j++)
		{
			System.out.print(geo[1][j] + "\t");
		}
		System.out.println();

		// 37
		for (int i = 0; i < geo.length; i++)
		{
			for (int j = 0; j < geo[i].length; j++)
				System.out.print(geo[i][j] + "\t");

			System.out.println();
		}
		*/

		int[][] a = { {9, 6, 8, 10, 5},
					  {7, 6, 8, 9, 6},
					  {4, 8, 10, 6, 6} };

		// 38
		int sum = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				sum += a[i][j];
			}
		}
		System.out.println("sum is " + sum);

		// 39
		int count = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				if (a[i][j] == 8)
					count++;
			}
		}
		System.out.println("# of 8s in a: " + count);

		// 40
		count = 0;
		for (int j = 0; j < a[1].length; j++)
		{
			if (a[1][j] == 6)
				count++;
		}
		System.out.println("# of 6s in the 2nd row: " + count);

		// 41
		sum = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (a[i].length >= 2)
				sum += a[i][1];
		}
		System.out.println("sum is " + sum);

		/* 42
		String[][] sa = {{"Tea", "cookie"},{"Java"}};
		System.out.println(foo(sa));
		*/

		// 43 System.out.println(foo(a));	

		/* 44
		char[][] a2 = { {'a','a','a'},
						{'a','a','a','a','a'} };
		System.out.println(foo(a2));
		*/

		/* 45
		int[][] a2 = { {1,3,0},
					   {3,2,4} };
		boolean[] ba = foo(a2);
		for (int i = 0; i < ba.length; i++)
			System.out.print(ba[i] + " ");
		System.out.println();
		*/

		ArrayList<String> languages = new ArrayList<String>();
		languages.add("SQL");
		languages.add("Java");
		languages.add("HTML");
		languages.add("PHP");
		languages.add("Perl");

		// 46 System.out.println(languages.size());

		/* 47
		String webLanguage = languages.get(2);
		System.out.println(webLanguage);
		*/

		/* 48
		languages.set(2, "C++");
		System.out.println(languages.get(1) + languages.get(2));
		*/

		for (String s : languages)
		{
			if (s.charAt(0) == 'P')
				System.out.println(s);
		}

	}

	/* 45
	public static boolean[] foo(int[][] a)
	{
		boolean[] temp = new boolean[a.length];
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				if (a[i][j] == 0)
					temp[i] = true;
			}
		}
		return temp;
	}
	*/

	/* 44
	public static boolean foo(char[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			if (a[i].length == 5)
				return true;
		}
		return false;
	}
	*/

	/* 43
	public static int foo(int[][] a)
	{
		int product = 1;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				product *= a[i][j];
			}
		}
		return product;
	}
	*/

	/* 42
	public static boolean foo(String[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				if (a[i][j].equals("Java"))
					return true;
			}
		}

		// else
		return false;
	}
	*/
}
