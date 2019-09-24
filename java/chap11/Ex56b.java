import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.regex.Pattern;

public class Ex56b
{
    public static void main(String[] args)
    {
	System.out.println("Hello");
	boolean aThings = isHTML("test.html");
	System.out.println(aThings);
    }

    public static boolean isHTML(String filename)
    {
	try
	{
	    Scanner scan = new Scanner(new File(filename));
	    scan.useDelimiter(Pattern.compile("[^<>]*"));

	    String c;
	    int lessThans = 0;
	    int greaterThans = 0;

	    while (scan.hasNext())
	    {
		c = scan.next();
		if (c.equals("<"))
		    lessThans++;
		else if (c.equals(">"))
		    greaterThans++;
	    }

	    scan.close();

	    if (lessThans == greaterThans)
		return true;
	    else
		return false;
	   
	}
	catch (FileNotFoundException fnfe)
	{
	    System.out.println(fnfe.getMessage());
	    return false;
	}
    }
    
}
