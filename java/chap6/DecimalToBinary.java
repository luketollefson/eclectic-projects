/*	converts decimal number into its binary representation
	Luke
*/

import java.util.Scanner;

public class DecimalToBinary
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int n = scan.nextInt();

		// find the largest possible power of 2 in n
		int pow2;
		for (pow2 = 0; Math.pow(2,pow2) <= n; pow2++)
			;
		pow2--;

		while (n > 0)
		{
			if (Math.pow(2, pow2) <= n)
			{
				System.out.print("1");
				n -= Math.pow(2, pow2);
			}
			else
				System.out.print("0");

			pow2--;
		}

		System.out.println();
	}
}

