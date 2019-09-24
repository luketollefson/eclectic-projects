/*	Checks if a string is made of the same tokens
	Luke
*/

import java.util.Scanner;

public class Ex52
{
	public static void main(String[] args)
	{
		Tokens tok = new Tokens("2,3,A3",",");
		System.out.println(tok.checkTokens(3));
	}
}

class Tokens
{
	private String string;
	private String delimiter;

	public Tokens(String s, String d)
	{
		string = s;
		delimiter = d;
	}

	// 0 = boolean, 1 = int, 2 = double, 3 = char
	public boolean checkTokens(int dataType)
	{
		Scanner scan = new Scanner(string);
		scan.useDelimiter(delimiter);
		switch (dataType)
		{
			case 0:
				while (scan.hasNextBoolean())
					scan.nextBoolean();

				if (scan.hasNext())
					return false;
				break;
			case 1:
				while (scan.hasNextInt())
					scan.nextInt();

				if (scan.hasNext())
					return false;

				break;
			case 2:
				while (scan.hasNextDouble())
					scan.nextDouble();

				if (scan.hasNext())
					return false;

				break;
			case 3:
				while (scan.hasNext())
					if (scan.next().length() != 1)
						return false;

				if (scan.hasNext())
					return false;

				break;
			default:
				System.err.println("Unrecognized option");
				return false;
		}

		return true;
	}
}
