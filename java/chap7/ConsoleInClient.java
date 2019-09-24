/*	ConsoleIn Client
	Luke
*/
import com.jbpub.af.ConsoleIn;

public class ConsoleInClient
{
	public static void main(String[] args)
	{
		ConsoleIn console = new ConsoleIn();

		int age = console.readInt("Enter your age");
		System.out.println("Your age is " + age);
	}
}
