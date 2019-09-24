/**	Type-Safe Input Using Scanner
*	Luke
*/
package com.jbpub.af;

import java.util.Scanner;

public class ConsoleIn
{
	private Scanner scan;

	public ConsoleIn()
	{
		scan = new Scanner(System.in);
	}

	public int readInt(String prompt)
	{
		System.out.println(prompt + " > ");
		while (!scan.hasNextInt())
		{
			String garbage = scan.nextLine();
			System.ou.println("Input is not an integer");
			System.out.print(prompt + " > ");
		}
		return scan.nextInt();
	}
}
