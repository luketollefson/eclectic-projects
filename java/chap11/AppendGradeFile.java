import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class AppendGradeFile
{
    public static void main(String[] args)
    {
	try
	{
	    FileOutputStream fos = new FileOutputStream("grades.txt", true);

	    PrintWriter pw = new PrintWriter(fos);

	    pw.print("CS230: ");
	    pw.println(87);
	    pw.print("Letter grade: ");
	    pw.println('B');
	    pw.print("Current GPA: ");
	    pw.println(3.53);
	    pw.print("Successful student as of Fall semester: ");
	    pw.println(true);

	    pw.close();
	}
	catch (FileNotFoundException fnfe)
	{
	    System.out.println("Unable to find grades.txt");
	}
    }
}
