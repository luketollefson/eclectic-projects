/*	Fill In The Code exercises
	Luke
*/

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class FillInTheCode
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);

		/* 21
		Random random = new Random();
		int i = random.nextInt(5) + 3;
		while (i != 5) {
			System.out.print(i + " ");
			i = random.nextInt(5) + 3;
		}
		System.out.println();
		*/

		/* 22
		System.out.print("Enter a starting integer > ");
		int start = scan.nextInt();

		String numbers = "";
		System.out.print("Enter another number > ");
		int i = scan.nextInt();
		while (i != 20)
		{
			if (i >= start)
				numbers += i + " ";

			System.out.print("Enter another number > ");
			i = scan.nextInt();
		}
		System.out.println("The numbers are: " + numbers);
		*/

		/* 23
		System.out.print("Enter an integer value, enter -1 to stop > ");
		int value = scan.nextInt();
		int sum = 0;
		while (value != -1)
		{
			sum += value;

			System.out.print("Enter an integer value, enter -1 to stop > ");
			value = scan.nextInt();
		}
		System.out.println("The sum is " + sum);
		*/

		/* 24
		int sum = 0;
		int countMultiplesOf7 = 0;
		int count = 1;

		while (countMultiplesOf7 < 4)
		{
			if (count % 7 == 0) {
				countMultiplesOf7++;
				sum += count;
			}

			count++;
		}
		System.out.println(sum);
		*/

		/* 25
		String sentence = "";
		String word;

		System.out.print("Enter a word > ");
		word = scan.next();

		while (!word.equals("end"))
		{
			sentence += word + " ";

			System.out.print("Enter a word > ");
			word = scan.next();
		}
		System.out.println("The sentence is " + sentence);
		*/

		/* 26
		Scanner file = new Scanner(new File("ints.txt"));
		int sum = 0;

		while (file.hasNext())
		{
			sum += file.nextInt();
		}
		System.out.println("The sum is: " + sum);
		*/

		/* 27
		for (int i = 0; i < 5; i++)
			System.out.println("Hi there");
		*/

		/* 28
		System.out.print("Enter number > ");
		int value = scan.nextInt();
		int sum = 0;

		while (value != 0 && value != 100)
		{
			sum += value;

			System.out.print("Enter number > ");
			value = scan.nextInt();
		}
		System.out.println("The value is " + sum);
		*/

		/* 29
		int sum = 0;
		for (int i = 1; i <= 5; i++)
			sum += i;
		System.out.println(sum);
		*/
			
	}
}
