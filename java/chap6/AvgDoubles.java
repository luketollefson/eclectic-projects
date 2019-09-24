/*	finds the averages of input.txt
	Luke
*/

import java.util.Scanner;
import java.io.*;

public class AvgDoubles
{
	public static void main(String[] args) throws IOException
	{
		Scanner file = new Scanner(new File("doubles.txt"));

		int numberOfDoubles = 0;
		double total = 0;

		while (file.hasNext())
		{
			total += file.nextDouble();
			numberOfDoubles++;
		}

		if (numberOfDoubles == 0)
			System.out.println("No doubles");
		else
			System.out.println("The average is " + (total / numberOfDoubles));
	}			
}
