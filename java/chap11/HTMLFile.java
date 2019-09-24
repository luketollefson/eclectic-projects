/*	Determins wether a file is an HTML file
	Luke
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HTMLFile
{
	public static void main(String[] args)
	{
		try
		{
			Scanner file = new Scanner(new File("index.html"));
			
			if (!file.hasNext())
			{
				System.out.println("Non HTML");
				System.exit(1);
			}

			if (!file.next().equals("<HTML>"))
			{
				System.out.println("Non HTML");
				System.exit(1);
			}

			String s = "";
			while (file.hasNext())
				s = file.next();

			if (s.equals("</HTML>"))
				System.out.println("Is HTML file");
			else
				System.out.println("Non HTML");

			file.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.getMessage());
		}
	}
}
