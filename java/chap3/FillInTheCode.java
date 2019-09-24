/*	Fill In The Code are execerise
	Luke
*/

import java.util.Scanner;
import javax.swing.JOptionPane;

public class FillInTheCode
{
	public static void main(String[] args)
	{
		/* 24
		String s1 = "Intro ";
		String s2 = "to";
		String s3 = " Programming";
		String s4 = s1 + s2 + s3;
		System.out.println(s4);
		*/

		/* 25
		String s = "Hello world";
		System.out.println(s.length());
		*/

		/* 26
		System.out.print("Enter some text > ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println("You entered \"" + input + "\" and that"
						   + " has " + input.length() + " characters.");
		*/

		/* 27
		String s1 = "Welcome ";
		String s2 = "to ";
		String s3 = "Java ";
		String s4 = "Illuminated";
		System.out.println("Welcome to Java " + s4);
		*/

		/* 28
		String s1 = "Welcome ";
		String s2 = "to ";
		String s3 = "Java ";
		String s4 = "Illuminated";
		System.out.print(s1);
		System.out.print(s2);
		System.out.print(s3);
		System.out.print(s4 + '\n');
		*/

		/* 29
		int i;
		i = Math.max(3, 5);
		System.out.println(i);
		*/

		/* 30
		double d = 5.0;
		double sqd = Math.sqrt(d);
		System.out.println(sqd);
		*/

		/* 31
		System.out.print("Enter two integers > ");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		int min = Math.min(i, j);
		System.out.println("The smaller number your entered was " + min);
		*/

		/* 32
		System.out.print("Enter three integers > ");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		int k = scanner.nextInt();
		int max = Math.max(i, Math.max(j, k));
		System.out.println("The largest number you entered was " + max);
		*/
		
		/* 33
		String stringInput = JOptionPane.showInputDialog(null, "Enter an integer");
		int intInput = Integer.parseInt(stringInput);
		intInput++;
		JOptionPane.showMessageDialog(null, "Your new value is " + intInput);
		*/

		/* 34
		double input = Double.parseDouble(JOptionPane.showInputDialog(null,
											"Enter a floating point number"));
		JOptionPane.showMessageDialog(null, "Your number squared is " + Math.pow(input, 2));
		*/

	}
}
