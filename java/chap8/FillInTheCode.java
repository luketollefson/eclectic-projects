/*	Fill in the Code exercies
	Luke
*/

public class FillInTheCode
{
	public static void main(String[] args)
	{
		/* 27
		int[] a = new int[25];
		for (int i = 0; i < a.length; i++)
			a[i] = 10;
		*/

		/* 28
		double[] a = {45.2,13.1,12.8,87.4,99.0,100.1,43.8,2.4};
		for (int i = 0; i < a.length; i++)
			if (a[i] > 20.0)
				System.out.print(a[i] + " ");

		System.out.println();
		*/

		/* 29
		int[] a = {45,13,12,87,99,100,43,2};
		double average = 0.0;

		for (int i = 0; i < a.length; i++)
			average += a[i];

		average /= a.length;
		System.out.println(average);
		*/

		/* 30
		int[] a = {3,7,9};
		int[] b = {2,9,4};
		int dotProduct = 0;
		for (int i = 0; i < a.length; i++)
			dotProduct += a[i] * b[i];

		System.out.println(dotProduct);
		*/

		/* 31
		int[] a = {3,6,10};

		for (int i = 0; i < a.length; i++)
			System.out.println("a[" + i + "] = " + a[i]);
		*/

		/* 32
		String[] bar = {"What", "IBM"};
		System.out.println(foo(bar));	
		*/

		/* 33
		int[] bar = {7,21,3};
		System.out.println(foo(bar));
		*/


		/* 34
		String[] bar = {"Rocky"}; //, "Roky", "Better"};
		System.out.println(foo(bar));
		*/

		/* 35
		int[] bar = {1,0,0,1,1};
		boolean[] bizz = foo(bar);
		for (int i = 0; i < bizz.length; i++)
			System.out.print(bizz[i] + " ");

		System.out.println();
		*/

		/* 45
		double a[] = {3.3,26.0,48.3};
		*/

		/* 46
		int[] a = {2,7,8,9,11,16};
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
		*/

		/* 47
		boolean equal = true;
		int[] a = {1,2,3};
		int[] b = {1,2,3};
		if (a.length != b.length) {
			equal = false;
			System.out.println("Arrays are not equals");
		} else {
			for (int i = 0; i < a.length; i++)
				if (a[i] != b[i])
					equal = false;

			if (equal)
				System.out.println("Arrays are equal");
			else
				System.out.println("Arrays are not equal");
		}
		*/

		/* 48
		int[] a = {1,2,3};
		System.out.println(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		*/
	}

	/* 35
	public static boolean[] foo(int[] a)
	{
		boolean[] boolArr = new boolean[a.length];
		for (int i = 0; i < a.length; i++)
			if (a[i] == 0)
				boolArr[i] = false;
			else
				boolArr[i] = true;

		return boolArr;
	}
	*/
				

	/* 34
	public static boolean foo(String[] a)
	{
		if (a.length < 2)
			return false;
		else if (a[0].equals(a[1]))
			return true;
		else
			return false;
	}

	/* 33
	public static int foo(int[] a)
	{
		int multsOf7 = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i] % 7 == 0)
				multsOf7++;

		return multsOf7;
	}
	*/

	/* 32
	public static boolean foo(String[] a)
	{
		for (int i = 0; i < a.length; i++)
			for (int j = 0; a[i].length() >= 3 && j < a[i].length()-2; j++)
				if (a[i].substring(j,j+3).equals("IBM"))
					return true;

		return false;
	}
	*/
}
