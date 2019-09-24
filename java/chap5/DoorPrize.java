/*	Using the conditional operator
	Luke
*/

import java.util.Scanner;

public class DoorPrize
{
	public static void main(String[] args)
	{
	Scanner scan = new Scanner(System.in);

	System.out.println("Enter 1 or 2 to pick a door: ");
	int inputNum = scan.nextInt();
	System.out.println("You entered " + inputNum + "\n");

	int door = (inputNum == 2 ? inputNum : 1);

	System.out.println("You have cosen the "
			+ (door == 1 ? "wrong" : "correct") + " door");
	}
}
