/*	Short programs
	Luke
*/

import java.util.ArrayList;

public class ShortPrograms
{
	public static void main(String[] args)
	{
		/*
		double[][] ad = { {1.0, 2.0, 4.0},
						 {6.0, 2.3, 5.3} };
		System.out.println(rows(ad));
		*/

		/*
		float[][] af = { {1.0f, 2.0f, 4.0f},
						 {6.0f, 2.3f, 5.3f} };
		System.out.println(elements(af));
		*/

		/*
		boolean[][] ab = { {true, false},
						   {false, false, true} };
		System.out.println(columns(ab));
		*/

		/* 
		char[][] ac = { {'a','b','c'},
						{'d','e','f','g'} };
		System.out.println(columns(ac, 5));
		*/

		/*
		float[][] af = { {1.0f, 2.0f, 4.0f},
						 {6.0f, 2.3f, 5.3f} };
		System.out.println(sum(af));
		*/

		/*
		int[][] ai = { {2, 2, 2},
					   {3, 3, 3},
					   {4, 4, 4} };
		zeroAndOne(ai);
		for (int i = 0; i < ai.length; i++)
		{
			for (int j = 0; j < ai[i].length; j++)
				System.out.print(ai[i][j] + " ");

			System.out.println();
		}
		*/

		/*
		int[][] ai = { {2, 2, 2},
					   {3, 3, 3},
					   {4, 4, 4} };
		System.out.println(sumOfLastColumn(ai));
		*/

		/*
		boolean[][] ab = { {true, false},
						   {false, false, true} };
		invert(ab);
		for (int i = 0; i < ab.length; i++)
		{
			for (int j = 0; j < ab[i].length; j++)
				System.out.print(ab[i][j]);

			System.out.println();
		}
		*/

		/*
		boolean[][] ab = { {true, false},
						   {false, false, true} };
		System.out.println(numberTrue(ab));
		*/

		/*
		boolean[][] ab = { {true, false},
						   {false, false, true} };
		System.out.println(numberFalse(ab));
		*/

		/*
		int[][] ai = { {2, 2, 2},
					   {3, 3, 3},
					   {4, 5, 4} };
		System.out.println(average(ai));
		*/

		/*
		float[][] af = { {2.3f, 4.5f, 2.3f},
						 {3.1f, 5.6f, 2.5f, 12.2f} };
		System.out.println(isRegular(af));
		*/

		/*
		String[][] as = { {"Hello", " World"},
						  {" Nice", " One", " Dog!"} };
		System.out.println(concat(as));
		*/

		/*
		char[][] ac = { {'n','i','c','e'},
						{'w','o','r'} };
		String[] as = concat(ac);
		for (int i = 0; i < as.length; i++)
			System.out.println(as[i]);
		*/

		/*
		int[][] a = { {81, 91, 10},
					  {72, 100} };
		char[][] aac = letterGrade(a);
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				System.out.print(aac[i][j] + " ");
			}
			System.out.println();
		}
		*/

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(4);
		al.add(5);
		al.add(1);
		al.add(10);
		System.out.println(sum(al));

		System.out.println(parity(al));

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(88);
		al2.add(59);
		al2.add(60);
		al2.add(70);
		ArrayList<Character> cl2 = letterGrade(al2);
		for (char c : cl2)
			System.out.print(c + " ");
		System.out.println();

	}

	// 85
	public static ArrayList<Character> letterGrade(ArrayList<Integer> a)
	{
		ArrayList<Character> lc = new ArrayList<Character>();
		for (int x : a)
		{
			if (x >= 90)
				lc.add('A');
			else if (x >= 80)
				lc.add('C');
			else if (x >= 70)
				lc.add('D');
			else if (x >= 60)
				lc.add('D');
			else
				lc.add('F');
		}
		return lc;
	}

	// 84
	public static String parity(ArrayList<Integer> a)
	{
		return (a.size() % 2 == 0 ? "even" : "odd");
	}

	// 83
	public static int sum(ArrayList<Integer> a)
	{
		int total = 0;
		for (int x : a)
			total += x;
		
		return total;
	}

	// 82
	public static char[][] letterGrade(int[][] a)
	{
		char[][] aac = new char[a.length][];

		for (int i = 0; i < a.length; i++)
		{
			aac[i] = new char[a[i].length];
			for (int j = 0; j < a[i].length; j++)
			{
				if (a[i][j] >= 90)
					aac[i][j] = 'A';
				else if (a[i][j] >= 80)
					aac[i][j] = 'B';
				else if (a[i][j] >= 70)
					aac[i][j] = 'C';
				else if (a[i][j] >= 60)
					aac[i][j] = 'D';
				else
					aac[i][j] = 'F';
			}
		}

		return aac;
	}

	// 81
	public static String[] concat(char[][] a)
	{
		String[] as = new String[a.length];
		for (int i = 0; i < as.length; i++)
			as[i] = "";

		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				as[i] += a[i][j];
			}
		}

		return as;
	}

	// 80
	public static String concat(String[][] a)
	{
		String s = "";
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
				s += a[i][j];
		}

		return s;
	}

	// 79
	public static String isRegular(float[][] a)
	{
		int column = a[0].length;
		for (int i = 0; i < a.length; i++)
			if (a[i].length != column)
				return "irregular";

		return "regular";
	}

	// 78
	public static double average(int[][] a)
	{
		int count = 0;
		int total = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				total += a[i][j];
			}
			count += a[i].length;
		}
		
		return (double) total / count;
	}

	// 77
	public static int numberFalse(boolean[][] a)
	{
		int total = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
				total += (!a[i][j] ? 1 : 0);
		}
		return total;
	}

	// 76
	public static int numberTrue(boolean[][] a)
	{
		int total = 0;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
				total += (a[i][j] ? 1 : 0);
		}
		return total;
	}

	// 75
	public static void invert(boolean[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
				a[i][j] = !a[i][j];
		}
	}

	// 74
	public static int sumOfLastColumn(int[][] a)
	{
		int total = 0;
		for (int i = 0; i < a.length; i++)
			total += a[i][a[i].length-1];

		return total;
	}

	// 73
	public static void zeroAndOne(int[][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				a[i][j] = (i % 2 == 0 ? 0 : 1);
			}
		}
	}

	// 72
	public static float sum(float[][] a)
	{
		float total = 0f;
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
				total += a[i][j];
		}
		
		return total;
	}

	// 71 - returns the number of columns that are n long
	public static int columns(char[][] a, int n)
	{
		int total = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i].length == n)
				total++;

		return total;
	}

	// 70
	public static int columns(boolean[][] a)
	{
		int mostColumns = 0;
		for (int i = 0; i < a.length; i++)
			mostColumns = Math.max(mostColumns, a[i].length);

		return mostColumns;
	}

	// 69
	public static int elements(float[][] a)
	{
		int total = 0;
		for (int i = 0; i < a.length; i++)
			total += a[i].length;

		return total;
	}

	// 68
	public static int rows(double[][] a)
	{
		return a.length;
	}
}
