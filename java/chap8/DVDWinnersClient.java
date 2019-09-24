/**	Client for the DVDWinners class
	Luke
*/
import java.util.Scanner;

public class DVDWinnersClient
{
	public static void main(String[] args)
	{
		DVDWinners winningIDs = new DVDWinners();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the member's ID "
								+ "or 0 to stop > ");
		int searchID = scan.nextInt();

		while (searchID != 0)
		{
			System.out.println(winningIDs.getPrize(searchID));

			System.out.println("\nEnter the next member's ID "
									+ "or 0 to stop > ");
			searchID = scan.nextInt();
		}
		
		System.out.println("\nThe winners were "
								+ winningIDs.toString());
	}
}
