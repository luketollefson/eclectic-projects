/*	pc game
	Luke
*/

public class PCGameClient
{
	public static void main(String[] args)
	{	
		PCGame wow = new PCGame("Wow", 100, 200 ,300);
		System.out.println(wow);
	}
}

class PCGame extends Game
{
	private int ramRequired;
	private int spaceRequired;
	private double ghzRequired;

	public PCGame(String newDescription, int ram, int space, int ghz)
	{
		super(newDescription);
		ramRequired = ram;
		spaceRequired = space;
		ghzRequired = ghz;
	}

	public String toString()
	{
		return super.toString()
				+ "; ram required: " + ramRequired
				+ "; space required: " + spaceRequired
				+ "; ghz required: " + ghzRequired;
	}
}
