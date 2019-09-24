/*	Demonstrating how ti write basic data types to a text file
	Luke
*/

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WriteGradeFile
{
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("grades.txt", true);

			PrintWriter pw = new PrintWriter(fos);

			pw.print("CS130: ");
			pw.println(95);
			pw.print("Letter grade: ");
			pw.println('A');
			pw.print("Current GPA: ");
			pw.println(3.68);
			pw.print("Successful student as of Spring semester: ");
			pw.println(true);

			pw.close();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("Unable to find grades.txt");
		}
	}
}
