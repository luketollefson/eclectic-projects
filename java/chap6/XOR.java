/*	simulates a unary XOR on a binary number
	Luke
*/

import java.util.Scanner;

public class XOR
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a binary number: ");
		String binary = scan.next();

		int lastXOR = (binary.charAt(0) == '1' ? 1 : 0);

		for (int i = 1; i < binary.length(); i++)
		{
			if (lastXOR == 1 && binary.charAt(i) == '1') {
				System.out.print('0');
				lastXOR = 0;
			} else if (lastXOR == 1 && binary.charAt(i) == '0') {
				System.out.print('1');
				lastXOR = 1;
			} else if (lastXOR == 0 && binary.charAt(i) == '1') {
				System.out.print('1');
				lastXOR = 1;
			} else {
				System.out.print('0');
				lastXOR = 0;
			}
		}

		System.out.println();
	}
}
