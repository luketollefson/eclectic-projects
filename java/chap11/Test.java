/*	Test exercies
	Luke
*/

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Test
{
	public static void main(String[] args)
	{
		/* 37
		try
		{
			Scanner file = new Scanner(new File("data.txt"));

			String stringRead = file.nextLine();
			System.out.println(stringRead);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		*/

		/* 38
		try
		{
			Scanner file = new Scanner(new File("data.txt"));

			String stringRead = file.nextLine();
			System.out.println("string read: " + stringRead);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		*/

		/* 39
		String stringRead = "";
		try
		{
			Scanner file = new Scanner(new File("data.txt"));

			stringRead = file.nextLine();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		System.out.println("string read: " + stringRead);
		*/

		/* 40
		Scanner parse = new Scanner("1 3.5 6");
		try
		{
			while (parse.hasNext())
			{
				double number = parse.nextDouble();
				System.out.println(number);
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("In catch block");
		}
		*/

		try
		{
			Scanner file = new Scanner(new File("data.txt"));
			
			String s = file.nextLine();
			System.out.println("Line read is " + s);
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
	}
}
