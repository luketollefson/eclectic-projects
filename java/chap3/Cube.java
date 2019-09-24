/*	Cube, cube a number
	Luke
*/

import java.util.Scanner;

public class Cube
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		double input = scanner.nextDouble();

		System.out.println(Math.pow(input, 3));
	}
}
