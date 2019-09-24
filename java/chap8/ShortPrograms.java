/*	Write short programs
	Luke
*/

public class ShortPrograms
{
	public static void main(String[] args)
	{
		int[] a = {1,2,3};
		System.out.println(numberOfElements(a));
		System.out.println(product(a));
		zeros(a);
		System.out.println(a[1]);
		int[] b = {1,2,3};
		a = b;
		mult2(a);
		System.out.println(a[1]);
		int[] c = {90,80};
		System.out.println(percentEqOrOver90(c));

		double[] d = {60.0,50.0,10.0,-4.0};
		System.out.println(range(d));

		int[] e = {1,2,3,4};
		System.out.println(sumOdds(e));

		boolean[] f = {true,false,true};
		System.out.println(perTrue(f));

		String[] g = {"Nice","WOW","Hello","Dang"};
		System.out.println(containsHello(g));

		char[] h = {'a','b','c'};
		printReverse(h);

		char[] i = reverseArr(h);
		System.out.println(""+i[0]+i[1]+i[2]);

		String word = "wor";
		char[] j = stringToCharA(word);
		System.out.println(""+j[0]+j[1]+j[2]);

		int[] k = {1,2,100,150};
		boolean[] l = greatOrLess100(k);
		System.out.println(""+l[0]+l[1]+l[2]+l[3]);
	}

	public static boolean[] greatOrLess100(int[] a)
	{
		boolean[] r = new boolean[a.length];
		for (int i = 0; i < a.length; i++)
			if (a[i] >= 100)
				r[i] = true;
			else
				r[i] = false;

		return r;
	}

	public static char[] stringToCharA(String s)
	{
		char[] a = new char[s.length()];
		for (int i = 0; i < s.length(); i++)
			a[i] = s.charAt(i);
		
		return a;
	}

	public static char[] reverseArr(char[] a)
	{
		char[] r = new char[a.length];
		for (int i = 0; i < a.length; i++)
			r[r.length-i-1] = a[i];

		return r;
	}

	public static void printReverse(char[] a)
	{
		for (int i = a.length-1; i >= 0; i--)
			System.out.print(a[i]);

		System.out.println();
	}

	public static boolean containsHello(String[] a)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i].equals("Hello"))
				return true;

		return false;
	}

	public static double perTrue(boolean[] a)
	{
		int numTrue = 0;
		for (int i = 0; i < a.length; i++)
			if (a[i])
				numTrue++;

		return (double) numTrue / a.length * 100;
	}

	public static int sumOdds(int[] a)
	{
		int total = 0;
		for (int i = 1; i < a.length; i+=2)
			total += a[i];

		return total;
	}

	public static double range(double[] a)
	{
		double min = a[0];
		double max = a[0];
		for (int i = 0; i < a.length; i++)
		{
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		return max - min;
	}

	public static double percentEqOrOver90(int[] a)
	{
		int count = 0;
		int overeq90 = 0;
		for (int i = 0; i < a.length; i++)
		{
			count++;
			if (a[i] >= 90)
				overeq90++;
		}
		return (double) overeq90 / count * 100;
	}

	public static void mult2(int[] a)
	{
		for (int i = 0; i < a.length; i++)
			a[i] *= 2;
	}

	public static void zeros(int[] a)
	{
		for (int i = 0; i < a.length; i++)
			a[i] = 0;
	}

	public static int product(int[] a)
	{
		int prod = 1;
		for (int i = 0; i < a.length; i++)
			prod *= a[i];

		return prod;
	}

	public static int numberOfElements(int[] a)
	{
		return a.length;
	}
}
