/*	Reading an integer from the user
	Luke
*/
import java.util.Scanner;

public class ReadInteger
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your age as an integer > ");
		int age = scan.nextInt();

		System.out.println("Your age is " + age);
	}
}
