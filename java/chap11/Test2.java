import java.io.*;

public class Test2
{
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("data.txt",false);
			PrintWriter pw = new PrintWriter(fos);

			pw.println("hi");
			pw.close();
		}
		catch (FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}
	}
}
