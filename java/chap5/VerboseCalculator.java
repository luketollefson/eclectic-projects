/*	an English calculator that is rather verbose
	Luke
*/

import java.util.Scanner;

public class VerboseCalculator
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int o1, o2;
		char operation;

		System.out.print("Enter a digit: ");
		o1 = scan.nextInt();
		System.out.print("Enter a digit: ");
		o2 = scan.nextInt();
		System.out.print("Enter the operations on the digits: ");
		operation = scan.next().charAt(0);

		String so1, so2;
		boolean invalidNumber = false;

		switch (o1)
		{
			case 0:
				so1 = "zero";
				break;
			case 1:
				so1 = "one";
				break;
			case 2:
				so1 = "two";
				break;
			case 3:
				so1 = "three";
				break;
			case 4:
				so1 = "four";
				break;
			case 5:
				so1 = "five";
				break;
			case 6:
				so1 = "six";
				break;
			case 7:
				so1 = "seven";
				break;
			case 8:
				so1 = "eight";
				break;
			case 9:
				so1 = "nine";
				break;
			default:
				so1 = "";
				invalidNumber = true;
		}

		switch (o2)
		{
			case 0:
				so2 = "zero";
				break;
			case 1:
				so2 = "one";
				break;
			case 2:
				so2 = "two";
				break;
			case 3:
				so2 = "three";
				break;
			case 4:
				so2 = "four";
				break;
			case 5:
				so2 = "five";
				break;
			case 6:
				so2 = "six";
				break;
			case 7:
				so2 = "seven";
				break;
			case 8:
				so2 = "eight";
				break;
			case 9:
				so2 = "nine";
				break;
			default:
				so2 = "";
				invalidNumber = true;
		}

		if (invalidNumber) {
			System.out.println("Invalid number");
			System.exit(1);
		}

		switch (operation)
		{
			case '+':
				System.out.println(so1 + " plus " + so2 + " is " + (o1+o2));
				break;
			case '-':
				System.out.println(so1 + " minus " + so2 + " is " + (o1-o2));
				break;
			case '*':
				System.out.println(so1 + " multiplied by " + so2 + " is " + (o1*o2));
				break;
			case '/':
				if (o2 == 0)
					System.out.println("Division by zero is not allowed");
				else
					System.out.println(so1 + " divided by " + so2 + " is " + (o1/o2));
				break;
			case '^':
				System.out.println(so1 + " to the power " + so2 + " is " + (int) Math.pow(o1,o2));
				break;
			default:
				System.out.println("Invalid operator " + operation);
				break;
		}
	}
}
