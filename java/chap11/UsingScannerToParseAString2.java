import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class UsingScannerToParseAString2
{
    public static void main(String[] args)
    {
	String flightRecord1 = "AA123,BWI,SFO,235,239.5";
	Scanner parse = new Scanner(flightRecord1);

	parse.useDelimiter(",");

	try {
	    System.out.println(parse.next());
	    System.out.println(parse.next());
	    System.out.println(parse.next());
	    System.out.println(parse.nextInt());
	    System.out.println(parse.nextDouble());
	} catch (InputMismatchException ime) {
	    System.out.println("Error in data format");
	} catch (NoSuchElementException nse) {
	    System.out.println("No more tokens");
	} catch (IllegalStateException ise) {
	    ise.printStackTrace();
	}
	parse.close();
    }
}
	   
		
